import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Panel_Noodle extends JPanel {
	
	MainTest parent;
	JFrame f;
	JTextField tf;
	JTextArea ta;
	JButton bnd1, bnd2, bnd3, bnd4, bnd5, bnd6, badd, bcan, bpay;
	
	public Panel_Noodle(MainTest mainTest) {
		parent = mainTest;
		setBackground(Color.yellow);

		f = new JFrame();
		tf = new JTextField();
		ta = new JTextArea();
		//메뉴 관련버튼 (이미지 경로)
		bnd1 = new JButton(new ImageIcon("src\\imgs\\1.PNG"));
		bnd2 = new JButton(new ImageIcon("src\\imgs\\2.PNG"));
		bnd3 = new JButton(new ImageIcon("src\\imgs\\3.PNG"));
		bnd4 = new JButton(new ImageIcon("src\\imgs\\4.PNG"));
		bnd5 = new JButton(new ImageIcon("src\\imgs\\5.PNG"));
		bnd6 = new JButton(new ImageIcon("src\\imgs\\6.PNG"));
		//주문 관련 버튼
		badd = new JButton("장바구니 담기");	
		bcan = new JButton("취소");	
		bpay = new JButton("결제");	

		addLayout();
		eventProc();

	} //Panel_Noodle()

	void addLayout() {
		setLayout(new BorderLayout());
		JPanel pWest = new JPanel();
		pWest.setLayout(new GridLayout(3, 2, 5, 5));
		pWest.setPreferredSize(new java.awt.Dimension(500, 500));
		pWest.add(bnd1);
		pWest.add(bnd2);
		pWest.add(bnd3);
		pWest.add(bnd4);
		pWest.add(bnd5);
		pWest.add(bnd6);

		add(pWest, BorderLayout.WEST);
		
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new GridLayout(1,2));
		pNorth.add(tf);
		add(pNorth, BorderLayout.NORTH);
		
		JPanel pEast = new JPanel();
		pEast.setLayout(new GridLayout(2,1));
		pEast.setPreferredSize(new java.awt.Dimension(380,0));
		pEast.add(ta);
		pEast.add(badd);
		add(pEast, BorderLayout.EAST);
		
		
		JPanel pSouth = new JPanel();
		
		pSouth.setLayout(new GridLayout(1,2));
		pSouth.setPreferredSize(new java.awt.Dimension(10, 50));
		pSouth.add(bcan);
		pSouth.add(bpay);
		add(pSouth, BorderLayout.SOUTH);

	} //addLayout()

	void eventProc() {
		bnd1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "너구리라면 : 3500원");
			}//actionPerformed
		});//addActionListener
		bnd2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "신라면 : 3500원");
			}//actionPerformed
		});//addActionListener
		bnd3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "오징어짬뽕 : 3500원");
			}//actionPerformed
		});//addActionListener
		bnd4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "튀김우동 : 3500원");
			}//actionPerformed
		});//addActionListener
		bnd5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "진라면 : 3500원");
			}//actionPerformed
		});//addActionListener
		bnd6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "짜파게티 : 3500원");
			}//actionPerformed
		});//addActionListener
	}//eventProc
}//Panel_Main