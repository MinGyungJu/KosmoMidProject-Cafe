import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel_Snack extends JPanel{
	
	MainTest parent;
	
	JButton b1 = new JButton("죠리뽕", new ImageIcon("src\\imgs\\1.png"));
	JButton b2 = new JButton("칸츄리콘", new ImageIcon("src\\imgs\\2.jpg"));
	JButton b3 = new JButton("치토스", new ImageIcon("src\\imgs\\3.jpg"));
	JButton b4 = new JButton("썬칩", new ImageIcon("src\\imgs\\4.jpg"));
	JButton b5 = new JButton("썬칩", new ImageIcon("src\\imgs\\5.jpg"));
	JButton b6 = new JButton("허니버터칩", new ImageIcon("src\\imgs\\6.jpg"));
	JButton addbt = new JButton("장바구니담기");
	JButton delbt= new JButton("취소");
	JButton calbt = new JButton("결제");
	
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
			pWest.setLayout(new GridLayout(3,2,10,10));
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
			pSouth.add(calbt);
			pSouth.add(delbt);
			
			add(pSouth, BorderLayout.SOUTH);
		
			b1.setHorizontalAlignment(JButton.CENTER);
			b1.setVerticalTextPosition(JButton.BOTTOM);
			b2.setHorizontalAlignment(JButton.CENTER);
			b2.setVerticalTextPosition(JButton.BOTTOM);
			b3.setHorizontalAlignment(JButton.CENTER);
			b3.setVerticalTextPosition(JButton.BOTTOM);
			b4.setHorizontalAlignment(JButton.CENTER);
			b4.setVerticalTextPosition(JButton.BOTTOM);
			b5.setHorizontalAlignment(JButton.CENTER);
			b5.setVerticalTextPosition(JButton.BOTTOM);
			b6.setHorizontalAlignment(JButton.CENTER);
			b6.setVerticalTextPosition(JButton.BOTTOM);
			
		
		
		
	}
	void addProc() {
		
	}
}
