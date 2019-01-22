package app.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;

public class Jjm1 {

    private static byte[] salt;
    private static String pswd;
    private static String instanceStr;
    private static Key key;
    private static Cipher cipher;
    private static PBEParameterSpec pbeParameterSpec;

    static {
        salt = "单强sq".getBytes(); //盐
        pswd = "god5437"; //口令
        instanceStr = "PBEWITHMD5andDES";
        init();
    }

    public static void init() {
        try
        {
            PBEKeySpec pbeKeySpec=new PBEKeySpec(pswd.toCharArray());
            SecretKeyFactory factory=SecretKeyFactory.getInstance(instanceStr);
            key=factory.generateSecret(pbeKeySpec);  //密钥
            cipher=Cipher.getInstance(instanceStr);
            pbeParameterSpec=new PBEParameterSpec(salt, 100);   //参数规范，第一个参数是盐，第二个是迭代次数（经过散列函数多次迭代）
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static String jjm(String content,int mode){
        byte[] result = {};
        try {
            //加密 - Cipher.ENCRYPT_MODE = 1| 解密 - Cipher.DECRYPT_MODE = 2
            cipher.init(mode, key,pbeParameterSpec);
            result = cipher.doFinal(content.getBytes());
            System.out.println("jdk PBE加密: "+Base64.encodeBase64String(result));

            cipher.init(Cipher.DECRYPT_MODE, key,pbeParameterSpec);
            result = cipher.doFinal(result);
            System.out.println("jdk PBE解密: "+new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(result);
    }


}

