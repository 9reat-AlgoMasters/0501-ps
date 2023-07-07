import java.util.*;

class Solution {
    static int[][] cost = new int[][] { {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1}};
    static HashMap<String, Integer> target = new HashMap<>() {{
        put("diamond", 0);
        put("iron", 1);
        put("stone", 2);
    }};

    static int N, R;
    static int[] nums, pick;
    static boolean[] visited;
    static int answer = 15 * 5 * 25;

    public int solution(int[] picks, String[] minerals) {
        for (int i=0; i<picks.length; i++) {
            N += picks[i];
        }
        visited = new boolean[N];
        nums = new int[N];

        int index = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<picks[i]; j++) {
                nums[index++] = i;
            }
        }
        int ml = minerals.length;
        R = (N * 5 < ml) ? N : (ml % 5 > 0) ? ml /5 +1 : ml /5;
        pick = new int[R];
        dfs(0, minerals);
        return answer;
    }

    public static void dfs(int cnt, String[] minerals) {
        if (cnt == R) {
            answer = Math.min(calc(pick, minerals), answer);
            return;
        }

        for (int i=0; i<N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            pick[cnt] = nums[i];
            dfs(cnt+1, minerals);
            pick[cnt] = 0;
            visited[i] = false;
        }

    }
    public static int calc(int[] pick, String[] minerals) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add
        int hap = 0;
        int pickIndex = 0;
        int mineralIndex = 0;
        while(pickIndex < pick.length) {
            for (int i=0; i<5; i++) {
                if (mineralIndex >= minerals.length) {
                    return hap;
                }
                hap += cost[pick[pickIndex]][target.get(minerals[mineralIndex])];
                if (answer <= hap) return hap;
                mineralIndex++;
            }
            pickIndex++;
        }
        return hap;
    }
}