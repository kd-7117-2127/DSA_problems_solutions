Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

    Element at grid[i][j] moves to grid[i][j + 1].
    Element at grid[i][n - 1] moves to grid[i + 1][0].
    Element at grid[m - 1][n - 1] moves to grid[0][0].

Return the 2D grid after applying shift operation k times.

Intuition

The grid is shifted one position at a time. During each shift:

The last element of the grid moves to the first position.
Every other element moves one position forward in row-major order.
Since shifting by the total number of elements results in the original grid, we first reduce k using modulo.
Approach

1-Find the number of rows and columns.
2-Reduce k by taking k % (rows * columns).
3-Repeat the shift operation k times:
-Store the last element of the grid.
-Traverse the grid from bottom-right to top-left.
-Move each element from its previous position:
-If it is the first column (except the first row), copy the last element of the previous row.
-Otherwise, copy the element from the previous column.
-Place the stored last element at grid[0][0].
4-Convert the final 2D array into a List<List> and return it.
Complexity

    Time complexity:

O(k*m*n)

    Space complexity:

O(m*n)

Code

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
       int r = grid.length-1;
       int c = grid[0].length-1;
       k = k%((r+1)*(c+1));
       while(k>0){
        int last = grid[r][c];
        for(int i=r;i>=0;i--){
            for(int j=c;j>=0;j--){
                if(j==0&&i>0){
                    grid[i][j] = grid[i-1][c];
                }
                else{
                    if(j>0){
                        grid[i][j] = grid[i][j-1];
                    }
                }
            }
        }
        grid[0][0] = last;
        k--;
       }
       List<List<Integer>> list = new ArrayList<>();
       for(int[] ar:grid){
        List<Integer> liz = new ArrayList<>();
        for(int i:ar){
            liz.add(i);
        }
        list.add(liz);
       }
       return list;
    }
}
