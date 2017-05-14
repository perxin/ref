package com.ref.resources.system;

import com.github.pagehelper.PageInfo;
import com.ref.Resources.system.FileService;
import com.ref.base.exception.BusinessException;
import com.ref.base.model.BaseResult;
import com.ref.base.util.FileUtil;
import com.ref.constant.PathConstants;
import com.ref.model.system.File;
import com.ref.resources.BaseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class FileResource extends BaseResource {

    @Autowired
    FileService fileService;

    private static String path = "D:\\file";

    @ResponseBody
    @RequestMapping(PathConstants.ROUTE_FILE_UPLOAD)
    public BaseResult upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        try {
            byte[] buf = FileUtil.inputStreamToByte(file.getInputStream());
            FileUtil.byteToFile(buf, path, file.getOriginalFilename());
            fileService.upload(null, getUserId(request), file.getOriginalFilename(), file.getSize());
            return successResult();
        } catch (BusinessException e) {
            return erroResult(e.getDescription());
        } catch (IOException e) {
            return erroResult(e.getMessage());
        }
    }

    @RequestMapping(PathConstants.ROUTE_FILE_PAGE)
    public ModelAndView getPage(File file) {
        PageInfo<File> page = fileService.getPage(file);
        ModelAndView view = new ModelAndView();
        view.setViewName("/filePage");
        view.addObject("page", page);
        return view;
    }

    @RequestMapping(PathConstants.ROUTE_FILE_DOWNLOAD)
    public void download(HttpServletRequest request, HttpServletResponse response, Long id) {
        File file = fileService.getFile(id);
        String downLoadPath = file.getFileUrl();
                response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;

            String ctxPath = request.getSession().getServletContext()
                    .getRealPath("/");

            long fileLength = new java.io.File(downLoadPath).length();

            response.setHeader("Content-disposition", "attachment; filename="
                    + new String(file.getFileName().getBytes("utf-8"), "ISO8859-1"));
            response.setHeader("Content-Length", String.valueOf(fileLength));

            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            bis.close();
            bos.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
