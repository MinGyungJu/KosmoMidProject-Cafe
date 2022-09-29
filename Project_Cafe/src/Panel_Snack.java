import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel_Snack extends JPanel{
	
	MainTest parent;
	
	JFrame f;
	JButton b1,b2,b3,b4,b5,b6,addbt,sosbt,delbt,calbt;
	JTextArea ta1, taJang;
	JTextField tf1; 
	
	JLabel banner1 = new JLabel();
	JLabel banner2 = new JLabel();
	JLabel banner3 = new JLabel();
	JLabel banner4 = new JLabel();
	JLabel banner5 = new JLabel();
	
	
	
	
	
	public Panel_Snack(MainTest mainTest) {
		
		parent = mainTest;
		
		f = new JFrame();
		tf1 = new JTextField();
		ta1 = new JTextArea();
		taJang = new JTextArea();
		
		tf1.setPreferredSize(new Dimension(250,200));
		taJang.setPreferredSize(new Dimension(250,200));
		
		b1 = new JButton("죠리뽕", new ImageIcon("src\\imgs\\1.png"));
		b2 = new JButton("칸츄리콘", new ImageIcon("src\\imgs\\2.png"));
		b3 = new JButton("치토스", new ImageIcon("src\\imgs\\3.jpg"));
		b4 = new JButton("썬칩", new ImageIcon("src\\imgs\\4.jpg"));
		b5 = new JButton("썬칩", new ImageIcon("src\\imgs\\5.jpg"));
		b6 = new JButton("허니버터칩", new ImageIcon("src\\imgs\\6.jpg"));
		
		addbt = new JButton("장바구니담기");
		sosbt = new JButton("직원호출");
		delbt= new JButton("         취소 (alt+x)        ");
		calbt = new JButton("              결제              ");
		
		addLayout();
		addProc();
		
//		setBackground(Color.CYAN);		

		
	}
	
	void addLayout() {
		
		setLayout(new BorderLayout());
		JPanel pWest = new JPanel();
			pWest.setLayout(new GridLayout(3,2,10,10));
			pWest.setPreferredSize(new java.awt.Dimension(500, 600));
			pWest.add(b1);
			pWest.add(b2);
			pWest.add(b3);
			pWest.add(b4);
			pWest.add(b5);
			pWest.add(b6);
			
		add(pWest, BorderLayout.WEST);
		// ----------------------------------
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new GridLayout(1, 2));
		pNorth.add(tf1);
		add(pNorth, BorderLayout.NORTH);
		// ----------------------------------
		
		JPanel pEast = new JPanel();
			pEast.setLayout(new GridLayout(2, 1));
			pEast.setPreferredSize(new java.awt.Dimension(300,450));
			
			JPanel pEast1 = new JPanel();
			pEast1.add(tf1); // 요청 사항 입력 후, 직원 호출을 눌러주세요
			pEast1.add(sosbt); // 직원 호출
			JPanel pEast2 = new JPanel();
			pEast2.add(banner1); // 이벤트 배너 삽입
			pEast2.add(ta1); // 주문내역 출력
			pEast2.add(addbt); // 장바구니 담기
			pEast2.add(taJang); // 주문내역 출력
			pEast.add(pEast1);
			pEast.add(pEast2);

			add(pEast, BorderLayout.EAST);
			// ----------------------------------
			JPanel pSouth = new JPanel();
			pSouth.setLayout(new GridLayout(1, 2));
			pSouth.setPreferredSize(new java.awt.Dimension(10, 50));
			pSouth.add(delbt);
			pSouth.add(calbt);
			
			add(pSouth, BorderLayout.SOUTH);
		
//			b1.setHorizontalAlignment(JButton.CENTER);
//			b1.setVerticalTextPosition(JButton.BOTTOM);
//			b2.setHorizontalAlignment(JButton.CENTER);
//			b2.setVerticalTextPosition(JButton.BOTTOM);
//			b3.setHorizontalAlignment(JButton.CENTER);
//			b3.setVerticalTextPosition(JButton.BOTTOM);
//			b4.setHorizontalAlignment(JButton.CENTER);
//			b4.setVerticalTextPosition(JButton.BOTTOM);
//			b5.setHorizontalAlignment(JButton.CENTER);
//			b5.setVerticalTextPosition(JButton.BOTTOM);
//			b6.setHorizontalAlignment(JButton.CENTER);
//			b6.setVerticalTextPosition(JButton.BOTTOM);
			
	
	}// addLayout()
	
	void addProc() {
		
	}
}
