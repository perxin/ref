package com.ref.base.util;

import com.ref.base.constant.CommonConstant;
import com.ref.base.exception.BusinessException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by perxin on 2017/4/10.
 */
public class RSAUtil {

    private static Logger log = LoggerFactory.getLogger(RSAUtil.class);

    private static final String UTF_8 = "UTF-8";

    public static final String RSA = "RSA";

    public static final String PUBLIC_KEY = "PUBLIC_KEY";

    public static final String PRIVATE_KEY = "PRIVATE_KEY";

    private static final int MAX_ENCRYPT_BLOCK = 117;//加密最大长度

    private static final int MAX_DECRYPT_BLOCK = 128;//解密最大长度

    public static final String STR_PUBLIC_KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtOdZPhO50LRt1A/yGmB493mNd7NAYCJHtfK7Dxpn9D\n" +
            "S8IsQkQKG8QRbTbbMDM4jCFd0ltm9wE8DHTCW3gzM6kCAwEAAQ==";

    public static final String STR_PRIVATE_KEY = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEAq051k+E7nQtG3UD/IaYHj3eY13s0\n" +
            "BgIke18rsPGmf0NLwixCRAobxBFtNtswMziMIV3SW2b3ATwMdMJbeDMzqQIDAQABAkEAnQ7kMd7Q\n" +
            "vx01rWkIARut1tV55iXo/pE8TXhmIGaNliLm2HDPWoZVrRQAyeUuXNoNrNqzJYDvD1ap0o+st+oc\n" +
            "uQIhANZ+Uksv+clr04R3ueVQadz8Bd40gpKwStvStmv+T5DvAiEAzHS4tUXJK2FPRplA+RMWFJPR\n" +
            "e19pkxZi3YNFPji3VOcCIQC9kT0oCEmp86sn+yyHd69oSDDjduMjw70VVMA257bobwIgbIjRvLjt\n" +
            "D7A6izmzugUdxZKqs5l0y/YoSXrz+RHWkKUCIQCfCQYndCsSq8z4e1wPvuu2YmhdBuR8vuwaou6w\n" +
            "xcOjow==";

    public static String encryptByPublicKey(String ming, String publicKey) {
        byte[] keys = Base64.decodeBase64(publicKey);//公钥 Base64解码 获取二进制数据
        byte[] mi = encryptByPublicKey(ming.getBytes(), keys);
        //这里密文出去的时候做了Base64转码,防止二进制数组byte[] 数据丢失
        return Base64.encodeBase64String(mi);
    }

    public static String decryptByPrivateKey(String mi, String privateKey) {
        try {
            byte[] keys = Base64.decodeBase64(privateKey);//私钥 Base64解码 获取二进制数据
            //这里密文进来的时候做Base64解码,还原成二进制数组byte[] 数据
            byte[] miBytes = Base64.decodeBase64(mi);
            return new String(decryptByPrivateKey(miBytes, keys), UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("decrypt RSA error", e);
        }
    }

    private static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) {
        byte[] result = null;
        try {
            X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKey);
            KeyFactory factory = KeyFactory.getInstance(RSA);
            Key publicK = factory.generatePublic(spec);
            Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicK);
            int len = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] cache;
            int offset = 0;
            int i = 0;
            //加密的时候，明文超过117字节，分组加密拼接
            while (len - offset > 0) {
                if (len - offset > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offset, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offset, len - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * MAX_ENCRYPT_BLOCK;
            }
            result = out.toByteArray();
            out.close();
        } catch (Exception e) {
            throw new RuntimeException("encrypt RSA error", e);
        }
        return result;
    }

    private static byte[] decryptByPrivateKey(byte[] data, byte[] privateKey) {
        byte[] result = null;
        try {
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey);
            KeyFactory factory = KeyFactory.getInstance(RSA);
            Key privateK = factory.generatePrivate(spec);
            Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
            //Cipher cipher = Cipher.getInstance(factory.getAlgorithm() + "/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateK);

            int len = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offset = 0;
            byte[] cache;
            int i = 0;
            //解密的时候，密文超过128字节，分组解密拼接
            while (len - offset > 0) {
                if (len - offset > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offset, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offset, len - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * MAX_DECRYPT_BLOCK;
            }
            result = out.toByteArray();
            out.close();
        } catch (Exception e) {
            throw new RuntimeException("decrypt RSA error", e);
        }
        return result;
    }

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
            Cipher cipher = Cipher.getInstance(RSA);
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
            Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(privateKey));
            return cipher.doFinal(str.getBytes());
        } catch (Exception e) {
            log.error("decryptToByte error:" + e);
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_CUSTOM, "decryptToByte error");
        }
    }

    public static PublicKey getPublicKey(String strPublickey) {
        byte[] keyBates;
        try {
            keyBates = new BASE64Decoder().decodeBuffer(strPublickey);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBates);
            KeyFactory keyFactory = KeyFactory.getInstance(RSA);
            return keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            log.error("getPublicKey error:" + e);
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_CUSTOM, "getPublicKey error");
        }
    }

    public static PrivateKey getPrivateKey(String strPrivatekey) {
        byte[] keyBates;
        try {
            keyBates = new BASE64Decoder().decodeBuffer(strPrivatekey);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBates);
            KeyFactory keyFactory = KeyFactory.getInstance(RSA);
            return keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            log.error("getPrivateKey error:" + e);
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
            kpg = KeyPairGenerator.getInstance(RSA);
            kpg.initialize(length);
            KeyPair keyPair = kpg.genKeyPair();
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            map.put(PUBLIC_KEY, new BASE64Encoder().encode(publicKey.getEncoded()));
            map.put(PRIVATE_KEY, new BASE64Encoder().encode(privateKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            log.error("RSA generatekey error:" + e);
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_CUSTOM, "RSA generatekey error");
        }
        return map;
    }

    public static void main(String[] args) {
//        Map<String, String> map = generateKey(512);
//        System.out.println(map.get(PUBLIC_KEY));
//        System.out.println(map.get(PRIVATE_KEY));

        String mi = encryptByPublicKey("123", STR_PUBLIC_KEY);
        System.out.println(mi);
        String ming = decryptByPrivateKey(mi, STR_PRIVATE_KEY);
        System.out.println(ming);
    }
}
