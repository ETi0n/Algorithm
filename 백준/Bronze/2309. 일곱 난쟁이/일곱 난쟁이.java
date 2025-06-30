import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        int sum = 0; // 전체 합

        for(int i = 0; i < 9; i++){
            list.add(Integer.parseInt(br.readLine()));
            sum += list.get(i);
        }

        int over = sum - 100; // over 된 값
        list.add(over);
        Collections.sort(list);

        int index = list.indexOf(over);

        // over 된 값을 기준으로 더 작은 수들 중에서 두 개의 합이 over 값과 같다면 정답
        Loop:
        for(int i = index - 1; i > 0 ; i--){
            for(int j = 0; j < i; j++){
                int a = list.get(i);
                int b = list.get(j);
                if(a + b == over){
                    list.remove(Integer.valueOf(over));
                    list.remove(Integer.valueOf(a));
                    list.remove(Integer.valueOf(b));
                    break Loop;
                }
            }
        }

        for(int i = 0; i < 7; i++){
            bw.write(String.valueOf(list.get(i) + "\n"));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}