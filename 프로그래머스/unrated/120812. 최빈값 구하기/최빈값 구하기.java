class Solution {
    public int solution(int[] array) {
        int max = 0;
        int n = 0;
        boolean same = false;
        
        if(array.length == 1) return array[0];
        
        for(int i = 0; i < array.length; i++){
            int count = 0;
            for(int j = i + 1; j < array.length; j++){
                if(array[i] == array[j]){
                    count++;
                }
            }
            if(max < count){ 
                max = count;
                n = i;
                same = false;
            } else if(max == count) same = true;
        }
        
        if(same) return -1;
        
        return array[n];
    }
}