public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(len < 4) return result;
        Arrays.sort(nums);
        for(int i = 0; i < len-3; i++) {
            for(int j = i+1; j < len-2; j++) {
                int k = j+1;
                int l = len-1;
                while(k < l) {
                    if(nums[i]+nums[j]+nums[k]+nums[l] < target) {
                        k++;
                        while(nums[k] == nums[k-1] && k < l) k++;
                    } else if(nums[i]+nums[j]+nums[k]+nums[l] > target) {
                        l--;
                        while(nums[l] == nums[l+1] && k < l) l--;
                    } else {
                        List<Integer> item = new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        if(!result.contains(item)) {
                            result.add(item);
                        }
                        k++;
                        l--;
                        while(nums[k] == nums[k-1] && nums[l] == nums[l+1] && k < l) k++;
                    }
                }
            }
        }
        return result;
    }
}
