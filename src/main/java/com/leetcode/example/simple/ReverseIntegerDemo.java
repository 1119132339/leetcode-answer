/**
 * @title: ReverseIntegerDemo
 * @projectName leetcode-answer
 * @description: TODO
 * @author zc
 * @date 2020/4/1511:46
 */
package com.leetcode.example.simple;


/**
7. 整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:
输入: 123
输出: 321
 示例 2:
输入: -123
输出: -321
示例 3:
输入: 120
输出: 21
注意:
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 https://leetcode-cn.com/problems/reverse-integer/
*/
public class ReverseIntegerDemo {
    public static void main(String[] args) {
        int i = 123456;

        int reverse = reverse(i);
        System.out.println(reverse);

    }

    /**
     * 利用int
     * 用String 反转也可以  但是对于溢出需要增加额外判断
     */
    public static int reverse(int x) {
        long n = 0;
        while (x != 0){
            n = n * 10 + x%10;
            x = x / 10;
        }
        return ((int)n == n)?(int)n:0;
    }



}
