class Solution {
    public String solution(String my_string) {
        char[] array = my_string.toCharArray();
        
        int n = array.length;
        for(int i = 0, j = n-1; i < j; i++, j--){
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        
        String answer = new String(array);
        return answer;
    }
}