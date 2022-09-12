class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        //Gready approach
        //Buy cheap and sell expensive
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        int score = 0, res = 0;
        while (i <= j) {
            if (tokens[i] <= power) {
                power -= tokens[i++];
                score++;
                res = Math.max(score, res);
            } else if (score > 0) {
                power += tokens[j--];
                score--;
            } else {
                break;
            }
        }
        return res;
    }
}