import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
	static int N;
	static List<Character>[] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner("2\r\n"
				+ "3\r\n"
				+ "01201011\r\n"
				+ "4\r\n"
				+ "000000123121");
		int T = sc.nextInt(), t = 0;
		while (t++ < T) {
			N = sc.nextInt();
			map = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				map[i] = new ArrayList<>();
			}
			char[] data = sc.next().toCharArray();
			for (int i = 0; i < data.length; i++) {
				input(data[i] - '0');
			}
			System.out.println("#" + t);
			print();
		}
		
	}
	private static void print() {
		for (int r = N - 1; r >= 0; r--) {
			for (int c = 0; c < N; c++) {
				if (map[c].size() <= r) {
					System.out.print(" ");
				} else {
					System.out.print(map[c].get(r));
				}
			}
			System.out.println();
		}
	}
	private static void input(int col) {
		if (map[col].size() == N) return;	// 해당 열에 별이 다 찾을 경우 더이상 입력 안되도록 금지
		map[col].add('*');
		// 별 삭제하기
		int c = 0;
		for ( ; c < N; c++) { 
			if (map[c].isEmpty()) break;	// 각 열에 별이 있는지 체크
		}
		if (c == N) {	// 모든 별들이 다 들어 있는 경우
			for (int i = 0; i < N; i++) {
				map[i].remove(0);
			}
		}
		
	}
}








