import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static boolean isAnswer = false;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        f(A, B, 1);

        if(!isAnswer) answer = -1;
        System.out.println(answer);
    }

    public static void f(Long A, Long B, int cnt){
        if(A.equals(B)){
            answer = cnt;
            isAnswer = true;
            return;
        } else if(A > B){
            return;
        }

        f(2 * A, B, cnt+1);

        if(!isAnswer){
            String temp = A + "1";
            f(Long.parseLong(temp), B, cnt+1);
        }
    }
}
