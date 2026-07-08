class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        long MOD = 1_000_000_007;
        int n = s.length();
        
        // Preallocated prefix arrays
        long[] prefixSum = new long[n + 1];
        long[] prefixNumber = new long[n + 1];
        int[] prefixCount = new int[n + 1];
        long[] power10 = new long[n + 1];
        
        // Initialize power array
        power10[0] = 1;
        for (int i = 0; i < n; i++) {
            power10[i + 1] = (power10[i] * 10) % MOD;
        }
        
        // 1-indexed Prefix Precomputation
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            prefixSum[i + 1] = prefixSum[i] + digit;
            
            if (digit == 0) {
                prefixNumber[i + 1] = prefixNumber[i];
                prefixCount[i + 1] = prefixCount[i];
            } else {
                prefixNumber[i + 1] = (prefixNumber[i] * 10 + digit) % MOD;
                prefixCount[i + 1] = prefixCount[i] + 1;
            }
        }
        
        // Process each query in O(1)
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            long sum = prefixSum[right + 1] - prefixSum[left];
            int nonZeroDigits = prefixCount[right + 1] - prefixCount[left];
            
            // Extracting the intermediate number using prefix rolling hashes
            long removedPrefix = (prefixNumber[left] * power10[nonZeroDigits]) % MOD;
            long number = (prefixNumber[right + 1] - removedPrefix + MOD) % MOD;
            
            answer[i] = (int) ((number * sum) % MOD);
        }
        
        return answer;
    }
}