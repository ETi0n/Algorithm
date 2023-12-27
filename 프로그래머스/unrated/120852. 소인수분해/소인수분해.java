import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        // n 이전에 존재하는 소수 찾기
        for(int i = 2; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j < i; j++){
                if(i % j == 0){
                    cnt++;
                }
            }
            if(cnt < 2){
                // 찾은 소수 중 n의 소인수 찾기
                if(n % i == 0){
                    list.add(i);
                }
            }
        }
        
        // 리스트를 int배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i).intValue();
        }
        
        return answer;
    }
}