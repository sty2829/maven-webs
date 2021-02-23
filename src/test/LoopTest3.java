package test;

class Result2{
	private String[] strs = {"경수", "상범", "소희", "동성"};
	private int idx = -1;
	
	public boolean next() {
		return (strs.length-1)>idx++;
	}
	public String getString() {
		return strs[idx];
	}
	
}

public class LoopTest3 {

	public static void main(String[] args) {
		Result2 rs =new Result2();
		while(rs.next()) {
			System.err.println(rs.getString());
		}
	}
}
