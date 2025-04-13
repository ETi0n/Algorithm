import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine()) + 1;
        if(num < 3){
            bw.write(String.valueOf(num - 1));
        } else {
            int[] arr = new int[num];
            arr[0] = 0;
            arr[1] = 1;

            for(int i = 2; i < num; i++){
                arr[i] = arr[i-2] + arr[i-1];
            }

            bw.write(String.valueOf(arr[arr.length - 1]));
        }

        bw.flush();
        bw.close();
    }
}