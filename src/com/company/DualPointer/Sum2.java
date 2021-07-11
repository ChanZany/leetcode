package com.company.DualPointer;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/2 18:57
 * @Version 1.0
 */
public class Sum2 {
    //升序排列的数组，找两数和
    //双指针查找法
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length -1;
        int sum = 0;
        while(left<right){
            sum = numbers[left] + numbers[right];
            if(target == sum) {
                break;
            }
            else if(target > sum) {
                left++;
            }else {
                right--;
            }
        }

        return new int[]{left,right};

    }

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(new Sum2().twoSum(nums, 9)));
    }
}
