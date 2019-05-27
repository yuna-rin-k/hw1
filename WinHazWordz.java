import java.util.*;
public class WinHazWordz {

	String key;
	ArrayList <String> simpleDic;
	ArrayList <String> sortedDic;
	String ret = "";
	char[] onePoint = {'a','b','d','e','g','i','n','o','r','s','t','u'};
	char[] twoPoints = {'c','f','h','l','m','p','v','w','y'};
	char[] threePoints = {'j','k','Q','X','Z'};
	ArrayList <Character> oneP = new ArrayList <>();
	ArrayList <Character> twoP = new ArrayList <>();
	ArrayList <Character> threeP = new ArrayList <>();
	ArrayList <Character> array_key;
	int highP;

	public WinHazWordz (String key, ArrayList<String> simpleDic, ArrayList<String> sortedDic) {
		this.key = key;
		this.simpleDic = simpleDic;
		this.sortedDic = sortedDic;
		highP = 0;
	}

	public void insertData() {
		for (int i = 0; i < onePoint.length; ++i) { oneP.add(onePoint[i]); }
		for (int i = 0; i < twoPoints.length; ++i) { twoP.add(twoPoints[i]); }
		for (int i = 0; i < threePoints.length; ++i) {threeP.add(threePoints[i]); }
	}
	
	//keyでsを作れるか
	public int search (String s) {
		array_key = new ArrayList<>();
		int point = -1;
		for (int i = 0; i < key.length(); ++i) {array_key.add(key.charAt(i)); }
		for (int i = 0; i < s.length(); ++i) {
			if (!array_key.contains(s.charAt(i))){
				return -1;
			} else {
				int index = array_key.indexOf(s.charAt(i));
				array_key.remove(index);
			}
		}
		for (int i = 0; i < s.length(); ++i) {
			if (oneP.contains(s.charAt(i))) point += 1;
			if (twoP.contains(s.charAt(i))) point += 2;
			if (threeP.contains(s.charAt(i))) point += 3;
		}
		return point;
	}
	

	public String runSearch () {
		String highPStr = "";
		for (int i = 0; i < sortedDic.size(); ++i) {
			int point = search (sortedDic.get(i));
			if (point > highP) {
				highP = point;
				highPStr = simpleDic.get(i);
			}
		}
		return highPStr;
	}
	//与えられた文字がすべて入っている単語をつくるプログラム↓
	/*
	public String search () {
		int index = sortedDic.indexOf(key);
		if (index > -1) return simpleDic.get(index);
		else return "PASS";
	}
	*/
}