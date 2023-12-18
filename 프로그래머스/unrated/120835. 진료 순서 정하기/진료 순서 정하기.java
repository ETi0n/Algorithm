class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        for(int i = 0; i < answer.length; i++){
            int max = 0;
            int index = 0;
            for(int j = 0; j < emergency.length; j++){
                if(max < emergency[j]){
                    max = emergency[j];
                    index = j;
                }
            }
            answer[index] = i + 1;
            emergency[index] = 0;
        }
        return answer;
    }
}