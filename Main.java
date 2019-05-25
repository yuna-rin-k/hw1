import java.util.*;
public class Main{
	public static void main(String[] args) {

		LoadDictionary dic = new LoadDictionary ("dictionary.txt");
		dic.load();
		ArrayList<String> simpleDic = dic.getSimpleDic();
		ArrayList<String> sortedDic = dic.getSortedDic();
		System.out.println(sortedDic.get(0));

		int count = 0;
		while (count < 10) {
			String key = doInput();
			WinHazWordz win = new WinHazWordz(key, simpleDic, sortedDic);
			win.insertData();
			String result = win.runSearch();
			if (result != "")System.out.println("FIND: "+result);
			else System.out.println(result);
			++count;
		}

	}
	public static String doInput(){

		Scanner sc = new Scanner(System.in);
		String s = ""; 
		String sortedStr = "";
		char[] c;
		s = sc.next();
		c = new char[s.length()];
		for (int i = 0 ; i < s.length(); ++i) {
			c[i] = s.charAt(i);
		}
		Arrays.sort(c);
		for (int i = 0 ; i < s.length(); ++i) {
			sortedStr += c[i];
		}
		return sortedStr;
	}
}