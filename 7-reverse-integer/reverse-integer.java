class Solution {
    public int reverse(int x) {

        int result = 0;

        while (x != 0) {

            // Get last digit
            int digit = x % 10;

            // Check overflow before result * 10 + digit
            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 ||
                (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            // Add digit
            result = result * 10 + digit;

            // Remove last digit
            x /= 10;
        }

        return result;
    }
}