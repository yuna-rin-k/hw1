import java.util.*;
import java.io.*;

public class LoadDictionary{

	String textName;
	BufferedReader dictionary = null;
	String word;
	ArrayList<String> simpleDictionary = new ArrayList<>();
	ArrayList<String> sortedDictionary = new ArrayList<>();

	public LoadDictionary (String textName) {
		this.textName = textName;
	}
	public void load (){

		try {
			dictionary = new BufferedReader(new FileReader(textName));

				word = dictionary.readLine();
				char[] sortedWord;
				String sortedStr;

				while (word != null) {

					simpleDictionary.add(word);
					//sort
					sortedWord = new char[word.length()];
					sortedStr = "";
					for (int i = 0; i < word.length(); ++i) {
						char c = word.charAt(i);
						if ((int)c < 97) c += 32;
						sortedWord[i] = c;		
					}
					Arrays.sort(sortedWord);
					for (int i = 0; i < word.length(); ++i) {
						sortedStr += sortedWord[i];
					}
					sortedDictionary.add(sortedStr);
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
	}	
	public ArrayList<String> getSortedDic() {return sortedDictionary; }	
	public ArrayList<String> getSimpleDic() {return simpleDictionary; }
}

