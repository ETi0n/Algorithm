class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        int temp = 0;
        int firstIndex = 0;
        int lastIndex = numbers.length - 1;
        
        if(direction.equals("left")){
            firstIndex = numbers[0];
            for(int i = 0; i < lastIndex; i++){
                temp = numbers[i + 1];
                numbers[i] = numbers[i + 1];
                numbers[i + 1] = temp;
            }
            numbers[lastIndex] = firstIndex;
        } else if (direction.equals("right")){
            firstIndex = numbers[lastIndex];
            for(int i = lastIndex; i > 0; i--){
                temp = numbers[i];
                numbers[i] = numbers[i - 1];
                numbers[i - 1] = temp;
            }
            numbers[0] = firstIndex;
        }
        
        return numbers;
    }
}