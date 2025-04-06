import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i < n + 1; i++){
            for(int j = n - i; j > 0; j--){
                bw.write(" ");
            }

            for(int k = 0; k < (i*2)-1; k++){
                bw.write("*");
            }
            bw.newLine();
        }

        for(int i = 1; i < n; i++){
            for(int k = 0; k < i; k++){
                bw.write(" ");
            }

            for(int j = ((n - i) * 2) - 1; j > 0; j--){
                bw.write("*");
            }

            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}