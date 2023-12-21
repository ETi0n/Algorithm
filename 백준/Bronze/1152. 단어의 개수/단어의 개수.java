import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] words = input.split(" ");
        int cnt = 0;
        
        for (int i = 0, n = words.length; i < n; i++) {
            if(!words[i].isEmpty()) cnt++;
        }
        
        System.out.print(cnt);
        br.close();
    }
}