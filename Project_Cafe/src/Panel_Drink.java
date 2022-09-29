import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Panel_Drink extends JPanel {

	MainTest parent;
	JFrame f;
	JTextField tf;
	JTextArea ta,taJang;
	JButton bnd1, bnd2, bnd3, bnd4, bnd5, bnd6, bcan, bpay, addbt, sosbt;
	ArrayList<EdibleVo> list = new ArrayList<EdibleVo>();

	JLabel banner1 = new JLabel("요청 쓴후에 호출, 장바구니에는 하나씩만");
	JLabel banner2 = new JLabel();
	JLabel banner3 = new JLabel();
	JLabel banner4 = new JLabel();
	JLabel banner5 = new JLabel();

	public Panel_Drink(MainTest mainTest) {
		parent = mainTest;
//		setBackground(Color.yellow);

		f = new JFrame();
		tf = new JTextField();
		ta = new JTextArea();
		taJang = new JTextArea();
	
		tf.setPreferredSize(new Dimension(250,200));
		taJang.setPreferredSize(new Dimension(250,200));
		// 메뉴 관련버튼 (이미지 경로)
		bnd1 = new JButton("커피:3500원", new ImageIcon("src\\imgs\\1.PNG"));
		bnd2 = new JButton("녹차:3300원", new ImageIcon("src\\imgs\\2.PNG"));
		bnd3 = new JButton("홍차:2500", new ImageIcon("src\\imgs\\3.PNG"));
		bnd4 = new JButton("오렌지주스:3000", new ImageIcon("src\\imgs\\4.PNG"));
		bnd5 = new JButton("자몽에이드:3500", new ImageIcon("src\\imgs\\5.PNG"));
		bnd6 = new JButton("얼그레이:2500", new ImageIcon("src\\imgs\\6.PNG"));
		// 주문 관련 버튼
		bcan = new JButton("모두 취소");
		bpay = new JButton("결제");
		addbt = new JButton("장바구니 담기");
		sosbt = new JButton("직원호출");
		addLayout();
		eventProc();

	} // Panel_Noodle()

	void addLayout() {
//		BorderLayout layout = new BorderLayout();
//		setLayout(layout); 
//		remove(layout.getLayoutComponent(BorderLayout.CENTER));
		setLayout(new BorderLayout());

		JPanel pWest = new JPanel();
		pWest.setLayout(new GridLayout(3, 2, 10, 10));
		pWest.setPreferredSize(new java.awt.Dimension(500, 600));
		pWest.add(bnd1);
		pWest.add(bnd2);
		pWest.add(bnd3);
		pWest.add(bnd4);
		pWest.add(bnd5);
		pWest.add(bnd6);

		add(pWest, BorderLayout.WEST);

		JPanel pNorth = new JPanel();
		pNorth.setLayout(new GridLayout(1, 2));
		pNorth.add(tf);
		add(pNorth, BorderLayout.NORTH);
		// ----------------------------------------------
		JPanel pEast = new JPanel();

		pEast.setLayout(new GridLayout(2, 1));
		pEast.setPreferredSize(new java.awt.Dimension(300, 450));

		JPanel pEast1 = new JPanel();

		pEast1.add(tf); // 요청 사항 입력 후, 직원 호출을 눌러주세요
		pEast1.add(sosbt); // 직원 호출
		JPanel pEast2 = new JPanel();
		pEast2.add(banner1); // 이벤트 배너 삽입
		pEast2.add(ta); // 주문내역 출력
		pEast2.add(addbt); // 장바구니 담기
		pEast2.add(taJang); // 주문내역 출력
		pEast.add(pEast1);
		pEast.add(pEast2);

		add(pEast, BorderLayout.EAST);
		// ----------------------------------------------
		JPanel pSouth = new JPanel();

		pSouth.setLayout(new GridLayout(1, 2));
		pSouth.setPreferredSize(new java.awt.Dimension(10, 50));
		pSouth.add(bcan);
		pSouth.add(bpay);
		add(pSouth, BorderLayout.SOUTH);

	} // addLayout()

	void eventProc() {
		bnd1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("커피 3500");
			}// actionPerformed
		});// addActionListener
		bnd2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("녹차 3300");
			}// actionPerformed
		});// addActionListener
		bnd3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("홍차 2500");
			}// actionPerformed
		});// addActionListener
		bnd4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("오렌지주스 3000");
			}// actionPerformed
		});// addActionListener
		bnd5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("자몽에이드 3500");
			}// actionPerformed
		});// addActionListener
		bnd6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("얼그레이 2500");
			}// actionPerformed
		});// addActionListener
		addbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputData();
			}// actionPerformed
		});// addActionListenerAddbt
		bpay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pay();
			}// actionPerformed
		});// addActionListenerbpay
		bcan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelAll();
			}// actionPerformed
		});// addActionListenerbcan
		sosbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s= tf.getText();
				JOptionPane.showMessageDialog(null,"용무 "+ s +"로 종업원 호출하였습니다. 기다리세요.");
				tf.setText("");
			}// actionPerformed
		});// addActionListenersosbt
	}// eventProc
	void inputData() {
		String a = ta.getText();
		String[] b = a.split(" ");
		EdibleVo v = new EdibleVo(b[0],Integer.valueOf(b[1]));
		list.add(v);
		ta.setText("");
		taJang.append(v.toString());
	}//input dataa
	
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
		ta.setText("");
		list = new ArrayList<EdibleVo>();
	}
}// panel_drink
//////////////////////////////////////////////////////////////////////////
/*
 * JButton aBtn = new JButton("A button"); JTextArea ta = new JTextArea();
 * JButton[] bMenu = new JButton[6];
 * 
 * JButton addbt = new JButton("장바구니 담기"); JButton sosbt = new JButton("직원호출");
 * JButton delbt= new JButton("         취소 (alt+x)        "); JButton calbt =
 * new JButton("              결제              ");
 * 
 * JLabel banner1 = new JLabel(); JLabel banner2 = new JLabel(); JLabel banner3
 * = new JLabel(); JLabel banner4 = new JLabel(); JLabel banner5 = new JLabel();
 * 
 * 
 * setBackground(Color.CYAN); String a[] = { "커피", "녹차", "자몽에이드", "홍차", "홍차",
 * "홍차", "홍차" }; for (int i = 0; i < bMenu.length; i++) { bMenu[i] = new
 * JButton(a[i]); } // for addLayout(); addProc(); }// panel_drink
 * 
 * void addLayout() {
 * 
 * setLayout(new BorderLayout());
 * 
 * //오른쪽에 메뉴 보여주 JPanel pWest = new JPanel(); pWest.setLayout(new GridLayout(3,
 * 2)); pWest.setPreferredSize(new java.awt.Dimension(550, 500)); for (int i =
 * 0; i < bMenu.length; i++) { pWest.add(bMenu[i]); } // for
 * 
 * JPanel pCenter = new JPanel(); pCenter.add(ta); add(pWest,
 * BorderLayout.WEST); add(pCenter, BorderLayout.CENTER);
 * 
 * }// addLayout
 * 
 * void addProc() {
 * 
 * }// addProc
 */
