class Solution {
    public String solution(int age) {
        char[] charArray = String.valueOf(age).toCharArray();
        
        for(int i = 0; i < charArray.length; i++){
            charArray[i] = toEn(charArray[i]);
        }
        
        String answer = new String(charArray);
        
        return answer;
    }
    
    public char toEn(char n){
        switch(n){
            case '0': return 'a';
            case '1': return 'b';
            case '2': return 'c';
            case '3': return 'd';
            case '4': return 'e';
            case '5': return 'f';
            case '6': return 'g';
            case '7': return 'h';
            case '8': return 'i';
            case '9': return 'j';
            default: return 'x';
        }
    }
}