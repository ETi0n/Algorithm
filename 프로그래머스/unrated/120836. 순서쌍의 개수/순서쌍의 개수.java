class Solution {
    public int solution(int n) {
        /*
        < 시간 초과 풀이 >
        int sum = 0;
        int num = n + 1;
        
        for (int i = 1; i < num; i++){
            for (int j = n; j >= i; j--) {
                int mul = i * j;
                if(i == j) {
                    if (mul == n) {
                        sum = sum * 2 + 1;
                        return sum;
                    }
                }
                if (mul == n) {
                    sum++;
                    break;
                }
            }
        }
        sum = sum * 2;
        return sum;
        */
        
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                answer++;
            }
        }
        
        return answer;
    }
}