package app;

import app.util.ChineseU;
import app.util.DesUtil;
import lombok.extern.slf4j.Slf4j;

import static app.util.FileUtil.getStrFromText;
import static app.util.FileUtil.mkFile;
import static app.util.StaticStr.chapter1;
import static app.util.StaticStr.outChapter1;

@Slf4j
public class Main {

    private static final Integer i = 1;
    private static final String key = "";

    public static void main(String[] args) throws Exception {
//        加密(i,key);

        解密(i,key);
    }


    private static void 加密(String chapter,String name,String key,String fromFile) throws Exception {
        log.info("----------加密 开始----------");
        String content = getStrFromText(fromFile);
        log.info("文章汗字数(不含标点和英文)为："+ChineseU.getChineseCharsCount(content));
        String enContent = DesUtil.encrypt(content,key);
        mkFile(chapter+name,enContent);

        log.info("----------加密 结束----------");
    }

    private static void 加密(Integer i,String key) throws Exception {
        加密(chapter1,"section"+i+"加密.txt",key, outChapter1+"section"+i+".txt");
    }

    private static void 解密(Integer i,String key) throws Exception {
        log.info("----------解密 开始----------");
        String content = DesUtil.decrypt(getStrFromText(chapter1+"section"+i+"加密.txt"),key);
        log.info("----------解密 如下----------");
        System.out.println(content);
    }
}

