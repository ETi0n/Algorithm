import java.io.*;
import java.util.StringTokenizer;

// 백트래킹 문제
public class Main {

    public static int N;
    public static int[][] map;
    public static boolean[] team;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // N은 늘 짝수
        map = new int[N][N];
        team = new boolean[N]; // start 팀: 1, link 팀: 0 

        for(int i = 0; i < N; i++){
            st =  new StringTokenizer(br.readLine());

            int idx = 0;
            while(st.hasMoreTokens()){
                map[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        getComb(0, 0);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getComb(int start, int dept){
        if(dept == N/2){
            min = Math.min(min, getSkillGap());
            return;
        }

        for(int i = start; i < N; i++){
            if(!team[i]){
                team[i] = true;
                getComb(i+1, dept+1);
                team[i] = false;
            }
        }
    }

    public static int getSkillGap(){
        int start = 0;
        int link = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(team[i] && team[j]) start += map[i][j];
                if(!team[i] && !team[j]) link += map[i][j];
            }
        }

        return Math.abs(start - link);
    }
}