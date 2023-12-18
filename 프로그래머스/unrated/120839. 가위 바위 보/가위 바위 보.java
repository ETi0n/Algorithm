class Solution {
    public String solution(String rsp) {
        char[] charArray = rsp.toCharArray();
        
        for(int i = 0; i < charArray.length; i++){
            charArray[i] = win(charArray[i]);
        }
        
        String answer = new String(charArray);
        return answer;
    }
    
    public char win(char n){
        switch(n){
            case '2': return '0';
            case '0': return '5';
            case '5': return '2';
            default: break;
        }
        return '1';
    }
}