import java.util.*;
import java.io.*;

public class LoadDictionary{

	String textName;
	BufferedReader dictionary = null;
	String word;
	ArrayList<Word> word_dic;

	public LoadDictionary (String textName) {
		this.textName = textName;
		word_dic = new ArrayList<Word>();
	}
	public void load (){

		try {
			dictionary = new BufferedReader(new FileReader(textName));
			word = dictionary.readLine();
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
	}
	public ArrayList<Word> getDic() {return word_dic; }
}

