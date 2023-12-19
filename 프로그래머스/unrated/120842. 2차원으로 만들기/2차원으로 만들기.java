class Solution {
    public int[][] solution(int[] num_list, int n) {
        int temp = num_list.length / n;
        int[][] answer = new int[temp][n];
        
        int num = 0;
        for(int i = 0; i < temp; i++){
            for(int j = 0; j < n; j++){
                answer[i][j] = num_list[num];
                num++;
            }
        }
        
        return answer;
    }
}