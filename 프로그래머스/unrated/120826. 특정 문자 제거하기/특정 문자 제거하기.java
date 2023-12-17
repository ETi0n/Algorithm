class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder result = new StringBuilder();

        // 주어진 문자열을 순회하면서 지정된 문자를 제외한 문자를 새로운 문자열에 추가
        for (int i = 0; i < my_string.length(); i++) {
            char currentChar = my_string.charAt(i);
            if (currentChar != letter.charAt(0)) {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}
