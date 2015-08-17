public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> used = new HashMap<Integer, Boolean>();

        for(int i = 0; i < nums.length; i++) used.put(nums[i], false);

        int longest = 0;

        for(int i = 0; i < nums.length; i++) {
            if(used.get(nums[i])) continue;

            int length = 1;
            used.put(nums[i], true);

            int j = nums[i] + 1;
            int k = nums[i] - 1;
            while(used.containsKey(j)) {
                used.put(j, true);
                length++;
                j++;
            }
            while(used.containsKey(k)) {
                used.put(k, true);
                length++;
                k--;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
