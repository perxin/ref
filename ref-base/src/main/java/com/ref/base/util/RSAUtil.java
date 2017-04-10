package com.ref.base.util;

import com.ref.base.constant.CommonConstant;
import com.ref.base.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by perxin on 2017/4/10.
 */
public class RSAUtil {

    private static Logger log = LoggerFactory.getLogger(RSAUtil.class);

    public static final String KEY_ALGORITHM = "RSA";

    public static final String PUBLIC_KEY = "PUBLIC_KEY";

    public static final String PRIVATE_KEY = "PRIVATE_KEY";

    public static final String STR_PUBLIC_KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIBHKnZCgd1CjeA+wfOLhyK4m4AkTSArdwWuI6KzGz0U\n" +
            "7IRyy3QKSo2zFGj60hxfT0/JCLKH5T4pGm+pCAw4Mh8CAwEAAQ==";

    public static final String STR_PRIVATE_KEY = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAgEcqdkKB3UKN4D7B84uHIribgCRN\n" +
            "ICt3Ba4jorMbPRTshHLLdApKjbMUaPrSHF9PT8kIsoflPikab6kIDDgyHwIDAQABAkBP9w0bR35Z\n" +
            "BaIXxkd1oOcO1/Hnwblqcm3x1opUZD54pm55IoXV0aJehjVlmbIVH5Luj7RqaZeN8GuVm0Xh4jIh\n" +
            "AiEAusNZm1FPrb3HrnfZmRo8Ntz07JjZw6AnvgNrVwVP7wkCIQCv1VHKe6MpxqeJG+8IQ7vnMftU\n" +
            "hUVl4mHmvjw9rwq55wIgIrZucDzjt2I/vADQs/E5YeUdrOAYEZEx8dJG4Cy/l6kCIH9wIX6ay2/8\n" +
            "zfI+r6kSxn5TKHBiwyCLyh8do7WlRyXjAiBaSEbMyt7uEPzFE5X5jShKRL9pj9+In5RGgJCyK8Mi\n" +
            "2Q==";

    public static String encrypt(String str, String publicKey) {
        return new BASE64Encoder().encode(encryptToByte(str, publicKey));
    }
    public static String decrypt(String str, String privateKey) {
        return new BASE64Encoder().encode(decryptToByte(str, privateKey));
    }

    public static byte[] encryptToByte(String str, String publicKey) {
        if (StringUtils.isEmpty(publicKey)) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_CUSTOM, "公钥不能为空");
        }
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
            return cipher.doFinal(str.getBytes());
        } catch (Exception e) {
            log.error("encryptToByte error:" + e.getMessage());
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_CUSTOM, "encryptToByte error");
        }
    }

    private static byte[] decryptToByte(String str, String privateKey) {
        if (StringUtils.isEmpty(privateKey)) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_CUSTOM, "私钥不能为空");
        }
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(privateKey));
            return cipher.doFinal(str.getBytes());
        } catch (Exception e) {
            log.error("decryptToByte error:" + e.getMessage());
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_CUSTOM, "decryptToByte error");
        }
    }

    public static PublicKey getPublicKey(String strPublickey) {
        byte[] keyBates;
        try {
            keyBates = new BASE64Decoder().decodeBuffer(strPublickey);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBates);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            return keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            log.error("getPublicKey error:" + e.getMessage());
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_CUSTOM, "getPublicKey error");
        }
    }

    public static PrivateKey getPrivateKey(String strPrivatekey) {
        byte[] keyBates;
        try {
            keyBates = new BASE64Decoder().decodeBuffer(strPrivatekey);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBates);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            return keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            log.error("getPrivateKey error:" + e.getMessage());
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_CUSTOM, "getPrivateKey error");
        }
    }

    /**
     * RSA生成公钥私钥
     * @param length 密钥长度 >=512
     * @return
     */
    public static Map<String, String> generateKey(int length) {
        Map<String, String> map = new HashMap<>();
        KeyPairGenerator kpg;
        try {
            kpg = KeyPairGenerator.getInstance(KEY_ALGORITHM);
            kpg.initialize(length);
            KeyPair keyPair = kpg.genKeyPair();
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            map.put(PUBLIC_KEY, new BASE64Encoder().encode(publicKey.getEncoded()));
            map.put(PRIVATE_KEY, new BASE64Encoder().encode(privateKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_CUSTOM, "RSA generator key error");
        }
        return map;
    }

    public static void main(String[] args) {
        Map<String, String> map = generateKey(512);
        System.out.println(map.get(PUBLIC_KEY));
        System.out.println(map.get(PRIVATE_KEY));
    }
}
