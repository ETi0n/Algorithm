import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Double> map = Map.of(
                "A+", 4.5,
                "A0", 4.0,
                "B+", 3.5,
                "B0", 3.0,
                "C+", 2.5,
                "C0", 2.0,
                "D+", 1.5,
                "D0", 1.0,
                "F", 0.0,
                "P", 0.0
        );

        int num = 20;
        double sum = 0;
        double result = 0;
        double[] score = new double[20];
        String[] rating = new String[20];

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();

            score[i] = Double.parseDouble(st.nextToken());
            rating[i] = st.nextToken();

            if(!rating[i].equals("P")) sum += score[i];
        }

        for(int i = 0; i < num; i++){
            result += score[i] * map.get(rating[i]);
        }

        result = result / sum;

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}