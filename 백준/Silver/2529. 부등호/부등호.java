import java.io.*;
import java.util.StringTokenizer;

// 백트래킹 문제
public class Main {

    public static int k;
    public static String[] symbol;
    public static int[] result;
    public static boolean[] visited;
    public static String min = "~"; // 사전식으로 가장 큰 값
    public static String max = ""; // 사전식으로 가장 작은 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine()); // 2 ≤ k ≤ 9
        symbol = new String[k];
        result = new int[k+1];
        visited = new boolean[10]; // 사용 중인 숫자 값

        int idx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            symbol[idx++] = st.nextToken();
        }

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            result[0] = i;
            dfs(i,0);
            visited[i] = false;
        }

        bw.write(String.valueOf(max) + "\n");
        bw.write(String.valueOf(min) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // start: 다음 숫자
    // dept: result index 위치
    public static void dfs(int start, int dept){
        if(dept == k){
            String num = getSize();
            if (min.compareTo(num) > 0) min = num; // 유니코드 값 기준으로 비교
            if (max.compareTo(num) < 0) max = num;
            return;
        }

        for(int i = 0; i < 10; i++){
            if(!visited[i]){
                if(symbol[dept].equals("<")){
                    if(start < i){
                        visited[i] = true;
                        result[dept+1] = i;
                        dfs(i, dept+1);
                        visited[i] = false;
                    }

                } else {
                    if(start > i){
                        visited[i] = true;
                        result[dept+1] = i;
                        dfs(i, dept+1);
                        visited[i] = false;
                    }
                }

            }
        }
    }

    public static String getSize(){
        StringBuilder num = new StringBuilder();

        for(int i = 0; i < k+1; i++){
            num.append(result[i]);
        }

        return num.toString();
    }
}