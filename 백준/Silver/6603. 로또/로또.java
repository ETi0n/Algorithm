import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if(n == 0){
                break;
            }

            arr = new int[n];
            visited = new boolean[n];

            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(0, 0);
            System.out.println();
        }
    }

    static void backTracking(int start, int depth){
        if(depth == 6){
            print();
        }

        for (int i=start; i<n; i++){
            visited[i] = true;
            backTracking(i+1, depth+1);
            visited[i] = false;
        }
    }

    static void print(){
        for(int i=0; i<n; i++){
            if(visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
