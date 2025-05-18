import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map = new boolean[100][100];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                map[i][j] = false;
            }
        }

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            isCheck(start_x, start_y);
        }


        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    static void isCheck(int start_x, int start_y){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(!map[start_x + i][start_y + j]){
                    map[start_x + i][start_y + j] = true;
                    count++;
                }
            }
        }
    }
}