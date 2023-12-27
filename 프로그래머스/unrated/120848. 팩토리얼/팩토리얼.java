class Solution {
    public int solution(int n) {
        int answer = 1;
        int temp = 1;
        
        while(temp < n){
            temp *= ++answer;
        }
        
        if(temp > n) return answer - 1;
        return answer;
    }
}