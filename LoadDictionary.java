import java.util.*;
import java.io.*;

public class LoadDictionary{
	
	public static ArrayList<Word> load (String fileName){

		BufferedReader dictionary = null;
		ArrayList<Word> word_dic = new ArrayList<Word>();

		try {
			dictionary = new BufferedReader(new FileReader(fileName));
			String word = dictionary.readLine();
			while (word != null) {
				Word w = new Word(word);
				word_dic.add(w);
				word = dictionary.readLine();
			}
		} catch (IOException e ) {
				e.printStackTrace();
		} finally {
			if (dictionary != null){
				try {
					dictionary.close();
				} catch (IOException e){
				}
			}
		}
		return word_dic;
	}
	public static ArrayList<Word> getDic(String fileName) {
		return load(fileName);
	}
}

