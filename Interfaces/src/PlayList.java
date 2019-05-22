/* John Dunne (jd5an) Homework 4, Big Java, Class Powerpoints */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class PlayList implements Playable, Comparable<PlayList>{

	private String name;
	private ArrayList<Playable> playableList;
	private boolean SortedByName;
	private boolean SortedByTime;

	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}

	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}

	public void setName(String name) {
		this.name = name;
	}

	/** Gives the playlist name on the first line and then each subsequent line lists the playable element within the playlist */
	@Override
	public String toString() {
		int playsize = playableList.size();
		String returnstring = name +"\n";
		int i = 0;
		for(i = 0; i < playsize; i++) {
			returnstring = returnstring+playableList.get(i)+"\n";
		}
		return returnstring;
	/** Two constructors below with different fields */
	}
	public PlayList() {
		playableList = new ArrayList<Playable>();
		name = "Untitled";
		SortedByName = false;
		SortedByTime = false;

	}
	public PlayList(String newName) {
		name = newName;
		SortedByName = false;
		SortedByTime = false;
		playableList = new ArrayList<Playable>();
		//Check to see if this is set up correctly
	}
	/** This method loads songs, first checking to see if the file is empty or not, if it is empty then it returns false and does not add anything to the playableList variable. */
	/** If the file is not empty then it goes three lines at a time, decoding and storing lines one and two in the title and artist variable of a new song, the third line uses a regex expression to parse and convert the minutes and seconds into int variables for the new song */
	/** The seconds over 60 are converted to minutes with the remainder operator and added to seconds, the quotient of the integer division is added to minutes. */
	public boolean loadSongs(String fileName) {
		String Songtitle = "";
		String Artist = "";
		int intminutes = 0;
		int intseconds = 0;

		try {
			Scanner inputFile = new Scanner(new File(fileName));
			File checkfile = new File(fileName);
			if(checkfile.length() == 0) {
				inputFile.close();
				return false;
			}

			while(inputFile.hasNextLine()){
				Artist = inputFile.nextLine().trim();
				Songtitle = inputFile.nextLine().trim();
				String minuteseconds = inputFile.nextLine().trim();
				String[] MvS = minuteseconds.split(":");
				String minutes = MvS[0];

				String seconds = MvS[1];
				intminutes = Integer.parseInt(minutes);
				intseconds = Integer.parseInt(seconds);

				if(intseconds >= 60) {
					int tobeaddedtominutes = intseconds/60;
					int leftoverseconds = intseconds%60;
					intminutes = intminutes+tobeaddedtominutes;
					intseconds = leftoverseconds;
				}
				Course currentloadsong = new Course(Songtitle, Artist, intminutes, intseconds);
				playableList.add(currentloadsong);
				if(inputFile.hasNextLine()) {
					inputFile.nextLine();
				}}
			inputFile.close();
			return true;

		} catch (IOException e) {
			return false;
		}
	}
	/** The playableList is checked to see if it is empty or not, if it is empty the method returns false, otherwise it clears the playableList and returns true */
	public boolean clear() {
		if(playableList.isEmpty()){
			return false;
		}else {
			playableList.clear();
			SortedByName = false;
			SortedByTime = false;
			return true;
		}
	}
	/** Adds the song to the playlist, the SortByTime and Name variables are used to help determine the true or false return value of the sortbyName and time methods later on */
	public boolean addSong(Course s) {
		playableList.add(s);
		SortedByName = false;
		SortedByTime = false;
		return true;
	}
	/** Checks to see if the index exists in the playableList, if it does it removes the playable element from the index */
	public Playable removePlayable(int index) {
		if(playableList.size()-1 < index || index < 0) {
			return null;
		}else {
			Playable atindex = playableList.get(index);
			playableList.remove(index);
			SortedByName = false;
			SortedByTime = false;
			return atindex;
		}
	}
	/** Checks to see if the playable element is in the playableList, if it isnt then the method returns false, else if it is then the method cycles through the list removing all instances of the playable item and returning it */
	public Playable removePlayable(Playable p) {
		int i = 0;
		boolean truthvalue = false;
		for(i = 0; i < playableList.size(); i++) {
			if(playableList.get(i).equals(p)) {
				playableList.remove(i);
				truthvalue = true;
				SortedByName = false;
				SortedByTime = false;
			}
		}
		if(truthvalue) {
			return p;
		}
		else {
			return null;
		}
	}
	/** Checks to see if the index exists in the playableList, returns null if it does not exist, otherwise it retrieves the playable element from the index */
	public Playable getPlayable(int index) {
		if(playableList.size()-1 < index || index < 0) {
			return null;
		}
		return playableList.get(index);
	}
	/** Checks to see if the to-be-added playlist is already within the playlist, if it is then the method returns false, otherwise the to-be-added playlist is added onto the end of the playableList */
	public boolean addPlayList(PlayList pl) {
		if(playableList.contains(pl)) {
			return false;
		}
		else {
			playableList.add(pl);
			SortedByName = false;
			SortedByTime = false;
			return true;
		}
	}
	/** Checks to see if the playableList is currently sortedbyname, if it is then it returns false, if it isnt then playableList is sorted by name via the comparator and comparable interface methods in the other classes */
	public boolean sortByName() {
		if(SortedByName) {
			return false;
		}
		else {
			playableList.sort(new SortByName());
			SortedByName = true;
			SortedByTime = false;
			return true;
		}


	}
	/** Checks to see if playableList is sortedbyTime, if it isnt it uses the getPlayTimeSeconds method in tandem with the comparator method to sort the playableList by times with shortest times being placed first */
	public boolean sortByTime() {
		if(SortedByTime) {
			return false;
		}else {
			SortedByName = false;
			SortedByTime = true;
			playableList.sort(new SortByTime());
			return true;
		}

	}
	/** Compares the lexographic value of the names of the playlists to one another to help order them in the comparator class */
	@Override
	public int compareTo(PlayList o) {
		if(name.compareTo(o.getName()) < 0) {
			return -1;
		}
		else if(name.compareTo(o.getName()) > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	/** Cycles through the playableList and calls the play() method on each playable element */
	public void play() {
		int i = 0;
		for(i = 0; i < playableList.size(); i++) {
			Playable Currentsong = playableList.get(i);
			Currentsong.play();
		}

	}
	/** Gets name of the playlist */
	@Override
	public String getName() {
		return this.name;
	}
	/** Gets the total time of the playlist by calling the getPlayTimeSeconds on each element within the playlist and totaling the seconds */
	@Override
	public int getPlayTimeSeconds() {
		int i = 0;
		int totalseconds = 0;
		for(i = 0; i < playableList.size(); i++) {
			Playable currentplayable = playableList.get(i);
			totalseconds = currentplayable.getPlayTimeSeconds() + totalseconds;
		}
		return totalseconds;
	}
	/** Returns the number of songs within the playableList */
	@Override
	public int numberOfSongs() {
		int totalnumberofsongs = 0;
		//check to see if this calls a playlist inside a playlist it acquires the proper index length
		//This might be an issue with several of the playable interface methods
		int i = 0;
		for(i = 0; i < playableList.size(); i++) {
			Playable currentplayable = playableList.get(i);
			totalnumberofsongs = currentplayable.numberOfSongs() + totalnumberofsongs;
		}
		return totalnumberofsongs;
	}
}
