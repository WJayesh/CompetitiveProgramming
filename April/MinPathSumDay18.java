package April;
public class MinPathSumDay18 {
    public int minPathSum(int[][] grid) {
        int[][] sum = new int[grid.length][grid[0].length];
        sum[0][0] = grid[0][0];

        for(int i = 1; i < grid.length; i++) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < grid[0].length; i++) {
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }

        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                sum[i][j] = grid[i][j] + Math.min(sum[i-1][j], sum[i][j-1]);
            }
        }

        return sum[grid.length-1][grid[0].length-1];
    }
}