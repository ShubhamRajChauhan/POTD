/* 
Leetcode : 2492
https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
*/



class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] r : roads) {
            int u = r[0];
            int v = r[1];
            int c = r[2];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, c});
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, c});
        }

        boolean[] visited = new boolean[n+1];
        int[] result = new int[]{Integer.MAX_VALUE};
        dfs(adj, 1, visited, result);

        return result[0];
    }


    public void dfs(Map<Integer, List<int[]>> adj, int u, boolean[] visited, int[] result) {
        visited[u] = true;

        for(int[] a : adj.getOrDefault(u, new ArrayList<>())) {
            int v = a[0];
            int c = a[1];

            result[0] = Math.min(result[0], c);

            if(!visited[v]) {
                dfs(adj, v, visited, result);
            }
        }
    }
}