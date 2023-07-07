import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int mlen = minerals.length;
        int plen = picks.length;
        int limit = 0;
        for(int i = 0; i < plen; i++){
            limit += picks[i];
        }
        limit *= 5;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return Integer.compare(o2[1], o1[1]);
                }
                return Integer.compare(o2[0], o1[0]);
            }
        });
        int[] arr = new int[3];
        limit = Math.min(limit, mlen);
        for(int i = 0; i < limit; i++){
            if(minerals[i].equals("diamond")){
                arr[0]++;
            }else if(minerals[i].equals("iron")){
                arr[1]++;
            }else{
                arr[2]++;
            }
            if(i % 5 == 4 || i == limit-1){
                pq.add(arr);
                arr = new int[3];
            }
        }
        int pIdx = 0;
        while(!pq.isEmpty()){
            while(picks[pIdx] == 0){
                if(++pIdx > 2) break;
            }
            if(pIdx > 2) break;
            
            int[] cur = pq.poll();
            if(pIdx == 0){
                answer += (cur[0] + cur[1] + cur[2]);
            }else if(pIdx == 1){
                answer += (5*cur[0] + cur[1] + cur[2]);
            }else{
                answer += (25*cur[0] + 5*cur[1] + cur[2]);
            }
            picks[pIdx]--;
        }
        
        return answer;
    }
    static int caculateFatigue(int pIdx, int mType){
        int val = pIdx - mType;
        if(val == 2){
            return 25;
        }else if(val == 1){
            return 5;
        }
        return 1;
        
    }
}
