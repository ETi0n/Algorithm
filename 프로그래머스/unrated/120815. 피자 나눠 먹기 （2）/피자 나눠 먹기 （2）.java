class Solution {
    public int solution(int n) {
        int[] nIndex = new int[6];
        int[] pizzaIndex = new int[n];
            
        for(int i = 0; i < 6; i++){
            nIndex[i] = n * (i+1);
        }
        
        for(int i = 0; i < n; i++){
            pizzaIndex[i] = 6 * (i+1);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 6; j++){
                if(pizzaIndex[i] == nIndex[j]){
                    return i + 1;
                }
            }
        }
        return 0;
    }
}