class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (color != oldColor) {
            dfs(image, sr, sc, oldColor, color);
        }
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (!inArea(image, sr, sc)) {
            return;
        }
        if (image[sr][sc] != oldColor) {
            return;        
        }
        image[sr][sc] = newColor;
        
        dfs(image, sr + 1, sc, oldColor, newColor);
        dfs(image, sr - 1, sc, oldColor, newColor);
        dfs(image, sr, sc + 1, oldColor, newColor);
        dfs(image, sr, sc - 1, oldColor, newColor);
        
    }
    
    public boolean inArea(int[][] image, int sr, int sc) {
        return (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length);
    }
}