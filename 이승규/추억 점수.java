import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        // Map에 이름 : 추억점수 저장
        HashMap<String, Integer> dict = new HashMap<>();
        for (int i=0; i < name.length; i++) {
            dict.put(name[i], yearning[i]);
        }
        // 사진에 추억점수가 있는 이름이 있다면 result 배열에 누적
        int[] result = new int[photo.length];
        for (int i=0; i< photo.length; i++) {
            for (int j=0; j<photo[i].length; j++) {
                String person = photo[i][j];
                if (dict.containsKey(person)) {
                    result[i] += dict.get(person);
                }
            }
        }
        return result;
    }
}