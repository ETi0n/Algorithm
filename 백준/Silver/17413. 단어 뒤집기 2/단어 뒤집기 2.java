import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Character> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String string = br.readLine();
        char[] c = string.toCharArray();
        
        for(int i = 0; i < c.length; i++){
            // 태그를 만났다면
            if(c[i] == '<'){
                isEmpty();
                while(c[i] != '>'){
                    System.out.print(c[i]);
                    i++;
                }
                System.out.print(c[i]);
                continue;
            }

            // 공백을 만났다면
            if(c[i] == ' '){
                isEmpty();
                System.out.print(' ');
                i++;
            }

            list.add(c[i]);
        }
        isEmpty();
    }

    // 만약 리스트가 채워져 있다면 리버스 값 출력
    static void isEmpty(){
        if(!list.isEmpty()){
            Collections.reverse(list);
            for(char c : list) System.out.print(c);
            list.clear();
        }
    }
}