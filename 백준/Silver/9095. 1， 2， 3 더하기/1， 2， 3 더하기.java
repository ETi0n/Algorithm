import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// DP(다이나믹 프로그래밍) 문제
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 개수 T
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(BottonUp(n));
            // System.out.println(TopDown(n));
        }
    }

    public static int BottonUp(int n){
        // n은 양수이며, 11보다 작기때문에 배열의 크기를 11로 지정.
        int[] dp = new int[11];

        dp[0] = 0;
        dp[1] = 1; // 1의 경우의 수는 1
        dp[2] = 2; // 2의 경우의 수는 2
        dp[3] = 4; // 3의 경우의 수는 4

        // 4의 경우의 수부터는 3의 경우의 수 + 2의 경우의 수 + 1의 경우의 수를 더한 값과 같다.
        // 즉, dp[n] = dp[n-1] + dp[n-2] + dp[n-1]
        for(int i = 4; i < n + 1; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }

    static int[] memo = new int[11];
    public static int TopDown(int n){
        // 이미 계산했던 값을 저장해둔 memo 배열에 값이 들어있다면 그 값을 return
        if(memo[n] > 0) return memo[n];

        if(n == 1) return 1;
        else if(n == 2) return 2;
        else if(n == 3) return 4;
        else{
            memo[n] = TopDown(n-1) + TopDown(n-2) + TopDown(n-3);

            return memo[n];
        }
    }
}