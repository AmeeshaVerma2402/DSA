class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] count = new int[2]; // count[0] = nodes, count[1] = degreeSum
                dfs(i, graph, visited, count);

                int nodes = count[0];
                int degreeSum = count[1];

                if (degreeSum == nodes * (nodes - 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int node, List<Integer>[] graph, boolean[] visited, int[] count) {
        visited[node] = true;
        count[0]++;
        count[1] += graph[node].size();

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, graph, visited, count);
            }
        }
    }
}