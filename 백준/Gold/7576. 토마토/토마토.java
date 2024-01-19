import java.io.*;
import java.util.*;

public class Main {
    static Queue<spot> q = new LinkedList<>();
    static int M, N, result;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        // 상자의 가로 칸의 수 : M, 상자의 세로 칸의 수: N
        M = Integer.parseInt(st1.nextToken());
        N = Integer.parseInt(st1.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
                if(map[i][j] == 1) q.add(new spot(i, j));
            }
        }

        bfs();
        calculateDay();
        System.out.println(result);
    }

    public static class spot{
        int x, y;

        spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(){
        spot start;

        while(!q.isEmpty()){
            start = q.poll();
            result++;

            for(int i=0; i<4; i++) {
                int x = start.x + dx[i];
                int y = start.y + dy[i];

                // map 범위 out
                if(x < 0 || y < 0 || x >= N || y >= M){
                    continue;
                }

                // 주변에 익지않은 토마토가 있다면
                if (map[x][y] == 0) {
                    // 익은 날짜로 표시
                    map[x][y] = map[start.x][start.y] + 1;
                    q.add(new spot(x,y));
                }
            }
        }
    }

    public static void calculateDay(){
        int max = 0;
        for(int[] n : map){
            for(int m : n){
                // 남아있는 익지않은 토마토가 있다면
                if(m == 0) {
                    result = -1;
                    return;
                }
                if(max < m){
                    max = m;
                }
            }
        }
        // 소요 날짜 = 마지막날 - 첫날
        result = max - 1;
    }
}