class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }
        visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj);
                count++;
            }
        }
        return count;
    }

    public void dfs(int node, HashMap<Integer, List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj);
            }
        }
    }
}