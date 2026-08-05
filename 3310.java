/* 
Leetcode : 3310
https://leetcode.com/problems/remove-methods-from-project/description/
*/


class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int[] inDegree = new int[n];
        boolean[] suspicious = new boolean[n];

        //Graph using adjacency list : u->{neigh1, neigh2}
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        //BFS
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        suspicious[k] = true;

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int neigh : adj.get(curr)) {
                inDegree[neigh]--;
                if(!suspicious[neigh]) {
                    q.offer(neigh);
                    suspicious[neigh] = true;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        boolean notRemove = false;

        for(int i=0; i<n; i++) {
            if(suspicious[i] && inDegree[i] > 0) {
                notRemove = true;
                break;
            }

            if(!suspicious[i]) {
                result.add(i);
            }
        }

        if(notRemove) {
            List<Integer> none = new ArrayList<>(); // 0, 1, 2,..... n-1
            for(int i=0; i<n; i++) {
                none.add(i);
            }
            return none;
        }

        return result;
    }
}