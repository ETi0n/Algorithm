import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 예제 : ()(((()())(())()))(()) | 결과 : 17
        char[] input = br.readLine().toCharArray();

        int answer = 0;
        for(int i = 0; i < input.length; i++){
            char temp = input[i];

            // '('알 때 : 막대의 시작 or 레이저 시작
            if(temp == '('){
                stack.push(temp);
            } 
            // ')'일 때 :
            else{
                // 1. 레이저 발사 (막대의 시작이 아니였으므로 stack의 값 하나 감소)
                if(input[i-1] == '('){
                    stack.pop();
                    answer += stack.size();
                } 
                // 2. 막대의 끝 (막대 하나의 길이가 끝이 났으므로 stack의 값 하나 감소)
                else{
                    stack.pop();
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}