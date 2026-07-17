import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] gcdPairs = new long[max + 1];

        // Count pairs whose numbers are divisible by i
        for (int i = max; i >= 1; i--) {
            long count = 0;
            for (int j = i; j <= max; j += i) {
                count += freq[j];
            }

            gcdPairs[i] = count * (count - 1) / 2;

            // Remove pairs already counted with larger gcd multiples
            for (int j = i * 2; j <= max; j += i) {
                gcdPairs[i] -= gcdPairs[j];
            }
        }

        // Prefix sums
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + gcdPairs[i];
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            long target = queries[k] + 1; // queries are 0-indexed

            int left = 1, right = max;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] >= target)
                    right = mid;
                else
                    left = mid + 1;
            }
            ans[k] = left;
        }

        return ans;
    }
}