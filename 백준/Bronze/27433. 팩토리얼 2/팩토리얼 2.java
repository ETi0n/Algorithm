import java.io.*;

public class Main {
    static long sum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        factorial(n);

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }

    public static void factorial(int n){
        if(n == 1) return; // 값이 초기값으로 주어지므로 계산 횟수 줄이기.
        else if(n == 0) return;

        sum = sum * n--;
        factorial(n);
    }
}