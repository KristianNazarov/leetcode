package searchinsertposition;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class Solution {
    public int searchInsert(int[] nums, int target) {

        int res = Integer.MAX_VALUE;
        int len = nums.length;
        int low = 0;
        int high = len -1;


        if(target <= nums[low])
            return 0;
        if(target > nums[high])
            return high + 1;
        if(target == nums[high])
            return high;


        while (low <= high)
        {
            int mid =  low + (high - low) / 2;

            if (high == low + 1) {
                res = high;
                break;
            }
            else if(nums[mid] < target) {
                low = mid;
            }
            else if (nums[mid] >  target) {
                high = mid;
            }
            else if (nums[mid] == target) {
                res =  mid;
                break;
            }
        }

        return res;
    }

    @Test
    public void test1() {
        int[] nums = {1,3,5,6};
        int target = 5;

        assertEquals(2, searchInsert(nums, target));
    }

    @Test
    public void test2() {
        int[] nums = {1,3,5,6};
        int target = 2;

        assertEquals(1, searchInsert(nums, target));
    }

    @Test
    public void test3() {
        int[] nums = {1,3,5,6};
        int target = 7;

        assertEquals(4, searchInsert(nums, target));
    }

    @Test
    public void test4() {
        int[] nums = {1,3};
        int target = 1;

        assertEquals(0, searchInsert(nums, target));
    }

}


