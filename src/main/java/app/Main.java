package app;

import app.util.ChineseU;
import app.util.DesUtil;
import sun.security.krb5.internal.crypto.Des;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import static app.util.FileUtil.getStrFromText;

public class Main {
    public static void main(String[] args) throws Exception {
//        2a28a1a0-1243-4359-87e4-52bc5788aac
//        System.out.println(UUID.randomUUID().toString());
        String text = "汉字a汉h字,仮,名....。";
        String key = "！0）（0 ！";
        System.out.println(ChineseU.getChineseCharsCount(text));
        System.out.println(ChineseU.getChineseCharsCount(getStrFromText("C:\\My\\MyContent\\First\\chapters\\section1.txt")));

        //加密
//        System.out.println(DesUtil.encrypt(getStrFromText("C:\\My\\MyContent\\First\\chapters\\section1.txt"),key));

        //解密
//        System.out.println(DesUtil.decrypt(getStrFromText("C:\\My\\MyContent\\First\\chapters\\section1des.txt"),key));


        String content = "Hello World !!";
        Files.write(Paths.get("F:\\output.txt"), "阿强666".getBytes());
    }

}
