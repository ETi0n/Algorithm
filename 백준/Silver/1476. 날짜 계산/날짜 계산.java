import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());   // 지구를 나타내는 수
        int S = Integer.parseInt(st.nextToken());   // 태양을 나타내는 수
        int M = Integer.parseInt(st.nextToken());   // 달을 나타내는 수

        // 마지막 수라면 나머지가 0 이므로
        if (S == 28) S = 0;
        if (M == 19) M = 0;

        int answer = -1;
        int idx = 0;
        while(true){
            int year = 15 * (idx++) + E;

            if (year % 28 == S && year % 19 == M) {
                answer = year;
                break;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}