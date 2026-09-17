class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxWater = 0;

        while (left < right) {

            // Calculate width
            int width = right - left;

            // Container height is limited by the smaller line
            int currentHeight = Math.min(height[left], height[right]);

            // Calculate current area
            int area = width * currentHeight;

            // Update maximum
            maxWater = Math.max(maxWater, area);

            // Move the smaller line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}