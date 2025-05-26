import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int result = 666;

        while (true) {
            // 현재 값이 666을 포함하고 있다면 더하고, 아니라면 넘어가기
            if (String.valueOf(result).contains("666")) {
                count++;
                if (count == N) {
                    // 666이 포함된 N번째 숫자 출력
                    bw.write(String.valueOf(result));
                    break;
                }
            }
            result++;
        }

        bw.flush();
        bw.close();
    }
}