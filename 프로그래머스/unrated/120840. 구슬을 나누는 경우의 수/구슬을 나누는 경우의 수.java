class Solution {
    public int solution(int balls, int share) {
        int[] ballsArray = new int[balls];
        return combination(ballsArray, share, 0, 0);
    }
    
    private static int combination(int[] ballsArray, int share, int idx, int cnt) {
        int answer = 0;

        if (cnt == share) { // 조합 완성
            return 1;
        }

        for (int i = idx; i < ballsArray.length; i++) {
            answer += combination(ballsArray, share, i + 1, cnt + 1);
        }

        return answer;
    }
}
