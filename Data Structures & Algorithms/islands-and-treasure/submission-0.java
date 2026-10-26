class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int cell[] = queue.poll();
            int row = cell[0];
            int col = cell[1];

            int dRow[] = {1, -1, 0, 0};
            int dCol[] = {0, 0, -1, 1};


            for(int i=0; i<4; i++){
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == Integer.MAX_VALUE){
                    grid[newRow][newCol] = grid[row][col] +1;

                    queue.offer(new int[] {newRow, newCol});
                }
            }
        }    
    }
}
