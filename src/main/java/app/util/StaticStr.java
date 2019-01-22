package app.util;

import java.io.File;

public class StaticStr {

    public static final String codePath = System.getProperty("user.dir");
    public static final String resourcePath = codePath + File.separator + "main" + File.separator + "resources";

    public static void main(String[] args) {
        System.out.println(resourcePath);
    }
}
