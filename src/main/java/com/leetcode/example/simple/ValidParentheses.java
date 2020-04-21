package com.leetcode.example.simple;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true
 示例 3:

 输入: "(]"
 输出: false
 示例 4:

 输入: "([)]"
 输出: false
 示例 5:

 输入: "{[]}"
 输出: true

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
    public static void main(String[] args) {

        String s = "{}";

        boolean valid = isValid(s);
        System.out.println(valid);

    }

    static Map<Character, Character> map ;
    static {
        map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
    }

    public static boolean isValid(String s) {
        if(null == s ||  s.length()%2 != 0){
            return false;
        }
        if("".equals(s)){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i< s.length();i++){
            char c = s.charAt(i);

            if(map.containsKey(c)){
                // 如果存在 则说明栈内一定有对应括号
                // 取出栈顶元素匹配
                Character top = stack.isEmpty() ? '#' : stack.pop();
                if(!top.equals(map.get(c))){
                    return false;
                }
            }else{
                stack.push(c);
            }

        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }


}
