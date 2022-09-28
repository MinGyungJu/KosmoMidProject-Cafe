import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class Panel_Drink extends JPanel {
	JButton aBtn = new JButton("A button");
	JTextArea ta = new JTextArea();
	JButton[] bMenu = new JButton[6];

	public Panel_Drink() {
		setBackground(Color.CYAN);
		String a[] = { "커피", "녹차", "자몽에이드", "홍차", "홍차", "홍차", "홍차" };
		for (int i = 0; i < bMenu.length; i++) {
			bMenu[i] = new JButton(a[i]);
		} // for
		addLayout();
		addProc();
	}// panel_drink

	void addLayout() {

		setLayout(new BorderLayout());

		//오른쪽에 메뉴 보여주
		JPanel pWest = new JPanel();
		pWest.setLayout(new GridLayout(3, 2));
		pWest.setPreferredSize(new java.awt.Dimension(550, 500));
		for (int i = 0; i < bMenu.length; i++) {
			pWest.add(bMenu[i]);
		} // for

		JPanel pCenter = new JPanel();
		pCenter.add(ta);
		add(pWest, BorderLayout.WEST);
		add(pCenter, BorderLayout.CENTER);

	}// addLayout

	void addProc() {

	}// addProc

}
