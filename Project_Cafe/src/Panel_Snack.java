import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel_Snack extends JPanel{
	

	
	MainTest parent;
	
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	JButton b5 = new JButton();
	JButton b6 = new JButton();
	JButton addbt = new JButton();
	JButton delbt= new JButton();
	JButton calbt = new JButton();
	JTextArea ta1 = new JTextArea();
	JTextField tf1 = new JTextField();
	
	public Panel_Snack(MainTest i) {
		
		parent = i;
		
		addLayout();
		addProc();
		
		setBackground(Color.CYAN);		

		
	
		
	}
	
	void addLayout() {
		
		setLayout(new BorderLayout());
		JPanel pWest = new JPanel();
			pWest.setLayout(new GridLayout(3,2,20,20));
			pWest.setPreferredSize(new java.awt.Dimension(550, 500));
			pWest.add(b1);
			pWest.add(b2);
			pWest.add(b3);
			pWest.add(b4);
			pWest.add(b5);
			pWest.add(b6);
			
		add(pWest, BorderLayout.WEST);
		
		JPanel pEast = new JPanel();
			pEast.setLayout(new GridLayout(3, 1));
			pEast.setPreferredSize(new java.awt.Dimension(300,450));
			
			pEast.add(tf1);
			pEast.add(ta1);
			pEast.add(addbt);
			
			
			add(pEast, BorderLayout.EAST);
			
			JPanel pSouth = new JPanel();
			pSouth.add(delbt);
			pSouth.add(calbt);
			add(pSouth, BorderLayout.SOUTH);
		
		
		
		
		
	}
	void addProc() {
		
	}
}
