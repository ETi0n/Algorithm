class Solution {
    public int solution(int hp) {
        int top = 5;
        int middle = 3;
        int bottom = 1;
        int answer = 0;
        int remain = 0;
        
        answer = hp / top;
        remain = hp % top;
        answer += remain / middle;
        remain %= middle;
        answer += remain / bottom;
        
        return answer;
    }
}