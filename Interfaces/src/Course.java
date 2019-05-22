/* John Dunne (jd5an) Homework 4, Big Java, Class Powerpoints */
public class Course implements Playable, Comparable<Course> {

	private String artist;
	private String title;
	private int minutes;
	private int seconds;



	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	/** These three constructors with different initialization fields */
	public Course(String artist, String title) {
		this.artist = artist;
		this.title = title;
	}
	public Course(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	public Course(Course s) {
		artist = s.getArtist();
		title = s.getTitle();
		minutes = s.getMinutes();
		seconds = s.getSeconds();
	}
	/** The equals() method for the Songs class, returns true only if all the Songs fields are equal to one another */
	public boolean equals(Object o) {
		if(o instanceof Course) {
			Course s2 = (Course) o;
			return (this.getArtist().equals(s2.getArtist()) && this.getTitle().equals(s2.getTitle()) && this.getMinutes() == s2.getMinutes() && this.getSeconds() == s2.getSeconds());
		}
		else {
			return false;
		}
		
	}

	/**The toString method for the Songs class as described on the assignment page */
	@Override
	public String toString() {
		return "{Song: title = " + title + " artist = " + artist + "}";
	}
	/**The play method for the Songs class as described on the assignment page */
	@Override
	public void play() {
		System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);

	}
	/** The compareTo method implemented by the Comparable interface, used to help sort Songs based upon title and artist */
	public int compareTo(Course s) {
		if(artist.compareTo(s.getArtist()) < 0) {
			return -1;
		}
		else if(artist.compareTo(s.getArtist()) > 0) {
			return 1;
		}
		else if(artist.compareTo(s.getArtist()) == 0) {
			if(title.compareTo(s.getTitle()) < 0) {
				return -1;
			}
			else if(title.compareTo(s.getTitle()) > 0) {
				return 1;
			}
		}
		return 0;
	}
	/** Returns title of the particular song */
	@Override
	public String getName() {
		return this.getTitle();
	}
	/** This takes the time in the song, converts the minutes to seconds, adds them to the seconds and returns the total time in seconds */
	@Override
	public int getPlayTimeSeconds() {
		int minutesinsong = this.getMinutes();
		int secondstomin = minutesinsong*60;
		return secondstomin + this.getSeconds();
	}

	@Override
	public int numberOfSongs() {
		return 1;
	}

}
