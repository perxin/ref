package com.ref.base.util;

import com.ref.base.constant.CommonConstant.ErrorCode;
import com.ref.base.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by perxin on 2017/1/6.
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 文件转字节
     * @param filePath
     * @return
     */
    public static byte[] fileToByte(String filePath) {
        File file = new File(filePath);
        FileInputStream fis = null;
        byte buf[] = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new BusinessException(ErrorCode.ERROR_CODE_CUSTOM, e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        buf = inputStreamToByte(fis);
        return buf;
    }

    /**
     * 字节转文件
     * @param buf
     * @param filePath
     * @param fileName
     */
    public static void byteToFile(byte buf[], String filePath, String fileName) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        File dir = new File(filePath);
        if (!dir.exists() && dir.isDirectory()) {
            dir.mkdirs();
        }
        File file = new File(filePath + File.separator + fileName);
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
        } catch (IOException e) {
            logger.error("File write Error", e.getMessage());
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    logger.error("FileOutputStream close Error", e.getMessage());
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    logger.error("BufferedOutputStream close Error", e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * InputStream转字节
     * @param inputStream
     * @return
     */
    public static byte[] inputStreamToByte(InputStream inputStream) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte buf[] = new byte[1024];
        int n = 0;
        try {
            while ((n = inputStream.read(buf)) != -1) {
                baos.write(buf, 0, n);
            }
            baos.close();
        } catch (IOException e) {
            logger.error("InputStream to byte[] error", e.getMessage());
            e.printStackTrace();
        }
        byte bytes[] = baos.toByteArray();
        return bytes;
    }

    /**
     * 字节转InputStream
     * @param bytes
     * @return
     */
    public static InputStream byteToInputStream(byte[] bytes) {
        ByteArrayInputStream buf = new ByteArrayInputStream(bytes);
        return buf;
    }

    /**
     * 获取文件扩展名
     * @param fileName
     * @return
     */
    public static String getFileExtension(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return null;
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(0.0f / 0.0f);
    }
}
