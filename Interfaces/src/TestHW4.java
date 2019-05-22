import static org.junit.Assert.*;

import org.junit.Test;

public class TestHW4 {

	@Test
	public void testEqualsObject() {
		Course s1 = new Course("Madonna", "Vogue", 1, 30);
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);

		assertTrue(s1.equals(s2));
		assertFalse(s1.equals(s3));

	}

	@Test
	public void testToStringSong() {
		Course s1 = new Course("Madonna", "Vogue", 1, 30);
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);

		assertEquals(s1.toString(), "{Song: title = Vogue artist = Madonna}");
		assertEquals(s3.toString(), "{Song: title = Soul to Squeeze artist = Red Hot Chili Peppers}");

	}



	@Test
	public void testCompareToSong() {
		Course s1 = new Course("Madonna", "Vogue", 1, 30);
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);
		Course s4 = new Course("Red Hot Chili Peppers", "Tear", 4, 35);
		
		assertEquals(s3.compareTo(s1), 1);
		assertEquals(s2.compareTo(s2), 0);
		assertEquals(s2.compareTo(s3), -1);
		assertEquals(s3.compareTo(s4), -1);
		assertEquals(s4.compareTo(s3), 1);

	}

	@Test
	public void testGetNameSong() {
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);

		assertEquals(s2.getName(),"Vogue");
		assertEquals(s3.getName(),"Soul to Squeeze");

	}

	@Test
	public void testGetPlayTimeSecondsSong() {
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);

		assertEquals(s2.getPlayTimeSeconds(), 90);
		assertEquals(s3.getPlayTimeSeconds(), 285);
	}

	@Test
	public void testNumberOfSongsSong() {
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);

		assertEquals(s2.numberOfSongs(), 1);
		assertEquals(s3.numberOfSongs(), 1);

	}
	//All the tests above are for the Song Class methods
	//Every test below is for the PlayList methods
	@Test
	public void testToStringPlayList() {
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		//ArrayList<PlayList> subplaylist = new ArrayList<PlayList>();
		PlayList subplaylist = new PlayList("subplaylist");
		PlayList testplaylist = new PlayList("testplaylist");
		testplaylist.addSong(s2);
		assertEquals(testplaylist.toString(), "testplaylist\n" + "{Song: title = Vogue artist = Madonna}\n");
		testplaylist.addPlayList(subplaylist);
		//System.out.println(testplaylist.toString());
		assertEquals(testplaylist.toString(), "testplaylist\n" + "{Song: title = Vogue artist = Madonna}\n"+"subplaylist\n\n");
	}

	@Test
	public void testLoadSongsPlayList() {
		PlayList testplaylist = new PlayList("testplaylist");

		assertTrue(testplaylist.loadSongs("Song2txt"));
		testplaylist.loadSongs("Songs1txt");
		assertFalse(testplaylist.loadSongs("Songs1txt"));
	}

	@Test
	public void testClearPlayList() {
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		PlayList testplaylist = new PlayList("testplaylist");
		testplaylist.addSong(s2);
		assertTrue(testplaylist.clear());
		testplaylist.clear();
		assertFalse(testplaylist.clear());
	}

	@Test
	public void testAddSongPlayList() {
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);
		PlayList testplaylist = new PlayList("testplaylist");
		assertTrue(testplaylist.addSong(s2));
		assertTrue(testplaylist.addSong(s3));

	}

	@Test
	public void testRemovePlayableIntPlayList() {
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);
		PlayList testplaylist = new PlayList("testplaylist");
		testplaylist.addSong(s3);

		assertEquals(testplaylist.removePlayable(0), s3);
		assertEquals(testplaylist.removePlayable(1), null);

	}

	@Test
	public void testRemovePlayablePlayablePlayList() {
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		PlayList testplaylist = new PlayList("testplaylist");
		testplaylist.addSong(s3);
		testplaylist.addSong(s3);

		assertEquals(testplaylist.removePlayable(s3), s3);
		assertEquals(testplaylist.removePlayable(s2), null);

	}

	@Test
	public void testGetPlayablePlayList() {
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		PlayList testplaylist = new PlayList("testplaylist");
		testplaylist.addSong(s3);
		testplaylist.addSong(s2);

		assertEquals(testplaylist.getPlayable(0), s3);
		assertEquals(testplaylist.removePlayable(2), null);
	}

	@Test
	public void testAddPlayList() {
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		Course s4 = new Course("Macklemore", "Glorious", 3, 27);
		Course s5 = new Course("Blink-182", "Adam's Room", 4, 53);
		PlayList testplaylist = new PlayList("testplaylist");
		PlayList subplaylist = new PlayList("subplaylist");
		testplaylist.addSong(s3);
		testplaylist.addSong(s2);
		subplaylist.addSong(s4);
		subplaylist.addSong(s5);

		assertTrue(testplaylist.addPlayList(subplaylist));
		testplaylist.addPlayList(subplaylist);
		assertFalse(testplaylist.addPlayList(subplaylist));

	}

	@Test
	public void testSortByNamePlayList() {
		Course s2 = new Course("b", "Vogue", 1, 30);
		Course s3 = new Course("c", "Glorious", 3, 30);
		PlayList testplaylist = new PlayList("testplaylist");
		PlayList betalist = new PlayList("B");
		testplaylist.addSong(s2);
		testplaylist.addSong(s3);
		testplaylist.addPlayList(betalist);

		assertTrue(testplaylist.sortByName());
		testplaylist.sortByName();
		assertFalse(testplaylist.sortByName());

	}

	@Test
	public void testSortByTimePlayList() {
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		Course s4 = new Course("Macklemore", "Glorious", 3, 27);
		PlayList testplaylist = new PlayList("testplaylist");
		PlayList betalist = new PlayList("B");
		testplaylist.addSong(s2);
		testplaylist.addSong(s4);
		betalist.addSong(s3);
		testplaylist.addPlayList(betalist);

		assertTrue(testplaylist.sortByTime());
		testplaylist.sortByTime();
		assertFalse(testplaylist.sortByTime());

	}

	@Test
	public void testGetNamePlayList() {
		PlayList testplaylist = new PlayList("testplaylist");
		PlayList subplaylist = new PlayList("subplaylist");

		assertEquals(testplaylist.getName(), "testplaylist");
		assertEquals(subplaylist.getName(), "subplaylist");
	}

	@Test
	public void testGetPlayTimeSecondsPlayList() {
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		Course s4 = new Course("Macklemore", "Glorious", 3, 27);
		Course s5 = new Course("Blink-182", "Adam's Room", 4, 53);
		PlayList testplaylist = new PlayList("testplaylist");
		PlayList subplaylist = new PlayList("subplaylist");
		testplaylist.addSong(s3);
		testplaylist.addSong(s2);
		subplaylist.addSong(s4);
		subplaylist.addSong(s5);

		assertEquals(testplaylist.getPlayTimeSeconds(), 375);
		testplaylist.addPlayList(subplaylist);
		assertEquals(testplaylist.getPlayTimeSeconds(), 875);
	}

	@Test
	public void testNumberOfSongsPlayList() {
		Course s3 = new Course("Red Hot Chili Peppers", "Soul to Squeeze", 4, 45);
		Course s2 = new Course("Madonna", "Vogue", 1, 30);
		Course s4 = new Course("Macklemore", "Glorious", 3, 27);
		Course s5 = new Course("Blink-182", "Adam's Room", 4, 53);
		PlayList testplaylist = new PlayList("testplaylist");
		PlayList subplaylist = new PlayList("subplaylist");
		testplaylist.addSong(s3);
		testplaylist.addSong(s2);
		subplaylist.addSong(s4);
		subplaylist.addSong(s5);

		assertEquals(testplaylist.numberOfSongs(), 2);
		testplaylist.addPlayList(subplaylist);
		assertEquals(testplaylist.numberOfSongs(), 4);

	}

}
