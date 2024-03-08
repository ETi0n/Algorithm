import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int r, c, answer = 0;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 예제 : 2 3 1 | 결과 : 11
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 초기 사이즈 계산
        int size = (int) Math.pow(2, N);

        partition(0, 0, size);

        System.out.println(cnt);
    }

    public static void partition(int row, int col, int size){
        if(size == 1){
            return;
        }

        size /= 2; // 사이즈를 반으로 줄임

        if(r < row + size){
            if(c < col + size){ // 제 1사분면
                partition(row, col, size);
            }
            else{ // 제 2사분면으로 이동, 지나온 칸 수만큼 카운트 증가
                cnt += size * size;
                partition(row, col + size, size);
            }
        }
        else{
            if(c < col + size){ // 제 4사분면으로 이동, 지나온 칸 수만큼 카운트 증가
                cnt += size * size * 2;
                partition(row + size, col, size);
            } else{ // 제 3사분면으로 이동, 지나온 칸 수만큼 카운트 증가
                cnt += size * size * 3;
                partition(row + size, col + size, size);
            }
        }
    }
}
