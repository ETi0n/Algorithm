import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 1. 입력된 정보를 저장
        // 첫번째 입력값: N과 K값
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 둘번째 입력값: N개의 인형의 정보 
        // list에 라이언 위치 인덱스 저장
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n == 1){
                list.add(i);
            }
        }
        
        // 2. 슬라이딩 윈도우를 통해서 최소 크기 구하기
        // 라이언의 개수가 K개가 된 집합의 크기를 구하고 최소 여부 비교
        int result = Integer.MAX_VALUE;
        if(list.size() < K){
            result = -1;
        } else{
            for(int i = 0; i <= list.size() - K; i++){
                int start = list.get(i);
                int end = list.get(i + (K - 1));
                result = Math.min(result, (end - start) + 1);
            }
        }
        
        // 3. 최소 크기를 결과로 출력
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}