import java.util.*;
public class WinHazWordz {

	ArrayList <String> simpleDic;
	ArrayList<int[]>   arrayDic;
	String ret = "";
	 		//  a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
	int[] p = {	1, 1, 2, 1, 1, 2, 1, 2, 1, 3, 3, 2, 2, 1, 1, 2, 3, 1, 1, 1, 1, 2, 2, 3, 2, 3 };
	int[] key;
	int highP;

	public WinHazWordz (int[] key, ArrayList<String> simpleDic, ArrayList<int[]> arrayDic) {
		this.key = key;
		this.simpleDic = simpleDic;
		this.arrayDic  = arrayDic;
		highP = 0;
	}

	public int search (String s, int[] s_word_count) {
		int points = 0;
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (s_word_count[(int)c-'a'] > key[(int)c-'a']) return -1;
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
}
