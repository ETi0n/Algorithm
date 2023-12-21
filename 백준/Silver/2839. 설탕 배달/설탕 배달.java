import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] suger = {5, 3};
        int n = Integer.parseInt(input);
        int sum = 0;

        if(n % 5 == 0) sum = n / 5;
        for(int i = n / 5; i >= 0; i--){
            int m = n - (i * 5);
            if(m % 3 == 0){
                sum = i + m / 3;
                break;
            }
        }

        if(sum == 0) sum = -1;

        System.out.print(sum);
    }
}