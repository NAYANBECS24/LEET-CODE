import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int required = target - nums[i];

            // Check if required value already exists
            if (map.containsKey(required)) {
                return new int[] { map.get(required), i };
            }

            // Store number and its index
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}