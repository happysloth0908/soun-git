package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	private final static int CMD_SUM  = 1;
	private final static int CMD_SUB = 2;
	private final static int CMD_MUL = 3;
	private final static int CMD_DIV = 4;
	private static boolean run(BufferedReader br) throws IOException {

		// 입력값을 스트링 토컨으로 만든다? 그리고 다음 토컨을 Q에 넣음?
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		//Q는 쿼리수 (API를 호출해서 결과값을 물어보는거)
		int Q = Integer.parseInt(st.nextToken());

		boolean isCorrect = true; 
		int cal;
		int A,B;
		int userAns, ans; 

		//토큰을 뭘 받는지에 따라 합을할지 곱할지 등이 결정됨. 
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			cal = Integer.parseInt(st.nextToken());
			switch(cal) 
			{
				case CMD_SUM:
					// 답이 input 에 있음. 그래서 걔랑 맞아야 함. 
					A = Integer.parseInt(st.nextToken());
					B = Integer.parseInt(st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					userAns = usersolution.sum(A,B);
					if(ans != userAns) 
						isCorrect = false; 
					break;
				
				case CMD_SUB:
					A = Integer.parseInt(st.nextToken());
					B = Integer.parseInt(st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					userAns = usersolution.sub(A,B);
					if(ans != userAns) 
						isCorrect = false; 
					break;
					
				case CMD_MUL:
					A = Integer.parseInt(st.nextToken());
					B = Integer.parseInt(st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					userAns = usersolution.mul(A,B);
					if(ans != userAns) 
						isCorrect = false; 
					break;
	
				case CMD_DIV:
					A = Integer.parseInt(st.nextToken());
					B = Integer.parseInt(st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					userAns = usersolution.div(A,B);
					if(ans != userAns) 
						isCorrect = false; 
					break;

				default:
					isCorrect = false;
					break;
			}
		}
		return isCorrect;
	}

	private final static UserSolution usersolution = new UserSolution();

	public static void main(String[] args) throws Exception {
		
		//input.txt 파일에서 br 가져온다
		 System.setIn(new java.io.FileInputStream("input.txt"));

		 //입력 데이터 가져옴
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int TC = Integer.parseInt(st.nextToken());
		int MARK = Integer.parseInt(st.nextToken());

		//mark 는 100으로 고정이니까
		//100점 아니면 0점
		for (int testcase = 1; testcase <= TC; testcase++) {
			int score = run(br) ? MARK : 0;
			System.out.println("#" + testcase + " " + score);
		}

		br.close();
	}
}