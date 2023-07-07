import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static int min;
    static int[][] arr;
    static int[] pick;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        N = minerals.length/5 + 1;
        arr = new int[N][3];
        min = Integer.MAX_VALUE;
        pick = picks;
        int cnt = 0;
        
        
        for(int i = 0; i < minerals.length; i+=5) {
            int sumD = 0;
            int sumI = 0;
            int sumS = 0;
            for(int j = i; j < i + 5; j++){
                if (j == minerals.length) {
                    break;
                }
                if(minerals[j].equals("diamond")) {
                    sumD += 1;
                    sumI += 5;
                    sumS += 25;
                } else if(minerals[j].equals("iron")) {
                    sumD += 1;
                    sumI += 1;
                    sumS += 5;
                } else if(minerals[j].equals("stone")){
                    sumD += 1;
                    sumI += 1;
                    sumS += 1;
                }
            }
            
            arr[cnt] = new int[]{sumD, sumI, sumS};
            cnt++;
            
        }
        
        solve(0, 0);
        
        answer = min;
        return answer;
    }
    
    public void solve(int cnt, int sum) {
        if (cnt == N) {
            if(sum < min) {
                min = sum;
            }
            return;
        }
        
        if(pick[0] == 0 && pick[1] == 0 && pick[2] == 0){
            if(sum < min) {
                min = sum;
            }
            return;
        }
        
        for(int i = 0; i < 3;i++){
            if(pick[i] != 0) {
                pick[i]--;
                solve(cnt + 1, sum + arr[cnt][i]);
                pick[i]++; 
                 
            }
            
        }
    }
}
