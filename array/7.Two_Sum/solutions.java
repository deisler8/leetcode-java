public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                if(i < map.get(target - nums[i])) {
                    return new int[]{i + 1, map.get(target - nums[i]) + 1};
                } else if (i > map.get(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]) + 1, i + 1};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
