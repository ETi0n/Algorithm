import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int count = 1;  // 자리 수마다 늘어나는 수 (일의 자리는 1, 십의 자리는 2 ...)
        int next = 1;   // 다음 자릿수
        int prev = 0;   // 이전 자릿수의 마지막 숫자
        int result = 0;

        while(next * 10 <= n){
            int endpoint = next * 10 - 1; // 9 99 999 ...
            result += (endpoint - prev) * count++;

            prev = endpoint;
            next *= 10;
        }

        result += (n - prev) * count;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}