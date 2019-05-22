
public class insertionSortRunnable extends ConcurrenceGUIApp implements Runnable {
	private int[] arraylist;
	public insertionSortRunnable(int[] anArrayList)
	{
	   arraylist = anArrayList;
	}
	@Override
	public void run() {
		int n = arraylist.length;
        for (int i=1; i<n; ++i)
        {
            int current = arraylist[i];
            int j = i-1;
            while (j>=0 && arraylist[j] > current)
            {
                arraylist[j+1] = arraylist[j];
                j = j-1;
            }
            arraylist[j+1] = current;
        }
		
	}

}
