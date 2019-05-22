/* John Dunne (jd5an) Homework 4, Big Java, Class Powerpoints */
import java.util.Comparator;

public class SortByName implements Comparator<Playable> {

	@Override
	public int compare(Playable s1, Playable s2) {
		if(s1.getName().compareTo(s2.getName()) > 0) {
			return 1;
		}
		else if(s1.getName().compareTo(s2.getName()) < 0) {
			return -1;
		}
		else {
			return 0;
		}
	
}}
