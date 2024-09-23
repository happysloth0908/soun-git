import java.util.Arrays;

public class 오늘의할일 {
	static int N, R;
	static int[] sel; // 각 자리에 선택된 값을 넣어주자
	static int[] data;
	public static void main(String[] args) {
//		System.out.println((int)(Math.random() * 20));
		
		N = 4;
		R = 3;
		data = new int[] {10, 20, 30, 40};
		
		sel = new int[N];
		부분집합재귀(0);
		sel = new int[R];
		조합재귀(0,0);
		
	}
	private static void 부분집합재귀(int idx) {
		if(idx == N) {
			for(int i = 0 ; i<N; i++) {
				if( sel[i] != 0) {
					System.out.print(data[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		sel[idx] = 1;
		부분집합재귀(idx+1);
		sel[idx] = 0;
		부분집합재귀(idx+1);
	}
	private static void 조합재귀(int idx, int sidx) {
		
		if(sidx == R) {
			System.out.println(Arrays.toString(sel));
			
			return;
		}
		if(idx == N) {
			
			return;
		}
		
		
		sel[sidx] = data[idx];
		조합재귀(idx+1, sidx+1);
		조합재귀(idx+1, sidx);
		
	}
	
	
}



