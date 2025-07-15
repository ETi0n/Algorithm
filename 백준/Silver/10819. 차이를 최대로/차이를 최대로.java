import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int result;
    public static int arr[];
    public static int ans[];
    public static boolean visited[];
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ans = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth) {
        if (depth == N) {
            int sum = 0;

            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(ans[i] - ans[i + 1]);
            }
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            ans[depth] = arr[i];
            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}