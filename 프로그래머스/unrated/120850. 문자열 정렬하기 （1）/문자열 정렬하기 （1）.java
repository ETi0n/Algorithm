import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        
        // 숫자인 문자만 리스트에 대입
        for(char ch1 : my_string.toCharArray()){
            for(char ch2 : num){
                if(ch1 == ch2){
                    // 아스키코드를 이용해 문자열을 숫자로 변환
                    list.add(ch2 - '0');
                }
            }       
        }
        
        // 리스트를 int배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i).intValue();
        }
        
        // 오름차순
        Arrays.sort(answer);
        return answer;
    }
}