package com.company.DichotomousSearch;

/**
 * @Author ChanZany
 * @Date 2021/7/3 14:22
 * @Version 1.0
 */
public class SearchInRotatedArr {
    //若nums[mid]<nums[right]则说明右区间是排好序的,反之说明左区间是排好序的，若nums[mid] = nums[left]，将left右移，继续二分查找
    //如果目标值位于排序好的区间内，我们可以对这个区间继续二分查找，反之，我们对另一半区间继续二分查找
    public boolean search(int[] nums, int target) {
//        int n = nums.length-1;
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[l] && nums[mid] == nums[r]) {                               //无法判断哪个区间是增序的
                l++;
                r--;
            }
            else if (nums[l] <= nums[mid]) {                                //左区间是增序的
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            else {
                if (nums[mid] < target && target <= nums[r]) {              //右区间是增序的
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }




    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(new SearchInRotatedArr().search(nums, 13));
    }
}
