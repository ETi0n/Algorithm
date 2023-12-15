class Solution {
    public int solution(int n) {
        int half = n / 2;
        for(int i = 0; i < half; i++){
            if(n == i * i){
                return 1;
            }
        }
        return 2;
    }
}