import java.util.*;

class Solution {
    static int N, M;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static HashMap<String, Integer> dict = new HashMap<>();

    public int[] solution(String[] park, String[] routes) {
        N = park.length;
        M = park[0].length();
        dict.put("N", 0);
        dict.put("E", 1);
        dict.put("S", 2);
        dict.put("W", 3);

        int[] startPoint = findStartPoint(park);
        return solve(startPoint, park, routes);
    }

    public static int[] solve(int[] startPoint, String[] park, String[] routes) {
        int[] answer = new int[]{startPoint[0], startPoint[1]};

        for (int i=0; i<routes.length; i++) {
            String direction = routes[i].split(" ")[0];
            int cnt = Integer.parseInt(routes[i].split(" ")[1]);
            answer = move(answer[0], answer[1], direction, cnt, park);
        }
        return answer;
    }
    public static int[] move(int r, int c, String direction, int cnt, String[] park) {
        int nr = r;
        int nc = c;
        boolean isSuccess = true;

        for (int i=0; i<cnt; i++) {
            nr += dr[dict.get(direction)];
            nc += dc[dict.get(direction)];
            if (!check(nr, nc) || park[nr].charAt(nc) == 'X') {
                isSuccess = false;
                break;
            }
        }
        if (isSuccess) return new int[]{nr, nc};
        else return new int[]{r, c};
    }

    public static boolean check(int r, int c) {
        return 0<=r && r<N && 0 <=c && c<M;
    }

    public int[] findStartPoint(String[] park) {

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (park[i].charAt(j) == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}