import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        
        // 우선순위 큐: 가장 큰 값을 선입선출 하기 위해 기본 우선순위(오름차순)의 반대로 설정
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            int element = Integer.parseInt(br.readLine());

            if(element > 0){
                queue.add(element);
            } else {
                if(queue.isEmpty()) sb.append(0 + "\n");
                else sb.append(queue.poll() + "\n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
}