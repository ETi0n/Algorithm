import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ch = br.readLine().split("");
        StringBuilder sb = new StringBuilder();

        Set<String> start = Set.of("c", "d", "l", "n", "s", "z");
        Set<String> croatia = Set.of("c=", "c-", "dz=", "lj", "nj", "s=", "z=");



        int count = 0;
        int i = 0;
        for(i = 0; i < ch.length - 1; i++){
            switch (ch[i]){
                case "c" :
                    if(ch[i+1].equals("-") || ch[i+1].equals("=")){
                        i++;
                    }
                    count++;
                    break;
                case "d" :
                    if(ch[i+1].equals("-")){
                        i++;
                    } else if ((i < ch.length - 2) && ch[i+1].equals("z") && ch[i+2].equals("=")) {
                        i = i + 2;
                    }
                    count++;
                    break;
                case "l":
                    if(ch[i+1].equals("j")){
                        i++;
                    }
                    count++;
                    break;
                case "n" :
                    if(ch[i+1].equals("j")){
                        i++;
                    }
                    count++;
                    break;
                case "s" :
                    if(ch[i+1].equals("=")){
                        i++;
                    }
                    count++;
                    break;
                case "z" :
                    if(ch[i+1].equals("=")){
                        i++;
                    }
                    count++;
                    break;
                default: count++;
            }
        }

        if(i != ch.length) count++;

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}