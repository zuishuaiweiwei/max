package com.wei;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 *
 * @author 为为
 * @create 9/17
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        int i =0;
        char oldChar = ' ';
        char[] buf =new char[100];
        int j =0;
        while(i <= chars.length-1){
            if(chars[i] == oldChar){
                buf[j++] = '%';
                buf[j++] = '2';
                buf[j] = '0';
            }else{
                buf[j] = chars[i];
            }
            i++;
            j++;

        }
        return new String(buf,0,j);
    }

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("We Are Happy");
        System.out.println(new ReplaceSpace().replaceSpace(buffer));
    }
}