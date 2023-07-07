import java.io.*;
import java.util.*;


class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int N = park.length;
        int M = park[0].length();
        int[][] arr = new int[N][M];
        int[] start = new int[2];
        for(int i = 0;i < park.length;i++) {
            for(int j = 0;j < park[i].length(); j++){
                // System.out.println(j);
                if(park[i].charAt(j) == 'S'){
                    arr[i][j] = 1;
                    start[0] = i;
                    start[1] = j;
                } else if (park[i].charAt(j) == 'O'){
                    arr[i][j] = 0;
                } else if (park[i].charAt(j) == 'X'){
                    arr[i][j] = 2;
                }
            }
        }
        
        // for(int i = 0 ;i < arr.length; i++) {
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        for(int i = 0;i < routes.length; i++){
            String[] temp = routes[i].split(" ");
            char pos = temp[0].charAt(0);
            int c = Integer.parseInt(temp[1]);
            int t = 0;
            int prev = 0;
            switch(pos){
                case 'E':
                    prev = start[1];
                    for(int j = 0; j < c; j++) {
                        t = start[1] + dy[0];    
                        if(check(M ,t)) {
                            if(arr[start[0]][t]==2) {
                                start[1] = prev;
                                System.out.println("out");
                                break;
                            }
                            start[1] = t;
                        } else {
                            start[1] = prev;
                            break;
                        }
                    }
                    break;
                case 'W':
                    prev = start[1];
                    for(int j = 0; j < c; j++) {
                        t = start[1] + dy[1];    
                        if(check(M ,t)) {
                            if(arr[start[0]][t]==2) {
                                start[1] = prev;
                                break;
                            }
                            start[1] = t;
                        } else {
                            start[1] = prev;
                            break;
                        }
                    }
                    break;
                case 'S':
                    prev = start[0];
                    for(int j = 0; j < c; j++) {
                        t = start[0] + dx[2];    
                        if(check(N ,t)) {
                            if(arr[t][start[1]]==2) {
                                start[0] = prev;
                                break;
                            }
                            start[0] = t;
                        }else {
                            start[0] = prev;
                            break;
                        }
                    }
                    break;
                case 'N':
                    prev = start[0];
                    for(int j = 0; j < c; j++) {
                        t = start[0] + dx[3];    
                        if(check(N ,t)) {
                            if(arr[t][start[1]]==2) {
                                start[0] = prev;
                                break;
                            }
                            start[0] = t;
                        } else {
                            start[0] = prev;
                            break;
                        }
                    }
                    break;
            }
            // System.out.println(Arrays.toString(start));
        }
        answer = start;
        return answer;
    }
    
    public boolean check(int p, int x) {
        if(x < 0 || x >= p){
            return false;
        }
        return true;
    }
}
