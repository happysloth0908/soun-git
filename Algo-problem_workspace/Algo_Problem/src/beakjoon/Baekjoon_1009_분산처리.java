package beakjoon;

import java.util.Scanner;

public class Baekjoon_1009_분산처리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            int result = 1;
            for(int i = 0; i < b; i++) {
                result = (result * a) % 10;
            }
            
            if(result == 0) result = 10;  // 0이 나오면 10번 컴퓨터가 처리
            System.out.println(result);
        }
    }
}