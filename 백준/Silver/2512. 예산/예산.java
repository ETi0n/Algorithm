import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지방의 수 N
        int N = Integer.parseInt(br.readLine());

        // 각 지방의 예산요청
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        int arrMax = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            arrMax = Math.max(arrMax, arr[i]);
        }

        // 총 예산 M
        int M = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(arr, 0, arrMax, M));
    }

    public static int binarySearch(int[] arr, int start, int end, int max){
        int sum, mid = 0;
        
        while(start <= end) {
            mid = (start + end) / 2;

            // 총 상한액 계산
            sum = 0;
            for(int n : arr){
                if(n <= mid) sum += n;
                else sum += mid;
            }

            // 총 상한액과 예산안 비교
            if(sum == max) return mid;
            else if(sum < max) start = mid + 1;
            else end = mid - 1;
        }

        return end;
    }
}
