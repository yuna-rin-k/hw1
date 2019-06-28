import java.util.*;

public class Main{

	public static void main(String[] args) {
		
		ArrayList<Word> dictionary = LoadDictionary.getDic("dictionary.txt");

		int count = 1;
		while (count <= 10) {

			String str = doInput();
			Word key = new Word(str);
			String result = winHazWordz(dictionary, key);
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

	public static String winHazWordz (ArrayList<Word> dictionary, Word key) {

		int maxPoint = 0;
		String bestStr = "";
		for (int i = 0; i < dictionary.size(); ++i) {
			Word d = dictionary.get(i);
			if (key.contains(d) && d.getPoint() > maxPoint) {
				maxPoint = d.getPoint();
				bestStr = d.getOriginal();
			}
		}
		return bestStr;
	}
}