package day0913;

public class 패턴매칭_KMP {
	public static void main(String[] args) {
		String text = "ABABABACABAABABACACA";
		String pattern = "ABABACA";
		
		KMP(text,pattern);
	
	}

	public static void KMP(String T, String P) {
		int[] pi = getPi(P);

		int j = 0;

		for (int i = 0; i < T.length(); i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = pi[j - 1];
			}
			if (T.charAt(i) == P.charAt(j)) {
				if (j == P.length() - 1) {
					System.out.println((i - P.length() + 1) + " 위치 부터 시작하면 찾을 수 있음");
				} else {
					j++;
				}
			}
		}
	}

	public static int[] getPi(String P) {
		int[] pi = new int[P.length()];
		int j = 0;
		for (int i = 1; i < P.length(); i++) {
			while (j > 0 && P.charAt(i) != P.charAt(i))
				j = pi[j - 1];
			if (P.charAt(i) == P.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

}
