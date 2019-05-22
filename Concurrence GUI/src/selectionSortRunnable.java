
public class selectionSortRunnable extends ConcurrenceGUIApp implements Runnable {
private int[] arraylist;
public selectionSortRunnable(int[] anArrayList)
{
   arraylist = anArrayList;
   
}
	@Override
	public void run() {
		int n = arraylist.length;
        for (int i = 0; i < n-1; i++)
        {
            int minimum = i;
            for (int j = i+1; j < n; j++)
                if (arraylist[j] < arraylist[minimum])
                    minimum = j;
            int temporary = arraylist[minimum];
            arraylist[minimum] = arraylist[i];
            arraylist[i] = temporary;
        }
	}

}
