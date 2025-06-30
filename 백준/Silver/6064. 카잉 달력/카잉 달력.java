import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken()); // 마지막 해
            int N = Integer.parseInt(st.nextToken()); // 마지막 달
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // N == y 이라면 나눴을 때 0
            if (y == N) y = 0;

            boolean found = false;
            for (int j = 0; j <= N; j++) {
                int k = M * j + x;

                if (k % N == y) {
                    bw.write(k + "\n");
                    found = true;
                    break;
                }
            }

            if (!found) bw.write("-1\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}