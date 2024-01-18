import java.io.*;
import java.util.*;

public class Main {
    static Queue<spot> q = new LinkedList<>();
    static List<Integer> answer = new ArrayList<>();
    static int N;
    static char[][] map;
    static boolean[][] check;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫째 줄: 지도의 크기 N
        N = Integer.parseInt(br.readLine());

        // 나머지: N개의 자료
        map = new char[N][N];
        check = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                if(map[i][j] == '1' && !check[i][j]) {
                    answer.add(bfs(new spot(i, j)));
                }
            }
        }

        // 총 단지수 출력
        System.out.println(answer.size());
        // 각 단지내 집의 수
        Collections.sort(answer);
        for(int num : answer){
            System.out.println(num);
        }
    }

    public static int bfs(spot start){
        int cnt = 0;
        q.add(start);
        check[start.x][start.y] = true;

        while(!q.isEmpty()){
            spot s = q.poll();
            cnt++;

            for(int i=0; i<4; i++){
                int x = s.x + dx[i];
                int y = s.y + dy[i];

                // map 범위 out
                if(x < 0 || y < 0 || x >= N || y >= N){
                    continue;
                }

                // 집이 없거나 가본 적 있는 곳
                if(map[x][y] == '0' || check[x][y]){
                    continue;
                }

                q.add(new spot(x, y));
                check[x][y] = true;
            }
        }
        return cnt;
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