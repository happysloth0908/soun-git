package test;

//import java.util.HashMap;

class UserSolution
{
	static String[] l;
//	static HashMap<Integer, String> cl;

	static public void init()
	//전역 변수들, 전역 필드들 다 초기화 해주는 코드
	//TC마다 한번씩 수행됨. 
	{
		// 대체 뭘 초기화해줘야 하는거지..? 
		l = new String[1000001]; // 1000000 가 아니라 1000001 이어야 함. 
//		cl = new HashMap<>();
	}
	
	public void add(int id, String name)
	{
		if(l[id] == null) l[id] = name;
//		if(cl.get(id) == null) cl.put(id, name);
	}

	String find(int id) 
    {
		if (l[id] != null) {
			return l[id];
		}
			return null;
//		return cl.get(id);
	}
}