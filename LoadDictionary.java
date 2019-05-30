import java.util.*;
import java.io.*;

public class LoadDictionary{

	String textName;
	BufferedReader dictionary = null;
	String word;
	ArrayList<String> simpleDictionary = new ArrayList<>();
	ArrayList<int[]> arrayDictionary = new ArrayList<>();

	public LoadDictionary (String textName) {
		this.textName = textName;
	}
	public void load (){

		try {
			dictionary = new BufferedReader(new FileReader(textName));
			word = dictionary.readLine();
			while (word != null) {
				word = word.toLowerCase();
				simpleDictionary.add(word);
				int[] word_count = changeToArray(word);
				arrayDictionary.add(word_count);
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

	public static int[] changeToArray (String s) {
		//apple → a_z[0 ('a'-'a')]==1, a_z[15 ('p'-'a')]==2, ...
		int[] word_count = new int['z'-'a'+1];
		for (int i = 0; i < s.length(); ++i) {
			char a_z = s.charAt(i);
			++word_count[(int)a_z-'a'];
			if (a_z == 'q') ++i;	//qu → q
		}
		return word_count;
	}
	public ArrayList<String> getSimpleDic() {return simpleDictionary; }
	public ArrayList<int[]> getArrayDic()  {return arrayDictionary; }
}

