class Solution {
    public int solution(int[] numbers) {
        int maxIndex[] = {0, 0};
        
        
        for(int i = 0; i < 2; i++){
            int max = 0;
            int index = 0;
            for(int j = 0; j < numbers.length; j++){
                if(max < numbers[j]){
                    max = numbers[j];
                    index = j;
                }
            }
            maxIndex[i] = max;
            numbers[index] = 0;
        }
        
        return maxIndex[0] * maxIndex[1];
    }
}