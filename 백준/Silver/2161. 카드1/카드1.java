import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> card = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        // 카드의 수 N장
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i < N+1; i++){
            card.add(i);
        }

        while(!card.isEmpty()){
            // 최상위 카드 버리기
            answer.add(card.get(0));
            card.remove(0);

            // 최상위 카드 밑으로 옮기기
            if(!card.isEmpty()) {
                card.add(card.get(0));
                card.remove(0);
            }
        }

        for(int n : answer){
            System.out.println(n);
        }
    }
}