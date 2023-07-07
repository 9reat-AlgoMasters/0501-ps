import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 1;
        
        int min = Integer.MAX_VALUE;
        int idx = 0;
        
        for(int i = 0;i < a.length; i++) {
            if(a[i] < min) {
                min = a[i];
                idx = i;
            }
        }
        
        int temp = a[0];
        int tempR = a[a.length - 1];
        
        for(int i = 1 ;i < idx;i++) {
                if(temp >= a[i]) {
                    temp = a[i];
                    answer += 1;
                }
        }
        
        answer += 1; // 맨 마지막 값은 항상 살아 남을수 있음으로
        
        for(int i = a.length - 1 ;i > idx;i--) {
            if(tempR >= a[i]) {
                tempR = a[i];
                answer += 1;
            }
            
        }
        
        return answer;
    }
}

// -68이 생존하는 경우
// 오른쪽 나보다 전부 크니 ok
// 왼쪽 나보다 작은게 2개 => 그럼 생존은 어떯게 하나? 두개가 붙어 있어서 하나가 지워질수 있어서?

// -71이 생존하는 경우
// 오른족 나보다 다 크니 ok
// 왼쪽 나보다 작은게 하나뿐 => 지울수 있으니 ok

// -16이 생존하는 경우
// 오른쪽 나보다 작은게 5개 => 그런데 전체에서 가장 작은 -92가 작은거 4개를 지워줄수 있다,
// 그런데 그럼 붙어있어서 지워줄수있는건가?? no 가장 작은 값이 있었기 때문에 다 지워준것

// 58이 생존못하는 이유
// 
