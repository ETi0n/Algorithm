class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split(" ");
        
        for(int i = 0; i < str.length; i++){
            if("Z".equals(str[i])){
                answer -= Integer.parseInt(str[i - 1]);
                continue;
            }
            answer += Integer.parseInt(str[i]);
        }
        return answer;
    }
}