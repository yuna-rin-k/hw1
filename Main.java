import java.util.*;

public class Main{
	public static void main(String[] args) {

		LoadDictionary dic = new LoadDictionary ("dictionary.txt");
		dic.load();
		ArrayList<String> simpleDic = dic.getSimpleDic();
		//ArrayList<String> sortedDic = dic.getSortedDic();
		ArrayList<int[]> arrayDic = dic.getArrayDic();

		int count = 1;
		while (count <= 10) {
			String key = doInput();
			//WinHazWordz win = new WinHazWordz(key, simpleDic);
			WinHazWordz win = new WinHazWordz(key, simpleDic, arrayDic);
			String result = win.runSearch();
			if (result != "")System.out.println(count+". FIND: "+result);
			else System.out.println("PASS");
			++count;
		}
	}
	public static String doInput(){

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] c = s.toCharArray();
		Arrays.sort(c);
		String sortedStr = String.valueOf(c);

		return sortedStr;
	}
}