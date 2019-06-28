public class Word implements Comparable<Word> {

	private int[] charCounts;
	private String original;
			//  a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
	static int[] p = {	1, 1, 2, 1, 1, 2, 1, 2, 1, 3, 3, 2, 2, 1, 1, 2, 3, 1, 1, 1, 1, 2, 2, 3, 2, 3 };
	private int point;

	public Word (String s) {
		/*
		  任意のアルファベット列を小文字化し、charCountsにする
		  apple → charCounts[0 ('a'-'a')]==1, 
		          charConnts[1 ('b'-'a')]==0,
			      charCounts[15 ('p'-'a')]==2, ...
		*/
		original = s;
		s = s.toLowerCase();
		charCounts = new int['z'-'a'+1];
		for (int i = 0; i < s.length(); ++i) {
			char a_z = s.charAt(i);
			++charCounts[indexOf(a_z)];
			if (a_z == 'q') ++i;	//qu → q
		}

		this.point = calcPoint(s);
	}

	public int countsOfChar (char c) {
		//文字 c の個数を返す
		return charCounts[indexOf(c)];
	}

	public static int indexOf (char c) {
		//文字 c に対する配列内での index を返す
		return Character.toLowerCase(c) - 'a';
	}

	public boolean contains (Word word) {
		//this から word を作れる場合には true を返す
		String s = word.getOriginal();
		for (int i = 0; i < s.length(); ++i) {
			char c_w = s.charAt(i);
			if (word.countsOfChar(c_w) > this.countsOfChar(c_w)) return false;
		}
		return true;
	}

	public double makeWordByLackStr(Word lackWord, int numOflack) {
		//lackStr から word がつくれるか
		String lackStr = lackWord.getOriginal();
		double probability = 1;

		for (int i = 0; i < lackStr.length(); i++) {

			if (numOflack < 0) 
				return -1;

			if (probability <= 0) 
				return -1;

			char c = lackStr.charAt(i);
			if (lackWord.countsOfChar(c) < this.countsOfChar(c)) {
				numOflack -= (this.countsOfChar(c) - lackWord.countsOfChar(c));
				if (p[indexOf(c)] == 1) probability =- 0.461;
				else if (p[indexOf(c)] == 2) probability -= 0.346;
				else if (p[indexOf(c)] == 3) probability -= 0.192;
			}
		}
		return probability;
	}

	public int calcPoint(String originalStr) {

		int point = 0;
		int index;
		for (int i = 0; i < originalStr.length(); ++i) {
			index = indexOf(originalStr.charAt(i));
			point += p[index];
		}
		point = (point+1) * (point+1);

		return point;
	}

	public String getOriginal () {
		return original;
	}

	public int getPoint () {
		return this.point;
	}

	@Override
	public int compareTo(Word otherWord) {

		if (this.point > otherWord.getPoint()) {
			return -1;
		} else if (this.point < otherWord.getPoint()) {
			return 1;
		} else {
			return 0;
		}
	}
}