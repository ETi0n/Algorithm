import java.io.*;
import java.util.*;

public class Main {
    // 전체 트리 배열과 방문여부 확인 배열
    static int[][] treeArray;
    static boolean[] visited;
    
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();
    static int node, line, start;
    
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken()); // 정점개수
		line = Integer.parseInt(st.nextToken()); // 간선개수
		start= Integer.parseInt(st.nextToken()); // 시작정점번호
        
        // node가 1부터 시작하기 때문에 node + 1
        treeArray = new int[node+1][node+1];
        visited = new boolean[node+1];
        
        for(int i = 0 ; i < line ; i ++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			treeArray[a][b] = treeArray[b][a] =  1;	
		}
        
		dfs(start);
		sb.append("\n");
        
		visited = new boolean[node+1];
		bfs(start);
		
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
    
    // DFS: 스택과 재귀를 활용해 구현
    public static void dfs(int start) {
		visited[start] = true;
		sb.append(start).append(" ");
		for(int i = 0 ; i <= node ; i++) {
			if(treeArray[start][i] == 1 && !visited[i])
				dfs(i);
		}
	}
	
    // BFS: 큐를 활용를 활용해 구현
	public static void bfs(int start) {
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			start = q.poll();
			sb.append(start).append(" ");
			for(int i = 1 ; i <= node ; i++) {
				if(treeArray[start][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}