package app.util;

public class ChineseU {

    private ChineseU(){}

    public static int getChineseCharsCount(String text){
        String Reg = "^[\u4e00-\u9fa5]{1}$";//正则
        int result = 0;
        for (int i = 0; i < text.length(); i++) {
            String b = Character.toString(text.charAt(i));
            if (b.matches(Reg)) result++;
        }
        return result;
    }
}
