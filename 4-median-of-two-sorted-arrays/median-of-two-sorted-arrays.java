class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary-search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        // Number of elements that should be on the left side
        int half = (m + n + 1) / 2;

        while (left <= right) {

            int cut1 = (left + right) / 2;
            int cut2 = half - cut1;

            // Left and right values around the partitions
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            // Correct partition
            if (l1 <= r2 && l2 <= r1) {

                // Odd total length
                if ((m + n) % 2 == 1) {
                    return Math.max(l1, l2);
                }

                // Even total length
                return (Math.max(l1, l2) + (double) Math.min(r1, r2)) / 2.0;
            }

            // We took too many elements from nums1
            else if (l1 > r2) {
                right = cut1 - 1;
            }

            // We took too few elements from nums1
            else {
                left = cut1 + 1;
            }
        }

        return 0.0;
    }
}