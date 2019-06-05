import java.util.*;

public class Main{

	static LoadDictionary dic;
	static ArrayList<Word> dictionary;
	public static void main(String[] args) {

		dic = new LoadDictionary ("dictionary.txt");
		dic.load();
		dictionary = dic.getDic();

		int count = 1;
		while (count <= 10) {

			String str = doInput();
			Word key = new Word(str);
			String result = winHazWordz(key);
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

	public static String winHazWordz (Word key) {

		int maxPoint = 0;
		String bestStr = "";
		for (int i = 0; i < dictionary.size(); ++i) {
			if (key.contains(dictionary.get(i)) && dictionary.get(i).getPoint() > maxPoint) {
				maxPoint = dictionary.get(i).getPoint();
				bestStr = dictionary.get(i).getOriginal();
			}
		}
		return bestStr;
	}
}