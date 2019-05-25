import java.util.*;
public class WinHazWordz {

	String key;
	ArrayList <String> simpleDic;
	ArrayList <String> sortedDic;
	String ret = "";
	char[] onePoint = {'a','b','d','e','g','i','n','o','r','s','t','y','u'};
	char[] twoPoint = {'c','f','h','l','m','p','v','w','y'};
	char[] threePoint = {'j','k','Q','X','Z'};
	ArrayList <Character> oneP = new ArrayList <>();
	ArrayList <Character> twoP = new ArrayList <>();
	ArrayList <Character> threeP = new ArrayList <>();
	ArrayList <Character> array_key;
	//ArrayList <Character> array_s = new ArrayList<>();
	int highP;

	public WinHazWordz (String key, ArrayList<String> simpleDic, ArrayList<String> sortedDic) {
		this.key = key;
		this.simpleDic = simpleDic;
		this.sortedDic = sortedDic;
		highP = 0;
	}

	public void insertData() {
		for (int i = 0; i < onePoint.length; ++i) { oneP.add(onePoint[i]); }
		for (int i = 0; i < twoPoint.length; ++i) { twoP.add(twoPoint[i]); }
		for (int i = 0; i < threePoint.length; ++i) {threeP.add(threePoint[i]); }
		//for (int i = 0; i < key.length(); ++i) {arrayKey.add(key.charAt(i)); }
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
	/*
	public int search (String s) {
		System.out.println("key:"+key);
		System.out.println("s:"+s);

		for (int i = 0; i < key.length(); ++i) {arrayKey.add(key.charAt(i)); }
		int n = key.length();
		int m = s.length();
		int[] char_key = new int[n];
		int[] char_s = new int[m];
		int[][] dp = new int[n+1][m+1];
		int[][] dpP = new int[n+1][m+1];

		for (int i = 0; i < n; ++i) { char_key[i] = key.charAt(i);}
		for (int i = 0; i < m; ++i) { char_s[i] = s.charAt(i);}
		//Arrays.fill (dp, 0);
		//Arrays.fill (dpP,0);
		for (int i = 0; i <= n; ++i ){
			for (int j = 0; j <= m; ++j ){
				dp[i][j] = 0;
				dpP[i][j] = 0;
			}
		}
		int highP = 0;

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j) {
				if (!arrayKey.contains((char)char_s[j])) {
				 return -1;
				} else {
					int index = arrayKey.indexOf((char)char_s[j]);
					arrayKey.remove(index);
				}
				if (char_key[i] == char_s[j]) {
					System.out.println("TEST");
					dp[i+1][j+1] = dp[i][j]+1;
						if (oneP.contains(char_key[i])) dpP[i+1][j+1] = dpP[i][j]+1;
						else if (twoP.contains(char_key[i])) dpP[i+1][j+1] = dpP[i][j]+2;
						else if (threeP.contains(char_key[i])) dpP[i+1][j+1] = dpP[i][j]+3;
				} else {
					//System.out.println("TEST2");
					if (dp[i][j+1] > dp[i+1][j]){
						dp[i+1][j+1] = dp[i][j+1];
						dpP[i+1][j+1] = dpP[i][j+1];
					} else {
						dp[i+1][j+1] = dp[i+1][j];
						dpP[i+1][j+1] = dpP[i+1][j];
					}
					//dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
				System.out.println(dp[i+1][j+1]);

			}
		}
		return dpP[n][m];
	}*/

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