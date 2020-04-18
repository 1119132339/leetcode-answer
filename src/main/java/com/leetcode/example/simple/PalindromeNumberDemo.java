/**
 * @title: PalindromeNumberDemo
 * @projectName leetcode-answer
 * @description: TODO
 * @author zc
 * @date 2020/4/1514:45
 */
package com.leetcode.example.simple;

/**
9. 回文数
        判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
        示例 1:
        输入: 121
        输出: true
        示例 2:
        输入: -121
        输出: false
        解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
        示例 3:
        输入: 10
        输出: false
        解释: 从右向左读, 为 01 。因此它不是一个回文数。
        进阶:
        你能不将整数转为字符串来解决这个问题吗？
        https://leetcode-cn.com/problems/palindrome-number/
        */
public class PalindromeNumberDemo {

    public static void main(String[] args) {
        int x = 123;

        boolean b = isPalindrome(x);
        System.out.println(b);

        boolean b1 = isPalindrome2(x);
        System.out.println(b1);
    }

    /**
     * 简单实现  字符串倒转
     */
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        String str2 = x + "";
        StringBuilder str = new StringBuilder(x + "");
        str.reverse();
        if(str2.equals(str.toString())){
            return true;
        }
        return false;
    }

    /**
     * 不转字符第一个想到的就是倒转数字
     */
    public static boolean isPalindrome2(int x) {
        // 排除0
        if(x == 0){
            return true;
        }
        // 小于0  和 10的倍数 肯定不是
        if(x < 0 || (x % 10) == 0){
            return false;
        }
        // 其余情况 开始调转数字
        int n = 0 ;
        int temp = x;
        while (x != 0){
            n = n * 10 + x%10;
            x = x / 10;
        }
        return n == temp ? true: false;
    }




}
