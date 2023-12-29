class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = code; i < cipher.length() + 1; i += code){
            sb.append(cipher.charAt(i - 1));
        }
        
        String answer = sb.toString();
        return answer;
    }
}