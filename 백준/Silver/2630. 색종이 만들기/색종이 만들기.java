import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int white = 0;
    public static int blue = 0;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        8
        1 1 0 0 0 0 1 1
        1 1 0 0 0 0 1 1
        0 0 0 0 1 1 0 0
        0 0 0 0 1 1 0 0
        1 0 0 0 1 1 1 1
        0 1 0 0 1 1 1 1
        0 0 1 1 1 1 1 1
        0 0 1 1 1 1 1 1
         */
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row, int col, int size){
        // 현재 파티션의 색깔이 전원 같은 지 확인
        if(colorCheck(row, col, size)){
            if(map[row][col] == 0){
                white++;
            }
            else{
                blue++;
            }
            return;
        }

        size = size/2;

        // 재귀호출 시작
        partition(row, col, size);                          // 제 1사분면
        partition(row, col + size, size);               // 제 2사분면
        partition(row + size, col, size);               // 제 3사분면
        partition(row + size, col + size, size);    // 제 4사분면
    }

    public static boolean colorCheck(int row, int col, int size){
        int color = map[row][col]; // 첫 번째 원소를 기준으로 검사

        for(int i = row; i < row + size; i++){
            for(int  j = col; j < col + size; j++){
                if(map[i][j] != color){ // 같은 색깔이 아니면 false 반환
                    return false;
                }
            }
        }

        return true;
    }
}