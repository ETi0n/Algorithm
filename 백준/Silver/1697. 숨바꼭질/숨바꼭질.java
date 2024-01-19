import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> q = new LinkedList<>();

    static int N, K;
    static int[] check = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수빈이의 위치: N, 동생의 위치: K
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(N)-1;
        System.out.println(result);
    }

    public static int bfs(int start){
        q.add(start);
        check[start] = 1;

        while(!q.isEmpty()){
            start = q.poll();
            // 동생 발견시
            if(start == K){
                return check[start];
            }
            // 1초 후 X-1로 이동 시: 범위 내에 존재하고 가본 적이 없다면
            if (start-1 >= 0 && check[start-1] == 0)
            {
                check[start-1] = check[start]+1;
                q.add(start-1);
            }
            // 1초 후 X+1로 이동 시
            if (start+1 < 100001 && check[start+1] == 0)
            {
                check[start+1] = check[start]+1;
                q.add(start+1);
            }
            // 1초 후 2*X로 이동 시
            if (2*start < 100001 && check[2*start] == 0)
            {
                check[2*start] = check[start] + 1;
                q.add(2*start);
            }
        }
        return -1;
    }
}