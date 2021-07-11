package com.company.Greedy;

/**
 * @Author ChanZany
 * @Date 2021/7/2 12:49
 * @Version 1.0
 */
public class Demo {
    // i>0; if nums[i]<nums[i-1] -> nums[i-1]=nums[i] cnt++  cnt>1 return false
    // [4,2,3] -> [2,2,3] 递增
    // [3,4,2,3] 如果按照上面的规则，变换后为[3,2,2,3]，显然不是递增的，说明需要增加额外的判断使得每一步都走的正确
    // i=1; if nums[i]<nums[i-1] -> nums[i-1]=nums[i] cnt++
    // i>1; if nums[i]<nums[i-1]:
    //              if nums[i]<nums[i-2] -> nums[i] = nums[i-1]   [3,4,2,3]->[3,4,4,3], [3,4,4,3]->[3,4,4,4]
    //              else nums[i-1] = nums[i]
    // cnt>1 return false
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (i == 1) {
                    nums[i - 1] = nums[i];
                } else {
                    if (nums[i] < nums[i - 2]) {
                        nums[i] = nums[i - 1];
                    } else {
                        nums[i - 1] = nums[i];
                    }
                }
                cnt++;
            }
        }
        return cnt <= 1;
    }
}
