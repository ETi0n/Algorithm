import java.io.*;
import java.util.StringTokenizer;

// 비트마스킹, 백트래킹 문제
// 비트마스킹: 비트 연산자를 통해 더 빠르고 적은 메모리 사용하는 기법
// with ChatGTP 4o
public class Main {

    public static int N;
    public static int[][] map;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st =  new StringTokenizer(br.readLine());

            int idx = 0;
            while(st.hasMoreTokens()){
                map[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        int full = 1 << N; // 1을 N만큼 왼쪽으로 쉬프트: 2^N
        for(int mask = 1; mask < full; mask++){ // mask = 1, 10, 11, 100 ...
            if((mask & 1) == 0) continue; // 0번 선수는 항상 start 팀으로 고정 (팀 이름만 다를 중복 상황 제거)

            int other = (~mask) & (full - 1); // link 팀은 start 팀의 보수 집합
            if(other == 0) continue; // link 팀에 한 명도 없는 경우 배제

            int diff = Math.abs(score(mask) - score(other));
            min = Math.min(min, diff);

            if(min == 0) break; // 조기 종료
        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int score(int mask){
        int sum = 0;

        for(int i = 0; i < N; i++){
            if((mask & (1 << i)) == 0) continue; // 해당 팀이 아닌 경우는 skip (첫번째부터 순서대로 확인)
            for(int j = i+1; j < N; j++){
                if((mask & (1 << j)) == 0) continue;
                sum += map[i][j] + map[j][i];
            }
        }

        return sum;
    }
}