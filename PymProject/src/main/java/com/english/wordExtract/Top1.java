package com.english.wordExtract;

import com.english.Utils.StringUtil;
import com.english.entity.Word;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Top1 {
    private static String wPath="";
    /**提取单词
     * @param rPath:需要读取文件的地址
     * @param wPath :需要写入的地址
     * 标准 格式为  abc [音标] 翻译
     * */
    public static List extract(String rPath, String wPath,String rMethod) throws IOException {
        ArrayList list = new ArrayList();
        //打开io
        InputStreamReader fReader = new InputStreamReader(new FileInputStream(rPath),"UTF-8");
        BufferedReader reader = new BufferedReader(fReader);
        OutputStreamWriter fWrite = new OutputStreamWriter(new FileOutputStream(wPath),"UTF-8");
        BufferedWriter writer = new BufferedWriter(fWrite);
        //读取文件
        Object obj=null;
        Word ts=null;
        while(reader.ready()){
            String line = reader.readLine();
            if(rMethod.equals("joint1")){
                obj =joint1(line);
            }else if (rMethod.equals("joint2")){
                obj =joint2(line);
            }else if(rMethod.equals("joint3")){
                obj =joint3(line,list);
            }if(obj==null)continue;
            writer.write(obj.toString());
//            list.add(obj);
        }
        return list;
    }
    /**解析格式　　单词　　音标　　汉字*/
    private static String joint1(String original){
        String after = "";
        //字符串分割,以空格
        String[] arr = original.split(" ");
        //默认情况下是这种格式  单词 音标  翻译
        String word =null;
        String soundmark = "[]";
        String cn = arr[arr.length-1];

        for(String part:arr){
            char se='0';
            if(part.toCharArray().length>0){se = part.toCharArray()[0];}
            if(se>64&&se<91||se>96&&se<123){
                //属于英文范围
                boolean test=true;
                for(char s :part.toCharArray()){
                    if(s>64&&s<91||s>96&&s<123){
                    }else{
                        test=false;
                        break;
                    }
                }
                if(test){word=part;};

            }else if(se==91||se==123){
                //属于[,{  音标 有可能音标符号旁边跟着其他 还要再次筛选
                String [] a = null;
                try{//防止他出错
                    a = part.split("]");
                    soundmark=a[0]+"]";
                }catch(Exception as){
                    System.out.println("音标的二次筛选出现异常 :"+Arrays.toString(a));
                }
            }else{
                cn=part;
            }
        }
        if(word==null){
            return null;
        }
        after=word+" "+soundmark+" "+cn+"\n";
        return after;
    }
    private static Word joint2(String original){
        String after = "";
        //字符串分割,以空格
        String[] arr = original.split(" ");
        //默认情况下是这种格式  单词 音标  翻译
        String word =null;
        String soundmark = "[]";
        String cn = arr[arr.length-1];

        for(String part:arr){
            char se='0';
            if(part.toCharArray().length>0){se = part.toCharArray()[0];}
            if(se>64&&se<91||se>96&&se<123){
                //属于英文范围
                boolean test=true;
                for(char s :part.toCharArray()){
                    if(s>64&&s<91||s>96&&s<123){
                    }else{
                        test=false;
                        break;
                    }
                }
                if(test){word=part;};

            }else if(se==91||se==123){
                //属于[,{  音标 有可能音标符号旁边跟着其他 还要再次筛选
                String [] a = null;
                try{//防止他出错
                    a = part.split("]");
                    soundmark=a[0]+"]";
                }catch(Exception as){
                    System.out.println("音标的二次筛选出现异常 :"+Arrays.toString(a));
                }
            }else{
                cn=part;
            }
        }
        if(word==null){
            return null;
        }
        Word word1 = new Word(word,soundmark,cn);
        return word1;
    }

    /**解析格式  只解析和提取英文  */
    public static List joint3(String original,List  list){
        String part=original;
        String[] parts;
        part = part.replace(',',' ');
        part = part.replace('-',' ');
//        part = StringUtil.deleteStringChar(original,',');
//        part = StringUtil.deleteStringChar(part,'"');
//        part = StringUtil.deleteStringChar(part,'、');
//        part = StringUtil.deleteStringChar(part,'-');
        parts = part.split(" ");
        for(String p:parts){
            if(p.equals(""))continue;
            part = StringUtil.deleteStringChar(part,'[');
            part = StringUtil.deleteStringChar(part,']');
            boolean is =true;
            byte[] bit = p.getBytes();//获得字节
            for(byte b:bit){
                if(b>64&&b<91||b>96&&b<123){}else{is=false; break;}
            }
            if(is){
                list.add(p);
            }
        }
       return list;
    }

}
