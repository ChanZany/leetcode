package com.company.DichotomousSearch;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/3 11:56
 * @Version 1.0
 */
public class FindPartition {
    /**
     * 如果要找第一个等于target的元素，那么就需要在nums[mid]==target的时候看一下前面的那个元素是否也等于target
     * 如果要找的是最后一个等于target的元素，那么就需要在nums[mid]==target的时候看后一个元素是否等于target
     */
    public int[] searchRange1(int[] nums, int target) {
        int first = searchFirst(nums, target);
        int last = searchLast(nums, target);
        return new int[]{first, last};
    }

    private int searchFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else {
                // 如果当前元素已经是数组的第一个元素了，那么无需再向前看了，直接返回
                // 如果不是第一个元素，则需要看看前面是否还有元素满足条件
                if (mid == 0 || nums[mid - 1] != target) return mid;
                else r = mid - 1;
            }
        }
        return -1;
    }

    private int searchLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else {
                // 如果当前元素已经是数组的最后一个元素了，那么无需再向后看了，直接返回
                // 如果不是最后一个元素，则需要看看后面是否还有元素满足条件
                if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
                else l = mid + 1;
            }
        }
        return -1;
    }

    /*
    考虑 target 开始和结束位置，其实我们要找的就是数组中
    「第一个等于target 的位置」（记为 firstIdx）和
    「第一个大于target 的位置减一」（记为 lastIdx）。
    二分查找中，寻找 firstIdx 即为在数组中寻找第一个大于等于 target 的下标，寻找 lastIdx 即为在数组中寻找第一个大于 target 的下标，然后将下标减一。
    两者的判断条件不同，为了代码的复用，我们定义 binarySearch(nums, target, lower)表示在 nums 数组中二分查找 target 的位置，
    如果 lower 为 true，则查找第一个大于等于 target 的下标，
    否则查找第一个大于 target 的下标。
    * */
    public int[] searchRange(int[] nums, int target) {
        int firstIdx = binarySearch(nums, target, true);
        int lastIdx = binarySearch(nums, target, false) - 1;
        if (firstIdx == nums.length || nums[firstIdx] != target) return new int[]{-1, -1};
        return new int[]{firstIdx, lastIdx};
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new FindPartition().searchRange(nums, 8)));
    }


}
