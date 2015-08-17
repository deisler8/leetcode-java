public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        int target = 0;

        for(int i = 0; i<nums.length - 2; i++) {
            int j = i + 1;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int k = nums.length - 1;
            while(j < k) {
              if(nums[i] + nums[j] + nums[k] < target) {
                  j++;
                  while(nums[j] == nums[j-1] && j < k) j++;
              } else if(nums[i] + nums[j] + nums[k] > target) {
                  k--;
                  while(nums[k] == nums[k+1] && j < k) k--;
              } else {
                  result.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
                  j++;
                  k--;
                  while(nums[j] == nums[j-1] && j < k) j++;
                  while(nums[k] == nums[k+1] && j < k) k--;
              }
            }
        }
        return result;
    }
}
