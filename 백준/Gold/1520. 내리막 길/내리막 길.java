import java.io.*;
import java.util.*;

public class Main {

    static int endX, endY;
    static int[][] map;
    static int[][] dp;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        endX = N - 1;
        endY = M - 1;

        map = new int[N][M];
        dp = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // dp 값 초기화
            }
        }

        bw.write(String.valueOf(dfs(0,0)));
        bw.flush();
        bw.close();
    }

    public static int dfs(int x, int y){
        if(x == endX && y == endY) return 1;

        if(dp[x][y] == -1) {
            dp[x][y] = 0;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx > endX || ny < 0 || ny > endY) continue;

                if(map[x][y] > map[nx][ny]){
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
}