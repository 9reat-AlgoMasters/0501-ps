import java.io.*;
import java.util.*;

class Solution {
    // dp
    // 각점수에 대한 최소 횟수, 최소횟수 일때 최대 싱글, 불 횟수
    // 1~60 값 다 구해두고 배낭문제 처럼 푼다
    public int[] solution(int target) {
        int[] answer = {};
        
        // 횟수 배열
        int[] arr = new int[target + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        // 싱글, 불
        int[] s = new int[target + 1];
        
        
        for(int i = 1; i <= target; i++) {
            // 불
            if(i >= 50){
                if(arr[i] >= arr[i - 50] + 1) {
                    arr[i] = arr[i - 50] + 1;

                    if(arr[i] == arr[i - 50] + 1) {
                        s[i] = Math.max(s[i], s[i - 50] + 1);
                    } else{
                        s[i] = s[i - 50] + 1;
                        // s[i] = Math.max(s[i], s[i - 50] + 1);
                    }
                } 
            }
            for(int j= 1;j < 21;j++) { 
                
                // 싱글
                if(i >= j){
                    if(arr[i] >= arr[i - j] + 1) {
                        arr[i] = arr[i - j] + 1;
                        if (i > 20) {
                           if(arr[i] == arr[i - j] + 1) {
                                s[i] = Math.max(s[i], s[i - j] + 1); 
                            } else {
                                s[i] = s[i - j] + 1;
                                // s[i] = Math.max(s[i], s[i - j] + 1);
                            } 
                        } else {
                            s[i] = 1;
                        }
                        
                    } 
                }
                
                // 더블
                if(i >= 2 * j){
                    if(arr[i] > arr[i - 2 * j] + 1){
                        arr[i] = arr[i - 2 * j] + 1;
                        s[i]= s[i - 2 * j];
                    }
                }
                // 중복 지워주자...
                if(i < 21) {
                    s[i] = 1;
                }
                
                // 트리플
                if(i >= 3 * j){
                    if(arr[i] > arr[i - 3 * j] + 1){
                        arr[i] = arr[i - 3 * j] + 1;
                        s[i]= s[i - 3 * j];
                    }
                }
                if(i < 21) {
                    s[i] = 1;
                }
                
                
                
            }
            
        }
        
        answer = new int[]{arr[target], s[target]};
        
        return answer;
    }
}

// 1~20 까지 숫자에 각각 싱글 더블 트리플, 50점 불 

// 모든 점수를 다 뽑아둠
// bfs로 모든 경우 본다(싱글, 불 전부 다 저장해준다)
// 최소횟수인경우가 여러가지 인경우 싱글, 불 최대로
// 100퍼센트 터지것네


// dp
// 각점수에 대한 최소 횟수, 최소횟수 일때 최대 싱글, 불 횟수
// 1~60 값 다 구해두고 배낭문제 처럼 푼다

