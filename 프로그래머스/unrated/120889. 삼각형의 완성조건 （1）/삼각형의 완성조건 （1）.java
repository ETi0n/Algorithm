import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        
        int temp = 0;
        temp = sides[0] + sides[1] - sides[2];
        
        if(temp > 0) return 1;
        return 2;
    }
}