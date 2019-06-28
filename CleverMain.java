//これはなし!

import java.util.*;

public class CleverMain {

	public static void main(String[] args) {

		ArrayList<Word> dictionary = LoadDictionary.getDic("dictionary.txt");
		Collections.sort(dictionary);
		System.out.println("load finished");

		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (count < 10) {

			String key = sc.next();
			String s = cleverWinHazWordz(dictionary, key);
			System.out.println("best word: "+s);

			count++;
		}
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

	static String cleverWinHazWordz(ArrayList<Word> dic, String key) {

		double expectedHighScore = 0;
		String bestWord = null;

		ArrayList<String> dividedStrs = new ArrayList<>();
		dividTwoStrs(dividedStrs, key, "", "", 0);

		for (int i = 0; i < dividedStrs.size(); i+=2) {
			String lackStr = dividedStrs.get(i);
			ArrayList<String> point_str = calcExpectedHighScore(dic, lackStr, 16-lackStr.length());

			if (point_str == null) 
				continue;

			String retStr = dividedStrs.get(i+1);
			Word retWord = new Word(retStr);
			double expectedScore1 = Double.parseDouble(point_str.get(0));
			String retBest = winHazWordz(dic, retWord);
			Word retBestWord = new Word(retBest);
			double expectedScore2 = retBestWord.getPoint();
			System.out.println(expectedScore1 + " "+ lackStr);
			//System.out.println(expectedScore2+" "+ retBest);

			if (expectedHighScore < expectedScore1 + expectedScore2) {
				expectedHighScore = expectedScore1 + expectedScore2;
				bestWord = retStr;
			}
		}

		/*
		for (int i = 0; i < dic.size(); i++) {

			String keyStr = dic.get(i).getOriginal();
			double expectedHighScore = 0;

			for (int j = 0; j < dividedStrs.size(); j++) {
				String lackStr = dividedStrs.get(j);
				double expectedScore = calcExpectedHighScore(dic, lackStr, 16-lackStr.length());
				if (expectedHighScore < expectedScore) expectedHighScore = expectedScore;	
			}

			if (highScore < expectedHighScore){
				highScore = expectedHighScore;
				bestWord = keyStr;
			}
		}*/

		return bestWord;

	}
	

	static void dividTwoStrs(ArrayList<String> dividedStrs, String str, String s1, String s2, int index) {

		if (index == str.length()){
			dividedStrs.add(s1);
			dividedStrs.add(s2);
			return;
		}

		dividTwoStrs(dividedStrs, str, s1+str.charAt(index), s2, index+1);
		dividTwoStrs(dividedStrs, str, s1, s2+str.charAt(index), index+1);
	}

	static ArrayList<String> calcExpectedHighScore(ArrayList<Word> dic, String lackStr, int numOfDisapperWords) {
		//System.out.println("calc");
		ArrayList<String> point_str = new ArrayList<>();
		Word lackWord = new Word(lackStr);
		for (int i = 0; i < dic.size(); i++) {

			Word dicWord = dic.get(i);
			//double expectValu = lackWord.makeWordByLackStr(dicWord, numOfDisapperWords) * lackWord.getPoint();
			//if (expectedHighScore < expectValu) 
				//expectedHighScore = expectValu;
			if (dicWord.makeWordByLackStr(lackWord, numOfDisapperWords) != -1) {
				point_str.add(String.valueOf(dicWord.makeWordByLackStr(lackWord, numOfDisapperWords) * dicWord.getPoint()));
				point_str.add(dicWord.getOriginal());
				return point_str;
			}
		}
		return null;
	}

}