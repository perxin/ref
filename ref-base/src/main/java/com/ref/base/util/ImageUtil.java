package com.ref.base.util;

import com.ref.base.exception.BusinessException;
import com.ref.base.constant.CommonConstant.ErrorCode;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by perxin on 2017/1/6.
 */
public class ImageUtil {

    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * BufferedImage转文件
     * @param bi
     * @param imagePath
     * @param imageName
     */
    public static void bufferedImageToFile(BufferedImage bi, String imagePath, String imageName) {
        String type = FileUtil.getFileExtension(imageName);
        try {
            ImageIO.write(bi, type, new File(imagePath + File.separator + imageName));
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.ERROR_CODE_CUSTOM, e.getMessage());
        }
    }

    /**
     * 压缩图片
     * @param bytes
     * @param limitSize：限制大小，单位MB
     * @return
     */
    public static byte[] compressImage(byte[] bytes, double limitSize) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        long size = bytes.length;
        if (size >= limitSize * 1024 * 1024) {
            double scale = (limitSize * 1024 * 1024f) / size;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                Thumbnails.of(bais).scale(scale).outputQuality(scale).toOutputStream(baos);
                bytes = baos.toByteArray();
            } catch (IOException e) {
                logger.error("Compress image error!", e.getMessage());
            }
        }
        return bytes;
    }

    public static void main(String[] args) throws IOException {
        byte buffer[] = FileUtil.fileToByte("E:\\IMG_1258(1).png");
        byte[] bytes = compressImage(buffer, 2);
        FileUtil.byteToFile(bytes, "E:\\", "33.png");
    }

}
