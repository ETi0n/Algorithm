import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            Arrays.sort(arr);
            long temp = arr[0] + arr[1];

            arr[0] = temp;
            arr[1] = temp;
        }


        for (long l : arr) {
            answer += l;
        }

        System.out.println(answer);
    }
}
