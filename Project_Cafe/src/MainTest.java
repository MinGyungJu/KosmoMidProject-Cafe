import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainTest extends JFrame{
	Panel_Main panel_main; 
	Panel_Noodle panel_noodle;
	Panel_Food panel_food;
	Panel_Snack panel_snack;
	Panel_Drink panel_drink;
	
	MainTest(){
		setTitle("PC방");
		
		
	}
	
	void addLayout() {
		

		JTabbedPane tab = new JTabbedPane();
		tab.addTab("main", panel_main);
		
		tab.addTab("라면", panel_noodle);
		tab.addTab("분식", panel_food);
		tab.addTab("간식", panel_snack);
		tab.addTab("음료", panel_drink);
	
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
