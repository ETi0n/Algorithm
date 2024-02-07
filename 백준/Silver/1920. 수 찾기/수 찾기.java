import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 번째 줄 : 자연수 N
        int N = Integer.parseInt(br.readLine());
        // 그 다음 줄 : N개의 정수
        st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        // 그 다음 줄 : 자연수 M
        int M = Integer.parseInt(br.readLine());
        // 그 다음 줄 : M개의 정수
        st = new StringTokenizer(br.readLine());

        int temp, num;
        for(int i = 0; i < M; i++){
            num = Integer.parseInt(st.nextToken());
            temp = binarySearch(A, 0, N-1, num);

            System.out.println(temp);
        }
    }
    
    public static int binarySearch(int[] arr, int start, int end, int n){
        if (start > end) return 0;
        
        int mid = (start + end) / 2;
        if(arr[mid] == n) return 1;
        else if(arr[mid] > n) return binarySearch(arr, start, mid-1, n);
        else return binarySearch(arr, mid+1, end, n);
    }
}