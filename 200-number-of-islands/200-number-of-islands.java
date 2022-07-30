class Solution {
    
    class Coordinates {
        int x;
        int y;
        
        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int numIslands(char[][] grid) {
        Stack<Coordinates> s = new Stack();
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    s.push(new Coordinates(i,j));
                    grid[i][j] = '0';
                    while (!s.empty()) {
                        Coordinates c = s.pop();
                        
                        if (c.x+1 < m && grid[c.x+1][c.y] == '1') {
                            s.push(new Coordinates(c.x+1,c.y));
                            grid[c.x+1][c.y] = '0';
                        }
                        if (c.x-1 >= 0 && grid[c.x-1][c.y] == '1') {
                            s.push(new Coordinates(c.x-1,c.y));
                            grid[c.x-1][c.y] = '0';
                        }
                        if (c.y-1 >= 0 && grid[c.x][c.y-1] == '1') {
                            s.push(new Coordinates(c.x,c.y-1));
                            grid[c.x][c.y-1] = '0';
                        }
                        if (c.y+1 < n && grid[c.x][c.y+1] == '1') {
                            s.push(new Coordinates(c.x,c.y+1));
                            grid[c.x][c.y+1] = '0';
                        }
                    }
                }
            }
        }
        return result;
    }
}