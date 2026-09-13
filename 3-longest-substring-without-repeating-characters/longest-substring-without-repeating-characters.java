import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // If character already exists in current window,
            // move left pointer after its previous position
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            // Store/update the latest index
            map.put(ch, right);

            // Current window length
            int length = right - left + 1;

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}