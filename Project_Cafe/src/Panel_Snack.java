import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel_Snack extends JPanel{
	
	MainTest parent;
	
	JFrame f;
	JButton b[] = new JButton[6];
	JButton delbt,calbt,addbt,addbt2,sosbt;
	JTextArea ta1, taJang;
	JTextField tf1; 
	ArrayList<EdibleVo> list = new ArrayList<EdibleVo>();
	
	JLabel banner1 = new JLabel("요청 쓴후에 호출, 장바구니에는 하나씩만");
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
		
		
		// 메뉴 관련버튼 (이미지 경로)
		String []img = {"src\\imgs\\s1.PNG","src\\imgs\\s2.PNG","src\\imgs\\s3.PNG",
				"src\\imgs\\s4.PNG","src\\imgs\\s5.PNG","src\\imgs\\s6.PNG"};
		String[] tooltip = { "죠리뽕: 3000원", "칸츄리콘: 2500원", "치토스: 3000원", "썬칩: 3000원", "카스타드: 4000원", "허니버터칩: 3500원" };
		for(int i =0; i < img.length; i++) {
			b[i] = new JButton(new ImageIcon(img[i]));
			b[i].setToolTipText(tooltip[i]);
		}

		addbt = new JButton("장바구니 담기");
		addbt2 = new JButton("장바구니 취소");
		sosbt = new JButton("직원호출");
		delbt= new JButton("모두 취소");
		calbt = new JButton("결제");
		
		addLayout();
		addProc();
		
//		b1.setVerticalTextPosition(JButton.BOTTOM);
//		b1.setHorizontalAlignment(JButton.CENTER);
//		
//		b2.setHorizontalAlignment(JButton.CENTER);
//		b2.setVerticalTextPosition(JButton.BOTTOM);
//		b3.setHorizontalAlignment(JButton.CENTER);
//		b3.setVerticalTextPosition(JButton.BOTTOM);
//		b4.setHorizontalAlignment(JButton.CENTER);
//		b4.setVerticalTextPosition(JButton.BOTTOM);
//		b5.setHorizontalAlignment(JButton.CENTER);
//		b5.setVerticalTextPosition(JButton.BOTTOM);
//		b6.setHorizontalAlignment(JButton.CENTER);
//		b6.setVerticalTextPosition(JButton.BOTTOM);
		
		
		
//		setBackground(Color.CYAN);		

		
	}
	
	void addLayout() {
		
		setLayout(new BorderLayout());
		JPanel pWest = new JPanel();
		
			pWest.setLayout(new GridLayout(3,2,10,10));
			pWest.setPreferredSize(new java.awt.Dimension(500, 600));
			for(JButton b: b) pWest.add(b);
			
			
			
		add(pWest, BorderLayout.WEST);
		
		
		
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
			
			pEast2.add(addbt2); // 장바구니 담기
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

	
	}// addLayout()
	
	void addProc() {
		//-----------------------------각각의 버튼이 눌렸을때 장바구니에 담기
		String[] a = { "죠리뽕 3000", "칸츄리콘 2500", "치토스 2500", 
				"썬칩 3000", "카스타드 4000", "허니버터칩 3500" };
		for (int i = 0; i < b.length; i++) {
			int su = i;
			b[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (ta1.getText().equals(""))
						ta1.append(a[su]);
					else
						ta1.setText(a[su]);

				}// actionPerformed
			});// addActionListener
		} // for
		addbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputData();
			}// actionPerformed
		});// addActionListenerAddbt
		addbt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}// actionPerformed
		});// addActionListenerAddbt2
		calbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pay();
			}// actionPerformed
		});// addActionListenerbpay
		delbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelAll();
			}// actionPerformed
		});// addActionListenerbcan
		sosbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s= tf1.getText();
				JOptionPane.showMessageDialog(null,"용무 "+ s +"로 종업원 호출하였습니다. 기다리세요.");
				tf1.setText("");
			}// actionPerformed
		});// addActionListenersosbt
		
	}//eventProc
	void inputData() {
		String a = ta1.getText();
		String[] b = a.split(" ");
		EdibleVo v = new EdibleVo(b[0],Integer.valueOf(b[1]));
		list.add(v);
		ta1.setText("");
		taJang.append(v.toString());
	}//input data
	
	void deleteData() {
		String a = ta1.getText();
		if(a.equals("")) {
			JOptionPane.showMessageDialog(null, "취소할 주문이 없습니다.");
			return;
		}//if
		String[] b = a.split(" ");

		for (EdibleVo vo : list)
			if (b[0].equals(vo.getName())) {
				list.remove(vo);
				break;
			}//if

		ta1.setText("");
		taJang.setText("");
		for (EdibleVo vo : list)
			taJang.append(vo.toString());
	}
	
	void pay() {
		int total = 0;
		for(EdibleVo v : list) {
			total += v.getCost();
		}//for
		JOptionPane.showMessageDialog(null, "내실 총 금액은 "+ total+" 원입니다.");
		cancelAll();
	}//pay
	
	void cancelAll() {
		taJang.setText("");
		ta1.setText("");
		list = new ArrayList<EdibleVo>();
	}//cancelAll
}
