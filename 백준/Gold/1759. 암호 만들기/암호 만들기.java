import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 조합론, 백트래킹 문제
public class Main {

    public static int L, C;
    public static char[] list;
    public static char[] code;
    public static boolean[] visited;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st =  new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());   // 암호 길이
        C = Integer.parseInt(st.nextToken());   // 주워진 문자 갯수
        code = new char[L];
        list = new char[C];
        visited = new boolean[C];

        st =  new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            list[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(list);
        getCode(0, 0);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getCode(int start, int idx){
        if(idx == L){
            if(check()){
                sb.append(code).append("\n");
            }
            return;
        }

        for(int i = start; i < C; i++){
            if(visited[i]) continue;

            code[idx] = list[i];
            visited[i] = true;
            getCode(i+1, idx+1);
            visited[i] = false;
        }
    }

    public static boolean check(){
        int vowel = 0;
        int consonant = 0;

        for(char c : code){
           if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowel++;
           else consonant++;
       }

        return vowel >= 1 && consonant >= 2;
    }
}