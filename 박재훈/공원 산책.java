class Solution {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public int[] solution(String[] park, String[] routes) {
        int cr = 0, cc = 0;
        int H = park.length;
        int W = park[0].length();
        char[][] map = new char[H][W];
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                char ch = park[i].charAt(j);
                if(ch == 'S'){
                    cr = i;
                    cc = j;
                    map[i][j] = 'O';
                }else{
                    map[i][j] = ch;
                }
            }
        }
        
        int len = routes.length;
        for(int i = 0; i < len; i++){
            String[] input = routes[i].split(" ");
            char cdir = input[0].charAt(0);
            int dir = convertDir(cdir);
            int dist = Integer.parseInt(input[1]);
            boolean enable = true;
            for(int j = 1; j <= dist; j++){
                int nr = cr + dr[dir] * j;
                int nc = cc + dc[dir] * j;
                if(!checkRange(nr, nc, H, W) || map[nr][nc] == 'X'){
                    enable = false;
                    break;
                }
            }
            if(enable){
                cr += dr[dir] * dist;
                cc += dc[dir] * dist;
            }
        }
        int[] answer = {cr, cc};
        return answer;
    }
    static int convertDir(char c){
        if(c == 'E'){
            return 0;
        }
        if(c == 'S'){
            return 1;
        }
        if(c == 'W'){
            return 2;
        }
        return 3;
    }
    static boolean checkRange(int r, int c, int h, int w){
        return r >= 0 && r < h && c >= 0 && c < w;
    }
}
