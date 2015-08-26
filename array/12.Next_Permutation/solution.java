public class Solution {
    public void nextPermutation(int[] nums) {
      int len = nums.length;
      int pivot = 0;
      int change = 0;
      if(len != 1) pivot = len - 2;
      while(pivot != 0 && nums[pivot] >= nums[pivot+1])
        pivot--;

      for(int i = len-1; i > 0; i--)
        if(nums[i] > nums[pivot]) {
          change = i;
          break;
        }

      if(change == pivot) {
        for(int i = 0; i < len/2; i++) {
          int tmp1 = nums[i];
          nums[i] = nums[len-i-1];
          nums[len-i-1] = tmp1;
        }
      } else {
        int tmp2 = nums[pivot];
        nums[pivot] = nums[change];
        nums[change] = tmp2;

        for(int i = pivot + 1; i<(len+pivot)/2+1; i++) {
          int tmp3 = nums[i];
          nums[i] = nums[len-i+pivot];
          nums[len-i+pivot] = tmp3;
        }
      }
    }
}
