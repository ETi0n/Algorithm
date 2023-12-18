class Solution {
    public String solution(int age) {
        char[] charArray = String.valueOf(age).toCharArray();
        
        for(int i = 0; i < charArray.length; i++){
            charArray[i] = toAlienLang(charArray[i]);
        }
        
        // String answer = charArray.toString(); 
        // 사용 시 배열의 내용이 아닌 배열의 주소를 문자열로 변환해 [C@<해시코드>와 같은 형태의 문자열을 반환된다.
        // 추가로 String answer = String.valueOf(charArray);도 가능하다.
        String answer = new String(charArray);
        
        return answer;
    }
    
    public char toAlienLang(char n){
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
