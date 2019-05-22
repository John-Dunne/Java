import java.util.Comparator;

public class SortByTime implements Comparator<Playable> {

	public int compare(Playable s1, Playable s2) {
		if(s1.getPlayTimeSeconds() > s2.getPlayTimeSeconds()) {
			return 1;
		}
		else if(s1.getPlayTimeSeconds() < s2.getPlayTimeSeconds()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}
