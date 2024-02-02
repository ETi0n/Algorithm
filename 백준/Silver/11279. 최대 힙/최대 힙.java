import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        // 연산의 개수
        int n = Integer.parseInt(br.readLine());

        int x;
        for(int i=0; i<n; i++){
            x = Integer.parseInt(br.readLine());

            // x가 자연수인 경우 : 배열에 x라는 값을 추가
            if(x>0){
                q.add(x);
            }
            // x가 0인 경우 : 가장 큰 값 출력 후 배열에서 제거
            else{
                if(!q.isEmpty()){
                    System.out.println(q.poll());
                }
                else{
                    System.out.println(0);
                }
            }
        }
        br.close();
    }
}
