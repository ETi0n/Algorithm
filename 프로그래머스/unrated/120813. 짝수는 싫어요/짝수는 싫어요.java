class Solution {
    public int[] solution(int n) {
        int num;
        if(n % 2 != 0) num = n / 2 + 1;
        else num = n / 2;
        
        int[] answer = new int[num];
        int count = 0;
        
        for(int i = 1; i <= n; i++){
            if(i % 2 != 0) answer[count++] = i;
        }
        
        return answer;
    }
}