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
	JTextField tf;// 직원호출
	JTextArea ta, taJang; // 장바구니 담기취소, 장바구니 컨텐트
	JButton bnd[] = new JButton[6]; // 주문 가능 수량
	JButton bcan, bpay, addbt, addbt2, sosbt;// 아래 써있는 버튼들
	// 모두취소, 결제, 장바구니 담기, 장바구니 취소, 직원호출
	ArrayList<EdibleVo> list = new ArrayList<EdibleVo>();// 주문가지고 있기

	JLabel banner1 = new JLabel("요청 쓴후에 호출, 장바구니에는 하나씩만");
	JLabel banner2 = new JLabel();
	JLabel banner3 = new JLabel();
	JLabel banner4 = new JLabel();
	JLabel banner5 = new JLabel();

	// panel_Drink
	public Panel_Drink(MainTest mainTest) {
		parent = mainTest;
		f = new JFrame();
		tf = new JTextField();
		ta = new JTextArea();
		taJang = new JTextArea();

		tf.setPreferredSize(new Dimension(250, 200));
		taJang.setPreferredSize(new Dimension(250, 200));

		// 메뉴 관련버튼 (이미지 경로)
		String[] img = { "src\\imgs\\d1.PNG", "src\\imgs\\d2.PNG", "src\\imgs\\d3.PNG", "src\\imgs\\d4.PNG",
				"src\\imgs\\d5.PNG", "src\\imgs\\d6.PNG" };
		String[] tooltip = { "커피: 3500원", "녹차: 3300원", "홍차: 2500원", "오렌지주스: 3000원", "자몽에이드: 3500원", "얼그레이: 2500원" };
		for (int i = 0; i < img.length; i++) {
			bnd[i] = new JButton(new ImageIcon(img[i]));
			bnd[i].setToolTipText(tooltip[i]);
		}

		// 주문 관련 버튼
		bcan = new JButton("모두 취소");
		bpay = new JButton("결제");
		addbt = new JButton("장바구니 추가");
		addbt2 = new JButton("장바구니 취소");
		sosbt = new JButton("직원호출");
		addLayout();
		eventProc();

	} // Panel_Noodle()

	void addLayout() {

		setLayout(new BorderLayout());
		// ------------------------왼쪽패널에 주문할 버튼들
		JPanel pWest = new JPanel();
		pWest.setLayout(new GridLayout(3, 2, 10, 10));
		pWest.setPreferredSize(new java.awt.Dimension(500, 600));
		for (JButton b : bnd)
			pWest.add(b);
		add(pWest, BorderLayout.WEST);

		// ----------------------------오른쪽패널에 직원호출 및 장바구니
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
		pEast2.add(addbt2); // 장바구니 취소
		pEast2.add(taJang); // 주문내역 출력
		pEast.add(pEast1);
		pEast.add(pEast2);
		add(pEast, BorderLayout.EAST);

		// -------------------------------모두 취소, 결제버튼
		JPanel pSouth = new JPanel();
		pSouth.setLayout(new GridLayout(1, 2));
		pSouth.setPreferredSize(new java.awt.Dimension(10, 50));
		pSouth.add(bcan);
		pSouth.add(bpay);
		add(pSouth, BorderLayout.SOUTH);

	} // addLayout()

	void eventProc() {
		//-----------------------------각각의 버튼이 눌렸을때 장바구니에 담기
		String[] a = { "커피 3500", "녹차 3300", "홍차 2500", 
				"오렌지주스 3000", "자몽에이드 3500", "얼그레이 2500" };
		for (int i = 0; i < bnd.length; i++) {
			int su = i;
			bnd[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (ta.getText().equals(""))
						ta.append(a[su]);
					else
						ta.setText(a[su]);

				}// actionPerformed
			});// addActionListener
		} // for
		//장바구니 추가
		addbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputData();
			}// actionPerformed
		});// addActionListenerAddbt
		//장바구니 추가 취소
		addbt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}// actionPerformed
		});// addActionListenerAddbt2
		//결제
		bpay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pay();
			}// actionPerformed
		});// addActionListenerbpay
		//모두 취소
		bcan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelAll();
			}// actionPerformed
		});// addActionListenerbcan
		//직원호출 버튼
		sosbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = tf.getText();
				JOptionPane.showMessageDialog(null, "용무 " + s + "로 종업원 호출하였습니다. 기다리세요.");
				tf.setText("");
			}// actionPerformed
		});// addActionListenersosbt
	}// eventProc
		// inputs into taJang
	
	//addbt (장바구니에 ta에 있는 값 담기)
	void inputData() {
		String a = ta.getText();
		String[] b = a.split(" ");
		EdibleVo v = new EdibleVo(b[0], Integer.valueOf(b[1]));
		list.add(v);
		ta.setText("");
		taJang.append(v.toString());
	}// input dataa

	// deletes from taJang(장바구니)
	void deleteData() {
		String a = ta.getText();
		if (a.equals("")) {
			JOptionPane.showMessageDialog(null, "취소할 주문이 없습니다.");
			return;
		} // if
		String[] b = a.split(" ");
		
		for (EdibleVo vo : list)
			if (b[0].equals(vo.getName())) {
				list.remove(vo);
				break; //꼭 필요함
			} // if
		ta.setText("");
		taJang.setText("");
		for (EdibleVo vo : list)
			taJang.append(vo.toString());
	}// deletedata

	// 결제창을 띄우고 다 지우기
	void pay() {
		int total = 0;
		for (EdibleVo v : list) {
			total += v.getCost();
		} // for
		JOptionPane.showMessageDialog(null, "내실 총 금액은 " + total + " 원입니다.");
		cancelAll();
	}// pay

	//모든 정보 지우기
	void cancelAll() {
		taJang.setText("");
		ta.setText("");
		list = new ArrayList<EdibleVo>();
	}
}// panel_drink
