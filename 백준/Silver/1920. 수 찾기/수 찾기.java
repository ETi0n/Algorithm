import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 중복을 걸러내고 데이터를 key로 순서와 상관없이 확인하므로, ArrayList와 LinkedList보다 빠르다
        HashSet<String> list = new HashSet<>();

        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        while(st.hasMoreTokens()){
            if(list.contains(st.nextToken())) sb.append("1" + "\n");
            else sb.append("0" + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
}