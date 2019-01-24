package app.util;

import java.io.File;

public class StaticStr {


    public static final String codePath = System.getProperty("user.dir");
    public static final String resourcePath = codePath + File.separator  + "src" + File.separator + "main" + File.separator + "resources";
    public static final String chapter1 = resourcePath + File.separator + "chapter1" + File.separator;
    public static final String outChapter1 = "F:\\My" + File.separator + "MyContent" + File.separator + "chapters" + File.separator;

    public static void main(String[] args) {
        System.out.println(resourcePath);
        System.out.println(chapter1);
    }
}
