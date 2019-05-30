import java.util.*;
import java.io.*;

public class LoadDictionary{

	String textName;
	BufferedReader dictionary = null;
	String word;
	ArrayList<String> simpleDictionary = new ArrayList<>();
	//ArrayList<String> sortedDictionary = new ArrayList<>();
	ArrayList<int[]> arrayDictionary = new ArrayList<>();

	public LoadDictionary (String textName) {
		this.textName = textName;
	}
	public void load (){

		try {
			dictionary = new BufferedReader(new FileReader(textName));
			word = dictionary.readLine();
			//char[] sortedWord;
			//String sortedStr;

			while (word != null) {

				simpleDictionary.add(word);

				//apple → a_z['a']==1, a_z['p']==2, ...
				int[] c = new int[(int)'z'+1];
				for (int i = 0; i < word.length(); ++i) {
					char a_z = word.charAt(i);
					++c[(int)a_z];
					if (a_z == 'q') ++i; //uを登録しない
				}
				arrayDictionary.add(c);

				
				/*sortedWord = new char[word.length()];
				for (int i = 0; i < word.length(); ++i) {
					char c = word.charAt(i);
					c = Character.toLowerCase(c);
					sortedWord[i] = c;		
				}
				Arrays.sort(sortedWord);
				sortedStr = String.valueOf(sortedWord);
				sortedDictionary.add(sortedStr);*/
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
	//public ArrayList<String> getSortedDic() {return sortedDictionary; }	
	public ArrayList<String> getSimpleDic() {return simpleDictionary; }
	public ArrayList<int[]> getArrayDic()  {return arrayDictionary; }
}

