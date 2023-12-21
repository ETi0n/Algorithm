import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split("");
        
        for(char i = 'a'; i <= 'z'; i++){
            boolean found = false;
            for(int j = 0; j < strArr.length; j++){
                if(strArr[j].equals(String.valueOf(i))){
                    System.out.print(j + " ");
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.print("-1 ");
            }
        }
    }
}
