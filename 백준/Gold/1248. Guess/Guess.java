import java.io.*;

// 완전 탐색, 백트래킹 문제
// matrix를 통해 경우의 수를 줄이고 백트래킹을 통해 시간 단축
public class Main {

    static int n;
    static int[][] map;
    static int[] num;
    static int[] sum;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine()) + 1; // 1 ≤ n ≤ 10
        map = new int[n][n];
        num = new int[n];
        sum = new int[n];

        int idx = 0;
        String str = br.readLine();
        for(int i = 1; i < n; i++){
            for(int j = i; j < n; j++){
                char c = str.charAt(idx++);

                if(c == '0') map[i][j] = 0;
                else if(c == '+') map[i][j] = 1;
                else if(c == '-') map[i][j] = -1;
            }
        }

        dfs(1);
    }


    public static void dfs(int count) throws IOException{
        if(!check(count - 1)) return;

        if(count > n-1){
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < count; i++)
                sb.append(num[i]).append(" ");

            bw.write(sb.toString());
            bw.flush();
            bw.close();
            System.exit(0);
        }

        int sign = map[count][count];

        if(sign == 0){
            num[count] = 0;
            sum[count] = sum[count - 1];
            dfs(count + 1);
        } else {
            for (int i = 1; i <= 10; i++) {
                num[count] = sign * i;
                sum[count] = sum[count - 1] + sign * i ;
                dfs(count + 1);
            }
        }
    }

    public static boolean check(int count) {
        for(int i = 1; i < count; i++) {
            // map의 부호 검사
            // Integer.signum() 메소드: 입력한 부호를 양수면 1, 0이면 0, 음수면 -1로 변환
            if(Integer.signum(sum[count] - sum[i-1]) != map[i][count])
                return false;
        }
        return true;
    }
}