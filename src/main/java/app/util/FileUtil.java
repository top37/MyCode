package app.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    private FileUtil(){}

    public static String getStrFromText(String path) {
        String str = "";
        try {
            str =  new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void mkFile(String path,String content){
        Path fpath=Paths.get(path);
        //创建文件
        if(!Files.exists(fpath)) {
            try {
                Files.createFile(fpath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Files.write(fpath, content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(getStrFromText("C:\\My\\MyContent\\First\\chapters\\section1.txt"));
    }
}
