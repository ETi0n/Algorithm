class Solution {
    public int[] solution(int[] num_list) {
        int n = num_list.length;
        int[] reverse_list = new int[n];
        
        for(int i = 0, j = n - 1; i < n; i++, j--){
            reverse_list[i] = num_list[j];
        }
        
        return reverse_list;
    }
}