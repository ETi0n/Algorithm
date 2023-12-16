import java.util.Arrays;

class Solution {
    public String solution(String my_string, int n) {
        char[] charArr = my_string.toCharArray();
        char[] newArr = new char[charArr.length * n];
        
        for (int i = 0; i < charArr.length; i++) {
            for (int j = 0; j < n; j++) {
                newArr[i * n + j] = charArr[i];
            }
        }
        
        return new String(newArr);
    }
}
