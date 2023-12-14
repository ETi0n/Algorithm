class Solution {
    public int[] solution(int money) {
        int price = 5500;
        int quantity = money / price;
        int change = money % price;
        
        int[] answer = {quantity, change};
        return answer;
    }
}