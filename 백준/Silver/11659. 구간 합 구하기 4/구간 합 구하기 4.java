import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        // 첫번째 입력: 개수 N과 횟수 M
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
        // 두번째 입력: N개의 숫자들
        // 각각의 배열은 해당 숫자까지의 합을 대입
		st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        arr[0] = 0;
		for(int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		
        
        // 세번째 입력: 구간 i와 j
        // 마지막 숫자 j까지의 합 - 처음 숫자 i까지의 합 = i와 j의 구간 합
        StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(arr[end] - arr[start - 1]).append("\n");
		}
        
		System.out.println(sb);
	}

}