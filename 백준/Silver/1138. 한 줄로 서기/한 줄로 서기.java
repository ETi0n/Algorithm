import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] memoryArr = new int[N];
        for(int i = 0; i < N; i++){
            memoryArr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> order = new ArrayList<>();
        for(int i = N; i > 0; i--){
            // order.add(int index, Integer value);
            // 가장 오른쪽(N번째)에 선 사람부터 기억하는 키 큰 순서로 선다.
            // 가장 오른쪽(N번째)에 선 사람부터 하는 이유 : 무조건 0부터 시작, 자기보다 큰 사람이 왼쪽에 없었음.
            order.add(memoryArr[i-1], i);
        }

        for(int n : order){
            System.out.println(n);
        }
    }
}