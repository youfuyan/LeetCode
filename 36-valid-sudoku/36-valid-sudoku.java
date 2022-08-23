class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        //Use hash set to record the status
        Set<Character>[] rows = new HashSet[N];
        Set<Character>[] cols = new HashSet[N];
        Set<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<>();
            cols[r] = new HashSet<>();
            boxes[r] = new HashSet<>();
        }
        
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }
                
                if (rows[r].contains(ch)) {
                    return false;
                }
                rows[r].add(ch);
                
                if (cols[c].contains(ch)) {
                    return false;
                }
                cols[c].add(ch);
                
                int idx= (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(ch)) {
                    return false;
                }
                boxes[idx].add(ch);
            }
        }
        return true;
    }
}