package com.english.Utils;

public class StringUtil {


    //删除指定字符
    public static String deleteStringChar(String string,char ch){
        StringBuffer stringBuffer = new StringBuffer(string);
        char[] chars = string.toCharArray();
        for(int a=0;a<stringBuffer.length();a++){
            if(ch==stringBuffer.charAt(a)){
                stringBuffer.deleteCharAt(a);
                a--;
            }
        }
        return stringBuffer.toString();
    }
}
