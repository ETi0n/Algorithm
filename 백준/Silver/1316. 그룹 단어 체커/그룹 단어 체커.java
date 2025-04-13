import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int count = 0;

        Set<String> set = new HashSet<>();

        while(num-- != 0){
            String[] arr = br.readLine().split("");
            set.clear();
            
            for(int i = 0; i < arr.length-1; i++){
                set.add(arr[i]);

                if(arr[i].equals(arr[i+1])) continue;
                if(!arr[i].equals(arr[i+1]) && set.contains(arr[i+1])){
                    count--;
                    break;
                }
            }
            count++;
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}