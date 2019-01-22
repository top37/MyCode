package app.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;

/**
 * DES加密 解密算法
 * @author zhangdi
 *
 */
public class DesUtil {

    private final static String DES = "DES";
    private final static String ENCODE = "GBK";
    // key 前八位有效
    private final static String defaultKey = "netwxactive";

    /**
     * Description 根据键值进行加密
     * @param data 待加密数据
     * @param key 密钥
     */
    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes(ENCODE), key.getBytes(ENCODE));
        return new BASE64Encoder().encode(bt);
    }

    /**
     * 根据键值进行解密
     * @param data 待解密数据
     * @param key    密钥
     */
    public static String decrypt(String data, String key) throws
            Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf, key.getBytes(ENCODE));
        return new String(bt, ENCODE);
    }

    /**
     * Description 根据键值进行加密
     *
     * @param key
     *            加密键byte数组
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     *
     * @param key 加密键byte数组
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    public static void main(String[] args){
        String data = "12AUism810安邦保险jsqASI08";
        String key ="wanlong1590464";
        System.out.println("加密前===>"+data);
        try {
//            System.err.println(encrypt(data, key));

            System.out.println(decrypt("5RMF54twfP2G5g2a72idb4PZdRhGNO56RYGAX4isQsU=","wanlong1590464"));

//            System.err.println(decrypt(encrypt(data, key), key));
//            String jiamihou = encrypt(data);
//            System.out.println("加密后===>"+jiamihou);
//            System.out.println("解密后===>"+decrypt(jiamihou));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
