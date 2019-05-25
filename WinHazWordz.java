import java.util.*;
public class WinHazWordz {

	String key;
	ArrayList<String> simpleDic;
	ArrayList<String> sortedDic;

	public WinHazWordz (String key, ArrayList<String> simpleDic, ArrayList<String> sortedDic) {
		this.key = key;
		this.simpleDic = simpleDic;
		this.sortedDic = sortedDic;
	}

	public String search () {
		int index = sortedDic.indexOf(key);
		if (index > -1) return simpleDic.get(index);
		else return "PASS";
	}
}