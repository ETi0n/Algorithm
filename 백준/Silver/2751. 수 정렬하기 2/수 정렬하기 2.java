import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            arr[i] = number;
        }

        /// 자바 내장함수인 Arrays.sort는 내부적으로 DualPivotQuicksort.sort()를 호출한다.
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}