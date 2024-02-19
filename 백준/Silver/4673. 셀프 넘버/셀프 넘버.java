import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();

        int cnt = 1;
        while(cnt < 10001){
            set.add(Calculate(cnt));

            if(!set.contains(cnt)){
                System.out.println(cnt);
            }
            cnt++;
        }
    }

    public static int Calculate(int start){
        int sum = start;
        String nToString = String.valueOf(start);
        for(char n : nToString.toCharArray()){
            sum += Integer.parseInt(String.valueOf(n));
        }

        return sum;
    }
}