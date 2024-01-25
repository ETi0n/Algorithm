import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        // Test case의 수 T
        int T = Integer.parseInt(br.readLine());

        // 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n
        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            house(k, n);
            list.add(answer);
        }

        for(int n : list){
            System.out.println(n);
        }
    }

    public static void house(int k, int n){
        map = new int[k+1][n+1];

        for(int i = 1; i < n+1; i++){
            map[0][i] = i;
        }
        for(int i = 1; i < k+1; i++){
            for(int j = 1; j < n+1; j++){
                // 옆집(1호부터 옆집의 아래집까지의 합)과 우리집 아래집의 합 = 우리집
                map[i][j] = map[i][j-1] + map[i-1][j];
            }
        }

        answer = map[k][n];
    }

}