import java.io.*;
import java.util.StringTokenizer;

// 블로그..
public class Main {

    static int n;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(findNext()){
            for(int val : arr) bw.write(val + " ");
        } else bw.write("-1");

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean findNext() throws IOException {

        int idx1 = -1;
        for(int i = n - 1; i > 0; i--){
            if(arr[i - 1] > arr[i]){ // 제일 먼저 다음 숫자보다 작은 값
                idx1 = i;
                break;
            }
        }
        if(idx1 == -1) return false;

        int idx2 = -1;
        for(int i = n - 1; i >= idx1; i--){ // idx1보다 이전에
            if(arr[idx1 - 1] > arr[i]){ // idx1의 값보다 작은 값
                idx2 = i;
                break;
            }
        }

        swap(idx1-1, idx2);
        idx2 = n - 1;

        while(idx1 < idx2){
            swap(idx1++, idx2--);
        }

        return true;
    }

    private static void swap(int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}