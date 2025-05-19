import java.io.*;
import java.util.*;

public class Main {
    static class node {
        HashMap<String, node> child;

        public node(){
            child = new HashMap<>();
        }
    }

    static node root = new node();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            node curr = root;

            for(int j = 0; j < idx; j++){
                String temp = st.nextToken();

                if(!curr.child.containsKey(temp)){
                    curr.child.put(temp, new node());
                }
                curr = curr.child.get(temp);
            }
        }

        print(root, "");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void print(node curr, String s){
        ArrayList<String> list = new ArrayList<>(curr.child.keySet()); // ketSet : Map 전체를 순회(key 값만 필요한 경우)
        Collections.sort(list);

        for(String str : list){
            sb.append(s).append(str).append("\n");

            print(curr.child.get(str), s + "--");
        }
    }
}