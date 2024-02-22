import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP(다이나믹 프로그래밍) 문제
public class Main {
    static int[] A;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열 A의 크기
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        memo = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(BottomUp(N));
    }

    public static int BottomUp(int N){
        int[] dp = new int[N];
        int result = 0;

        for(int i = 0; i < N; i++){
            int max = 1;
            dp[i] = 1;

            for(int j = 0; j < i; j++){
                // 지금의 값보다 값이 작은 이전 값들만 가능하므로 크거나 같은 값은 생략
                if(A[j] >= A[i]) continue;
                // 이전 값 중 가장 값이 큰 값에 +1 해야하므로 dp[i]가 더 크면 생략
                if(dp[j] < dp[i]) continue;

                dp[i] = dp[j] + 1;
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}