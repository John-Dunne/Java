import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Summary extends JFrame {
	public void supertable() {
		String[] columnheaders = {"Course Name", "Credit Hours", "Grade", "Add/Remove Course"};
		
		Object[][] data = {{"Econ 101", "3", "B", ""}};
		data.
		final JTable table = new JTable(data, columnheaders);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}
	private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

	
	private static void createGUI() {
		JFrame frame = new JFrame("Course Sheet");
		frame.setLayout(new GridLayout(2,1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		Summary newContentPane = new Summary();
		//newContentPane.setOpacity(arg0);
		frame.setContentPane(newContentPane);
		//The top can be used for the Jtable and the bottom can be used for the calculator by adding another grid to the bottom for buttons
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
	
}}
