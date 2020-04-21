package com.leetcode.example.simple;
/**
实现 strStr() 函数。

        给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

        示例 1:

        输入: haystack = "hello", needle = "ll"
        输出: 2
        示例 2:

        输入: haystack = "aaaaa", needle = "bba"
        输出: -1
        说明:

        当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

        对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/implement-strstr
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class ImplementStrstr {

    public static void main(String[] args) {
        String haystack = ""; String  needle = "";

        int i = strStr1(haystack, needle);
        System.out.println(i);

    }

    /**
     * 第一反应  遍历字符串比较
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(null == needle || "".equals(needle) ){
            return 0;
        }
        if(haystack.length() == needle.length() ){
            if(haystack.equals(needle)){
                return 0;
            }else{
                return -1;
            }
        } else if(haystack.length() < needle.length() ){
            return -1;
        }
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();
        int len = chars1.length;
        int eatch = chars.length - len;
        for(int i = 0 ; i <= eatch;i++){
            String s = new String(chars, i, len);
            if(s.equals(needle)){
                return i ;
            }
        }
        return -1;
    }

    /**
     *  遍历字符串比较 进化
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr1(String haystack, String needle) {
        int h = haystack.length(), n = needle.length();
        for(int i = 0 ; i < h - n + 1; ++i){
            if(haystack.substring(i,i + n).equals(needle)){
                return i;
            }
        }
        return -1;
    }

}
