import java.io.*;
import java.util.*;

public class Main{

    public static int N;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int S = 0; // 비트 연산이 실행될 공간
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            if(str.equals("all")) S = (1 << 21) - 1;
            else if(str.equals("empty")) S = 0;
            else {
                int num = Integer.parseInt(st.nextToken());

                if(str.equals("add")) S |= (1 << num); // or 연산
                else if(str.equals("remove")) S &= ~(1 << num); // and 연산
                else if(str.equals("toggle")) S ^= (1 << num); // xor 연산
                else if(str.equals("check")) sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}