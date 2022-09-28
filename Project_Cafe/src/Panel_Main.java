import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel_Main extends JPanel{
	JButton [] bMenu = new JButton[4];

	public Panel_Main() {
		setLayout(new GridLayout());
		String a[] = { "라면", "분식", "간식", "음료" };
		for(int i =0; i <bMenu.length; i++) {
			bMenu[i] = new JButton(a[i]);
		}//for
		addLayout();
		eventProc();
	}//Panel_Main

	void addLayout() {
		for(int i =0; i <bMenu.length; i++) {
			add(bMenu[i]);
		}//for
	}//addLayout
	
	void eventProc() {
		
	}
}
