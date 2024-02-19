import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
한수란, 각 자리수가 등차수열을 이루는 수를 의미한다.
1~99의 경우 그 수 자체가 수열이기 때문에 한수로 카운트한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int end = N+1;

        int result = 0;
        for(int i = 1; i < end; i++){
            if(i < 100){
                result++;
            } else{
                if(AP(i)) result++;
            }
        }

        System.out.println(result);
    }

    public static boolean AP(int end){
        String nToString = String.valueOf(end);
        int[] nArray = new int[nToString.length()];

        int temp = 0;
        for(char n : nToString.toCharArray()){
            nArray[temp++] = Integer.parseInt(String.valueOf(n));
        }

        int d = nArray[1] - nArray[0];
        for(int i = nArray.length - 1; i > 0; i--){
            if(nArray[i] - nArray[i-1] != d) return false;
        }

        return true;
    }
}