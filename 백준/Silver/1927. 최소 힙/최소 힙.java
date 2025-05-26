import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 우선 순위 큐 : 매개변수에 아무 값을 넣지 않으면 기본 정렬 방법(오름차순)을 따른다.
        // 필요 시 Comparable interface를 상속받아 compareTo 메서드를 구현해 우선 순위 지정이 가능하다.
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 출력용 StringBuilder
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());

            if(n != 0){ // 자연수라면 저장
                queue.add(n);
            } else { // 자연수가 아니라면(= 0 이라면) 출력
                if(queue.isEmpty()){
                    sb.append(0 + "\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            }
        }


        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}