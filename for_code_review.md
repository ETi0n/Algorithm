노션 참고 링크입니다.

https://www.notion.so/1cde3eb91c8b8075aed9e3192ace404d?pvs=4


<br/>

### 2563번 색종이
```
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map = new boolean[100][100];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                map[i][j] = false;
            }
        }

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            isCheck(start_x, start_y);
        }


        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    static void isCheck(int start_x, int start_y){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(!map[start_x + i][start_y + j]){
                    map[start_x + i][start_y + j] = true;
                    count++;
                }
            }
        }
    }
}
```

### 1094번 막대기
```
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int stick = 64; // 초기 막대기의 길이
        int X = Integer.parseInt(br.readLine()); // 원하는 막대의 길이
        
        Stack<Integer> stack = new Stack<Integer>(); // 자른 막대들을 보관
        stack.add(stick);

        while(stick != X){
            int half = stack.pop() / 2; // 가장 짧은 막대의 절반
            stick = stick - half;
            stack.add(half);

            if(stick < X){  // 반으로 자른 막대의 합이 X보다 작다면 자른 반을 다시 자르고, 아니면 버림
                stack.add(half);
                stick = stick + half;
            }
        }

        bw.write(String.valueOf(stack.size()));
        bw.flush();
        bw.close();
    }
}
```

### 14725번 개미굴
```
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
```

### 2751번 수 정렬하기 2
``` 
import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            arr[i] = number;
        }

        /// 자바 내장함수인 Arrays.sort는 내부적으로 DualPivotQuicksort.sort()를 호출한다.
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
```

### 20944번 팰린드롬 척화비
```
import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        /// 팰린드롬과 수미상관를 만족하는 결과를 출력하면 된다. 
        /// = 즉, 걍 같은 글자만 반복하면 된다.
        char[] arr = new char[N];
        Arrays.fill(arr, 'a');

        bw.write(arr);
        bw.flush();
        bw.close();
    }
}
```

### 1927번 최소 힙
```
import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 우선 순위 큐 : 매개변수에 아무 값을 넣지 않으면 기본 정렬 방법(오름차순)을 따른다.
        // 필요 시 Comparable interface를 상속받아 compareTo 메서드를 구현해 우선 순위 지정이 가능하다.
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 출력용 StringBuilder
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());

            if(n != 0){ // 자연수라면 저장
                queue.add(n);
            } else { // 자연수가 아니라면(= 0 이라면) 출력
                if(queue.isEmpty()){
                    sb.append(0 + "\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            }
        }


        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
```

### 27433번 팩토리얼 2
- 처음 틀린 이유: 20일때는 int형 자료값의 범위를 넘어가서
```
import java.io.*;

public class Main {
    static long sum = 1; // int 자료형 범위는 N=20일 때의 값보다 작아서 오류 발생

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        factorial(n);

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }

    public static void factorial(int n){
        if(n == 1) return; // 값이 초기값으로 주어지므로 계산 횟수 줄이기.
        else if(n == 0) return;

        sum = sum * n--;
        factorial(n);
    }
}
```

### 1436번 영화감독 숌
- 초기에는 배열의 크기가 3인 값을 지정하고 2번째에 666을 넣고 좌우 배열을 조절하려 했지만 그 경우 로직 처리가 어려웠음
```
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int result = 666;

        while (true) {
            // 현재 값이 666을 포함하고 있다면 더하고, 아니라면 넘어가기
            if (String.valueOf(result).contains("666")) {
                count++;
                if (count == N) {
                    // 666이 포함된 N번째 숫자 출력
                    bw.write(String.valueOf(result));
                    break;
                }
            }
            result++;
        }

        bw.flush();
        bw.close();
    }
}
```
