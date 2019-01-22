package app.util;

import java.io.IOException;
import java.nio.file.Files;
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

    public static void main(String[] args) {
        System.out.println(getStrFromText("C:\\My\\MyContent\\First\\chapters\\section1.txt"));
    }
}
