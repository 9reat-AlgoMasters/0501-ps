import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] arr = new int[book_time.length][2];
        
        for(int i =0;i < arr.length; i++){
            String[] t = book_time[i][0].split(":");
            // System.out.println(Arrays.toString(t));
            int a = Integer.parseInt(t[0]);
            int b = Integer.parseInt(t[1]);
            
            int sum = a * 60 + b;
            arr[i][0] = sum;
            
            t = book_time[i][1].split(":");
            // System.out.println(Arrays.toString(t));
            a = Integer.parseInt(t[0]);
            b = Integer.parseInt(t[1]);
            
            sum = a * 60 + b + 10; // 청소 시간추가
            arr[i][1] = sum;
        }
        
        // for(int i = 0; i < arr.length; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
        
        // for(int i = 0; i < arr.length; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        
        List<Integer> rooms = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            boolean flag = false;
            if(rooms.size() == 0) {
                rooms.add(arr[0][1]);
                continue;
            }
            for(int j = 0; j < rooms.size();j++){
                if(rooms.get(j) <= arr[i][0]) {
                    rooms.set(j, arr[i][1]);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                rooms.add(arr[i][1]);
            }
            
            
        }
        
        // System.out.println(rooms);
        answer = rooms.size();
        
        return answer;
    }
}
