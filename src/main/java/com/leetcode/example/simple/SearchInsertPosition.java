package com.leetcode.example.simple;
/**
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

        你可以假设数组中无重复元素。

        示例 1:

        输入: [1,3,5,6], 5
        输出: 2
        示例 2:

        输入: [1,3,5,6], 2
        输出: 1
        示例 3:

        输入: [1,3,5,6], 7
        输出: 4
        示例 4:

        输入: [1,3,5,6], 0
        输出: 0

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/search-insert-position
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 7;

        int i = searchInsert2(nums, target);
        System.out.println(i);

    }

    /**
     * 因为是有序的  所以可以用二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        if(null == nums || nums.length <= 0){
            return 0;
        }
        int left = 0;
        int right = nums.length;
        while (left < right){
            //  防止 right + left 数值大于int溢出    (right + left)/2 有可能会数值溢出
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if(left >= nums.length){
            return left;
        }
        return target <= nums[left]?left:left + 1;
    }

    /**
     * 普通遍历
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if(null == nums || nums.length <= 0){
            return 0;
        }
        int k = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int j = nums[i];
            if(j == target){
                return i;
            }
            if(target > j){
                k += 1;
            }
        }
        return k;
    }
}
