import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel_Food extends JPanel {

	MainTest parent;

	JButton bnd[] = new JButton[6]; // 주문 가능 수량
	JButton bcan, bpay;// 모두취소, 결제

	// panel_food
	public Panel_Food(MainTest mainTest) {
		parent = mainTest;
		parent.tf = new JTextField();
		parent.ta = new JTextArea();

		parent.tf.setPreferredSize(new Dimension(250, 200));

		// 메뉴 관련버튼 (이미지 경로)
		String[] img = { "src\\imgs\\f1.PNG", "src\\imgs\\f2.PNG", "src\\imgs\\f3.PNG", "src\\imgs\\f4.PNG",
				"src\\imgs\\f5.PNG", "src\\imgs\\f6.PNG" }; // img source
		String[] tooltip = { "떡볶이: 4500원", "라볶이: 4800원", "순대: 3000원", "오뎅탕: 2500원", "김밥: 2000원", "튀김: 2800원" };// mouse
																												// hovering
		for (int i = 0; i < img.length; i++) {
			bnd[i] = new JButton(new ImageIcon(img[i]));// 버튼 이미지
			bnd[i].setToolTipText(tooltip[i]);// 툴팁 마우스 올려놨을때
			bnd[i].setBackground(new Color(255, 255, 255));// 버튼 흰색
		}

		// 주문 관련 버튼
		bcan = new JButton("모두 취소");
		bpay = new JButton("결제");
		parent.addbt = new JButton("장바구니 추가");
		parent.addbt2 = new JButton("장바구니 취소");
		parent.sosbt = new JButton("직원호출");
		addLayout();
		eventProc();

	} // Panel_Noodle()

	void addLayout() {

		setLayout(new BorderLayout());
		// ------------------------왼쪽패널에 메뉴버튼들 3x2
		JPanel pWest = new JPanel();
		pWest.setLayout(new GridLayout(3, 2, 10, 10));
		pWest.setLayout(new GridLayout(3, 2, 10, 10));
		pWest.setPreferredSize(new java.awt.Dimension(500, 600));
		for (JButton b : bnd)
			pWest.add(b);
		add(pWest, BorderLayout.WEST);

		// -------------------------------모두 취소, 결제버튼 맨아래
		JPanel pSouth = new JPanel();
		pSouth.setLayout(new GridLayout(1, 2));
		pSouth.setPreferredSize(new java.awt.Dimension(10, 50));
		pSouth.add(bcan);
		pSouth.add(bpay);
		add(pSouth, BorderLayout.SOUTH);

	} // addLayout()

	void eventProc() {
		// -----------------------------각각의 버튼이 눌렸을때 장바구니에 담기
		String[] a = { "떡볶이 3500", "라볶이 4000", "순대 3500", "오뎅 3000", "김밥 3500", "튀김 2500" };

		for (int i = 0; i < bnd.length; i++) {
			int su = i;
			bnd[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (parent.ta.getText().equals(""))
						parent.ta.append(a[su]);
					else
						parent.ta.setText(a[su]);

				}// actionPerformed
			});// addActionListener
		} // for
			// 장바구니 추가
		parent.addbt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inputData();
			}// actionPerformed
		});// addActionListenerAddbt
			// 장바구니 추가 취소
		parent.addbt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}// actionPerformed
		});// addActionListenerAddbt2
			// 결제
		bpay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "결제하시겠습니까?", "결제창", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					pay();
					parent.ta.setText(String.valueOf(parent.ta.getText().equals("")));
				} else {
					JOptionPane.showMessageDialog(null, "취소되었습니다.");
				}
			}// actionPerformed
		});// addActionListenerbpay
			// 모두 취소
		bcan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelAll();
			}// actionPerformed
		});// addActionListenerbcan
			// 직원호출 버튼
		parent.sosbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = parent.tf.getText();
				JOptionPane.showMessageDialog(null, "용무 " + s + "로 종업원 호출하였습니다. 기다리세요.");
				parent.tf.setText("");
			}// actionPerformed
		});// addActionListenersosbt
	}// eventProc
		// inputs into taJang

	// addbt (장바구니에 ta에 있는 값 담기)
	void inputData() {
		String a = parent.ta.getText();
		String[] b = a.split(" ");
		EdibleVo v = new EdibleVo(b[0], Integer.valueOf(b[1]));
		parent.list.add(v);
		parent.ta.setText("");
		parent.taJang.append(v.toString());
	}// input dataa

	// deletes from taJang(장바구니)
	void deleteData() {
		String a = parent.ta.getText();
		if (a.equals("")) {
			JOptionPane.showMessageDialog(null, "취소할 주문이 없습니다.");
			return;
		} // if
		String[] b = a.split(" ");

		for (EdibleVo vo : parent.list)
			if (b[0].equals(vo.getName())) {
				parent.list.remove(vo);
				break; // 꼭 필요함
			} // if
		parent.ta.setText("");
		parent.taJang.setText("");
		for (EdibleVo vo : parent.list)
			parent.taJang.append(vo.toString());
	}// deletedata

	// 결제창을 띄우고 다 지우기
	void pay() {
		int total = 0;
		for (EdibleVo v : parent.list) {
			total += v.getCost();
		} // for
		JOptionPane.showMessageDialog(null, "내실 총 금액은 " + total + " 원입니다.");
		cancelAll();
	}// pay

	// 모든 정보 지우기
	void cancelAll() {
		parent.taJang.setText("");
		parent.ta.setText("");
		parent.list = new ArrayList<EdibleVo>();
	}
}// panel_drink
