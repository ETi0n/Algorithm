class Solution {
    public int solution(int[] array, int n) {
        int abs;
        int answer = array[0];
        int min = Math.abs(n - array[0]);
        
        for(int i : array){
            abs = Math.abs(n - i);
            if(min > abs){
                min = abs;
                answer = i;
            } else if(min == abs){
                if(answer > i){
                    answer = i;
                }
                min = abs;
            }
        }
        
        return answer;
    }
}