class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int minIdx = 0;
        int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
        
        int len = a.length;
        for(int i = 0; i < len; i++){
            if(min > a[i]){
                min = a[i];
                minIdx = i;
            }
        }
        for(int i = 0; i < minIdx; i++){
            if(leftMin > a[i]){
                leftMin = a[i];
                answer++;
            }
        }
        for(int i = len-1; i > minIdx; i--){
            if(rightMin > a[i]){
                rightMin = a[i];
                answer++;
            }
        }

        
        return answer+1;
    }
}
