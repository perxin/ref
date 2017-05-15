package com.ref.service.impl.system;

import com.github.pagehelper.PageInfo;
import com.ref.Resources.system.FileService;
import com.ref.base.exception.BusinessException;
import com.ref.base.util.EntityUtil;
import com.ref.dao.system.FileMapper;
import com.ref.dao.user.UserMapper;
import com.ref.model.system.File;
import com.ref.model.user.IntegralRecord;
import com.ref.model.user.User;
import com.ref.service.user.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IntegralService integralService;

    private static String path = "D:\\file";

    @Override
    public File saveFile(File file) throws BusinessException {
        EntityUtil.insertBefore(file, file.getCreateBy());
        fileMapper.insertSelective(file);
        integralService.addIntegral(new IntegralRecord(file.getCreateBy(), 10, "上传文件"));
        return file;
    }

    @Override
    public List<File> getFile(Long relationId, String relationType) throws BusinessException {
        return fileMapper.selectByRelationIdAndType(relationId, relationType);
    }

    @Override
    public void delete(Long id, Long userId) throws BusinessException {
        File file = new File();
        file.setId(id);
        file.setDeleted(true);
        EntityUtil.updateBefore(file, userId);
        fileMapper.updateByPrimaryKeySelective(file);
    }

    @Override
    public void upload(byte[] bytes, Long userId, String name, long size) {
        File file = new File();
        file.setFileUrl(path + "\\" + name);
        file.setFileName(name);
        file.setFileSize(String.valueOf(size));
        file.setCreateBy(userId);
        saveFile(file);
    }

    @Override
    public PageInfo<File> getPage(File file) throws BusinessException {
        PageInfo<File> pageInfo = new PageInfo<>(fileMapper.selectSelective((File) file.startPage()));
        for (File recoder : pageInfo.getList()) {
            User user = userMapper.selectByPrimaryKey(recoder.getCreateBy());
            recoder.setUserName(user.getName());
        }
        return pageInfo;
    }

    @Override
    public String getFileUrl(Long id) {
        File file = fileMapper.selectByPrimaryKey(id);
        return file.getFileUrl();
    }

    @Override
    public File getFile(Long id) {
        return fileMapper.selectByPrimaryKey(id);
    }
}
