import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] miro = new char[N][M];
        int[][] dist = new int[N][M]; 
        int[] dx = {1, 0, -1, 0};  
        int[] dy = {0, 1, 0, -1};

        // 미로 생성
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                miro[i][j] = line.charAt(j);
                dist[i][j] = -1;
            }
        }

       // 미로 탐색
        Queue<spot> q = new LinkedList<>();
        q.add(new spot(0,0));
        dist[0][0] = 0;

        while(!q.isEmpty()){
            spot s = q.poll();

            for(int i=0; i<4; i++){
                int x = s.x + dx[i];
                int y = s.y + dy[i];

                // 벽에 부딪히거나, 범위를 넘어가면 PASS
                if(x < 0 || x >= N || y < 0 || y >= M){
                    continue;
                }
                // 길이 아니거나, 방문을 했다면 PASS
                if(miro[x][y] == '0' || dist[x][y] != -1){
                    continue;
                }

                // 큐에 이동한 좌표 대입
                q.add(new spot(x, y));
                // 한 칸 이동, 거리 증가
                dist[x][y] = dist[s.x][s.y] + 1;
            }
        }
        System.out.print(dist[N-1][M-1] + 1);
        br.close();
    }

    public static class spot{
        int x;
        int y;

        spot(int x, int  y){
            this.x = x;
            this.y = y;
        }
    }
}