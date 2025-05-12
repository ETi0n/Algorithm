import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 입력 줄 개수

        // 위상정렬을 위한 진입차수 저장 배열
        int[] indegree = new int[N+1]; // (노드 번호가 1번부터 시작하기 때문에 +1)

        // 위상정렬에 사용할 그래프 2차원 리스트 구현
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < N+1; i++){
            graph.add(new ArrayList<Integer>());
        }

        // 리스트 초기화
        // 진입차수배열 값 초기화
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }

        // 위상정렬에 사용할 큐
        Queue<Integer> q = new LinkedList<>();

        // 진입차수가 0인 값을 큐에 삽입
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            int studentNo = q.poll();

            bw.write(String.valueOf(studentNo) + " ");

            List<Integer> list = graph.get(studentNo);

            for(int i = 0; i < list.size(); i++){
                int temp = list.get(i);
                indegree[temp]--;

                if(indegree[temp] == 0){
                    q.offer(temp);
                }
            }
        }

        bw.flush();
        bw.close();
    }
}