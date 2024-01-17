import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static int node, line, cnt;
    static int[][] map;
    static boolean[] check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫째 줄: 컴퓨터의 수
        node = Integer.parseInt(br.readLine());
        // 둘째 줄: 연결된 컴퓨터 쌍의 수
        line = Integer.parseInt(br.readLine());

        // 나머지: 연결된 컴퓨터의 번호쌍
        map = new int[node+1][node+1];
        check = new boolean[node+1];
        for(int i = 0; i < line; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        cnt = 0;
        bfs(1);
        System.out.println(cnt-1);
    }

    public static void bfs(int start){
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()){
            start = q.poll();
            cnt++;
            for(int i = 1; i <= node; i++){
                if(map[start][i] == 1 && !check[i]){
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}