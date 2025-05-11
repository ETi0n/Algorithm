import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 감염된 친구들 Set
        Set<String> friends = new HashSet<>();
        friends.add("ChongChong");

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if(friends.contains(A)) friends.add(B);
            if(friends.contains(B)) friends.add(A);
        }
        bw.write(String.valueOf(friends.size()));

        bw.flush();
        bw.close();
    }
}