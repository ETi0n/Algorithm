class Solution {
    public long solution(String numbers) {
        String string_num = numbers
            .replace("zero", "0")
            .replace("one", "1")
            .replace("two", "2") 
            .replace("three", "3")
            .replace("four", "4")
            .replace("five", "5")
            .replace("six", "6")
            .replace("seven", "7")
            .replace("eight", "8")
            .replace("nine", "9");

        long answer = Long.parseLong(string_num);
        return answer;
    }
}


/* 정확성 66.7점, 총 3개 런타임 에러 코드

import java.util.HashMap;

class Solution {
    public int solution(String numbers) {
        HashMap<String, String> nEngToDigit = new HashMap<>();
        nEngToDigit.put("zero", "0");
        nEngToDigit.put("one", "1");
        nEngToDigit.put("two", "2");
        nEngToDigit.put("three", "3");
        nEngToDigit.put("four", "4");
        nEngToDigit.put("five", "5");
        nEngToDigit.put("six", "6");
        nEngToDigit.put("seven", "7");
        nEngToDigit.put("eight", "8");
        nEngToDigit.put("nine", "9");

        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < numbers.length(); i++) {
            temp.append(numbers.charAt(i));

            if (nEngToDigit.containsKey(temp.toString())) {
                answer.append(nEngToDigit.get(temp.toString()));
                temp.setLength(0);
            }
        }

        return Integer.parseInt(answer.toString());
    }
}

*/