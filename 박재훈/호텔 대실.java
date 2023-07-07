import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, new Comparator<String[]>(){
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });
        int len = book_time.length;
        boolean[] visited = new boolean[len];
        for(int i = 0; i < len; i++){
            if(visited[i]) continue;
            visited[i] = true;
            answer++;
            String outTime = book_time[i][1];
            for(int j = i+1; j < len; j++){
                if(visited[j]) continue;
                String inTime = book_time[j][0];
                if(!canEnter(outTime, inTime)) continue;
                visited[j] = true;
                outTime = book_time[j][1];
            }
        }
        return answer;
    }
    static boolean canEnter(String s1, String s2){
        String[] input1 = s1.split(":");
        int h1 = Integer.parseInt(input1[0]);
        int m1 = Integer.parseInt(input1[1]);
        String[] input2 = s2.split(":");
        int h2 = Integer.parseInt(input2[0]);
        int m2 = Integer.parseInt(input2[1]);
    
        int timestamp1 = h1*60 + m1 + 10;
        int timestamp2 = h2*60 + m2;
        return timestamp1 <= timestamp2;
    }
}
