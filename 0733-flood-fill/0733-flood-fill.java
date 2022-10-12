class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orig = image[sr][sc];
        int x = sr;
        int y = sc;
        int xLength = image.length;
        int yLength = image[0].length;
        //System.out.println(image[x+1][y]);
        //System.out.println(image[x][y]);
        if (image[x][y] != color) {
            image[x][y] = color;
            if (x + 1 < xLength && image[x+1][y] == orig) {
                image = floodFill(image, x+1, y, color);   
            }
            
            if (x - 1 >= 0 && image[x-1][y] == orig) {
                image = floodFill(image, x-1, y, color);  
            }

            if (y + 1 < yLength  && image[x][y+1] == orig) {
                image = floodFill(image, x, y+1, color);   
            }

            if (y - 1 >= 0 && image[x][y-1] == orig) {
                image = floodFill(image, x, y-1, color); 
            }
        }
        return image;
    }
}