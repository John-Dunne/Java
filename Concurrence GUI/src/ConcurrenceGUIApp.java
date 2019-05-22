import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Panel;

public class ConcurrenceGUIApp {

	private JFrame frame;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConcurrenceGUIApp window = new ConcurrenceGUIApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConcurrenceGUIApp() {
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1234, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JPanel Bubblepanel = new JPanel();
		Bubblepanel.setBounds(15, 16, 1182, 129);
		frame.getContentPane().add(Bubblepanel);
		Bubblepanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
		
		
		
		
		JPanel Insertionpanel = new JPanel();
		Insertionpanel.setBounds(15, 169, 1182, 129);
		frame.getContentPane().add(Insertionpanel);
		
		JPanel Selectionpanel = new JPanel();
		Selectionpanel.setBounds(15, 325, 1182, 129);
		frame.getContentPane().add(Selectionpanel);
		
		JLabel lblBubbleSort = new JLabel("Bubble Sort");
		lblBubbleSort.setBounds(582, 147, 162, 20);
		frame.getContentPane().add(lblBubbleSort);
		
		JLabel lblInsertionSort = new JLabel("Insertion Sort");
		lblInsertionSort.setBounds(582, 299, 106, 20);
		frame.getContentPane().add(lblInsertionSort);
		
		JLabel lblSelectionSort = new JLabel("Selection Sort");
		lblSelectionSort.setBounds(582, 470, 106, 20);
		frame.getContentPane().add(lblSelectionSort);
	}
	
	
}
