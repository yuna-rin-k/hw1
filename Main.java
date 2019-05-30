import java.util.*;

public class Main{
	public static void main(String[] args) {

		LoadDictionary dic = new LoadDictionary ("dictionary.txt");
		dic.load();
		ArrayList<String> simpleDic = dic.getSimpleDic();
		ArrayList<int[]> arrayDic = dic.getArrayDic();

		int count = 1;
		while (count <= 10) {

			String str = doInput();
			int[] key = LoadDictionary.changeToArray(str);
			WinHazWordz win = new WinHazWordz(key, simpleDic, arrayDic);
			String result = win.runSearch();
			if (result != "")System.out.println(count+". Find: "+result);
			else System.out.println("PASS");
			++count;
		}
	}
	public static String doInput(){

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		return s;
	}
}