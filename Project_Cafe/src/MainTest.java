import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainTest extends JFrame{
	Panel_Main panel_Main; 
	Panel_Ade panel_Ade;
	Panel_Coffee panel_Coffee;
	Panel_Frappe panel_Frappe;
	Panel_Juice panel_Juice;
	Panel_Latte panel_Latte;
	Panel_Tea panel_Tea;
	
	MainTest(){
		setTitle("MidCafe");
		
		
	}
	
	void addLayout() {
		

		JTabbedPane tab = new JTabbedPane();
		tab.addTab("main", panel_Main);
		
		tab.addTab("Cofee", panel_Coffee);
		tab.addTab("Latte", panel_Latte);
		tab.addTab("Tea", panel_Tea);
		tab.addTab("Ade", panel_Ade);
		tab.addTab("Juice", panel_Juice);
		tab.addTab("Frappe", panel_Frappe);
		

		add(tab,BorderLayout.CENTER);
		
		setBounds(100, 100, 700, 900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void eventProc() {
		
	}
	public static void main(String[] args) {
		MainTest m = new MainTest();
		m.addLayout();
		m.eventProc();
		
	}

}
