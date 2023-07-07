import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        int len = name.length;
        for(int i = 0; i < len; i++){
            String str = name[i];
            int val = yearning[i];
            
            System.out.println(str + " " + val);
            map.put(str, val);
        }
        len = photo.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++){
            int len2 = photo[i].length;
            int sum = 0;
            for(int j = 0; j < len2; j++){
                Integer val = map.get(photo[i][j]);
                if(val != null){
                    sum += map.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}
