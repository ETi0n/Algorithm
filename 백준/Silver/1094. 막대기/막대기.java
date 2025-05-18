import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int stick = 64; // 초기 막대기의 길이
        int X = Integer.parseInt(br.readLine()); // 원하는 막대의 길이
        
        Stack<Integer> stack = new Stack<Integer>(); // 자른 막대들을 보관
        stack.add(stick);

        while(stick != X){
            int half = stack.pop() / 2; // 가장 짧은 막대의 절반
            stick = stick - half;
            stack.add(half);

            if(stick < X){  // 반으로 자른 막대의 합이 X보다 작다면 자른 반을 다시 자르고, 아니면 버림
                stack.add(half);
                stick = stick + half;
            }
        }

        bw.write(String.valueOf(stack.size()));
        bw.flush();
        bw.close();
    }
}