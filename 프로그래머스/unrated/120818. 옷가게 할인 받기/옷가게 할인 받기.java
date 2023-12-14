class Solution {
    public int solution(double price) {
        double sale = 0;
        
        switch ((int)price / 100000) {
            case 0:
                return (int)price;
            case 1:
            case 2:
                sale = 5;
                break;
            case 3:
            case 4:
                sale = 10;
                break;
            case 5:
            default:
                sale = 20;
                break;
        }
        
        int answer = (int)(price - (price * sale) / 100);
        
        return answer;
    }
}