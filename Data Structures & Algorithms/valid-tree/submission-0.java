class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n -1){
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean visited[] = new boolean[n];

        dfs(adj, visited, 0);

        for(boolean isVisited : visited){
            if(!isVisited){
                return false;
            }
        }

        return true;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }
}
