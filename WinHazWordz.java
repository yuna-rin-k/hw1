import java.util.*;
public class WinHazWordz {

	String key;
	ArrayList <String> simpleDic;
	ArrayList<int[]>   arrayDic;
	String ret = "";
	 		//  a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
	int[] p = {	1, 1, 2, 1, 1, 2, 1, 2, 1, 3, 3, 2, 2, 1, 1, 2, 3, 1, 1, 1, 1, 2, 2, 3, 2, 3 };
	int[] key_word_count;
	int highP;

	public WinHazWordz (String key, ArrayList<String> simpleDic, ArrayList<int[]> arrayDic) {
		this.key = key;
		this.simpleDic = simpleDic;
		this.arrayDic  = arrayDic;
		key_word_count = new int[(int)'z'+1];
		highP = 0;

		for (int i = 0; i < key.length(); ++i) {
			char c = key.charAt(i);
			++key_word_count[(int)c];
		}
	}

	public int search (String s, int[] s_word_count) {
		int points = 0;
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (s_word_count[(int)c] > key_word_count[(int)c]) return -1;
			points += p[(int)c - 'a'];
		}
		return points;
	}

	public String runSearch () {
		String highPStr = "";
		for (int i = 0; i < arrayDic.size(); ++i) {
			String s = simpleDic.get(i);
			int point = search (s, arrayDic.get(i));
			if (point > highP) {
				highP = point;
				highPStr = s;
			}
		}
		return highPStr;
	}
	
	/*
	String key;
	ArrayList <String> simpleDic;
	ArrayList <String> sortedDic;
	String ret = "";
	 		//  a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
	int[] p = {	1, 1, 2, 1, 1, 2, 1, 2, 1, 3, 3, 2, 2, 1, 1, 2, 3, 1, 1, 1, 1, 2, 2, 3, 2, 3 };
	ArrayList<Character> array_key;
	int highP;

	public WinHazWordz (String key, ArrayList<String> simpleDic) {
		this.key = key;
		this.simpleDic = simpleDic;
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
		for (int i = 0; i < simpleDic.size(); ++i) {
			int point = search (simpleDic.get(i));
			if (point > highP) {
				highP = point;
				highPStr = simpleDic.get(i);
			}
		}
		return highPStr;
	}
	/*
	//与えられた文字がすべて入っている単語をつくるプログラム↓
	
	public String search () {
		int index = sortedDic.indexOf(key);
		if (index > -1) return simpleDic.get(index);
		else return "PASS";
	}*/
	
}
