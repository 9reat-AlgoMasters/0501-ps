import java.util.*;

class Solution {

    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] times = new int[book_time.length][2];

        for (int i=0; i<book_time.length; i++) {
            times[i][0] = toMinutes(book_time[i][0]);
            times[i][1] = toMinutes(book_time[i][1]) + 10;
        }
        Arrays.sort(times, (a, b) -> {
            return a[0]-b[0];
        });
        ArrayList<Integer> rooms = new ArrayList<>();
        int flag = 0;
        for (int i=0; i<times.length; i++) {
            int start = times[i][0];
            int end = times[i][1];
            for (int j=0; j<rooms.size(); j++) {
                if (rooms.get(j) <= start) {
                    rooms.set(j, end);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                rooms.add(end);
            }
            else {
                flag = 0;
            }
        }
        return rooms.size();

    }

    public int toMinutes(String time) {
        String[] arr = time.split(":");
        int h = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        return h * 60 + m;
    }
}