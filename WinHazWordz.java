import java.util.*;
public class WinHazWordz {

	String key;
	ArrayList <String> simpleDic;
	ArrayList <String> sortedDic;
	String ret = "";
	int[] p = {	1, 1, 2, 1, 1, 2, 1, 	//a, b, c, d, e, f, g
			  	2, 1, 3, 3, 2, 2, 1,	//h, i, j, k ,l, m ,n
				1, 2, 3, 1, 1, 1, 1,	//o, p, q, r, s, t, u
				2, 2, 3, 2, 3 };		//v, w, x, y, z
	ArrayList<Character> array_key;
	int highP;

	public WinHazWordz (String key, ArrayList<String> simpleDic, ArrayList<String> sortedDic) {
		this.key = key;
		this.simpleDic = simpleDic;
		this.sortedDic = sortedDic;
		highP = 0;
	}

	//keyでsを作れるか
	public int search (String s) {
		array_key = new ArrayList<>();
		int points = -1;
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
			points += p[(int)s.charAt(i)-'a']; 
		}
		return points;
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