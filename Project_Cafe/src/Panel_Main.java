import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel_Main extends JPanel {
	JButton[] bMenu = new JButton[4];
	MainTest parent;
	public ArrayList<EdibleVo> list = new ArrayList<EdibleVo>();

	public Panel_Main(MainTest mainTest) {
		parent = mainTest;
		setLayout(new GridLayout(2, 2));
		// making buttons
		String a[] = { "라면", "분식", "간식", "음료" };
		for (int i = 0; i < bMenu.length; i++) {
			bMenu[i] = new JButton(a[i]);
		} // for
		String[] b = { "src\\imgs\\m1.PNG", "src\\imgs\\m2.PNG", "src\\imgs\\m3.PNG", "src\\imgs\\m4.PNG" };
		for (int i = 0; i < b.length; i++) {
			bMenu[i] = new JButton(new ImageIcon(b[i]));
			bMenu[i].setBackground(new Color(255, 255, 255));
		}

		addLayout();
		eventProc();
	}// Panel_Main

	void addLayout() {
		for (int i = 0; i < bMenu.length; i++) {
			add(bMenu[i]);
		} // for
	}// addLayout

	void eventProc() {
		for (int i = 0; i < bMenu.length; i++) {
			int j = i;
			bMenu[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					parent.tab.setSelectedIndex(j + 1);
				}// actionPerformed
			});// addActionListener
		} // for
	}// eventProc
}// Panel_Main
