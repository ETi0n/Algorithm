import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        for(int n = 0; n < N; n++){
            arr.add(n + 1);
        }

        for(int n = 0; n < M; n++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            swap(i, j);
        }

        for(int n = 0; n < N; n++){
            bw.write(String.valueOf(arr.get(n)) + " ");
        }

        bw.flush();
        bw.close();
    }

    public static void swap(int i, int j){
        int n = (j - i) / 2 + 1;

        while (n-- > 0){
            Collections.swap(arr, i++, j--);
        }
    }
}