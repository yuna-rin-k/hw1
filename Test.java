import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
	}

	public double makeWordByLackStr(Word lackWord, int numOflack) {
			//lackStr から word がつくれるか
			String lackStr = lackWord.getOriginal();
			double probability = 0;

			for (int i = 0; i < lackStr.length(); i++) {

				if (numOflack < 0) 
					return -1;

				char c = lackStr.charAt(i);
				if (lackWord.countsOfChar(c) < this.countsOfChar(c)) {
					
					numOflack -= (this.countsOfChar(c) - lackWord.countsOfChar(c));
					if (p[indexOf(c)] == 1) probability += 12/26;
					else if (p[indexOf(c)] == 2) probability += 9/26;
					else if (p[indexOf(c)] == 3) probability += 5/26;
				}
			}
			return probability;
		}

}