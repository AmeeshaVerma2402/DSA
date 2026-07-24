import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        // Remove duplicates
        HashSet<Integer> unique = new HashSet<>();
        for (int x : nums) {
            unique.add(x);
        }

        int[] vals = new int[unique.size()];
        int idx = 0;
        for (int x : unique) {
            vals[idx++] = x;
        }

        final int MAX = 2048;

        // Store all possible XORs of two numbers
        boolean[] pair = new boolean[MAX];
        for (int x : vals) {
            for (int y : vals) {
                pair[x ^ y] = true;
            }
        }

        // Store all possible XORs of (pair XOR) with another number
        boolean[] ans = new boolean[MAX];
        for (int i = 0; i < MAX; i++) {
            if (pair[i]) {
                for (int x : vals) {
                    ans[i ^ x] = true;
                }
            }
        }

        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }

        return count;
    }
}
