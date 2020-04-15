/**
 * @title: TwoSumDemo1
 * @projectName leetcode-answer
 * @description: TODO
 * @author zc
 * @date 2020/4/1510:14
 */
package com.leetcode.example.simple;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class TwoSumDemo {

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{3,2,4};
        int target = 6;

        int[] ints = twoSum(nums, target);
        System.out.println(JSONObject.toJSONString(ints));

        int[] ints1 = twoSum1(nums, target);
        System.out.println(JSONObject.toJSONString(ints1));

        int[] ints2 = twoSum2(nums, target);
        System.out.println(JSONObject.toJSONString(ints2));
    }

    /**
     *  暴力穷举
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] num = null;
        lable:
        for(int i = 0 ;i<nums.length;i++){
            for(int j = 0 ;j<nums.length;j++){
                if(((nums[i] + nums[j]) == target) && i != j){
                    num = new int[]{i,j};
                    break lable ;
                }
            }
        }
        return num;
    }

    /**
     * 两遍hash
     */
    public static int[] twoSum1(int[] nums, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int num = target - nums[i];
            if(map.containsKey(num) && map.get(num) != i){
                return new int[]{i, map.get(num)};
            }
        }
        throw new RuntimeException("not twoSum solution");
    }

    /**
     * 一遍hash
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = target - nums[i];
            if(map.containsKey(num) && map.get(num) != i){
                return new int[]{i, map.get(num)};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("not twoSum solution");
    }




}
