import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainTest extends JFrame{
	Panel_Main panel_main; 
	Panel_Noodle panel_noodle;
	Panel_Food panel_food;
	Panel_Snack panel_snack;
	Panel_Drink panel_drink;
	JTabbedPane tab = new JTabbedPane();

	MainTest(){
		setTitle("PC방");
		panel_main = new Panel_Main(this);
		panel_noodle = new Panel_Noodle(this);
		panel_food = new Panel_Food(this);
		panel_noodle = new Panel_Noodle(this);
		panel_food = new Panel_Food(this);
		panel_snack = new Panel_Snack(this);
		panel_drink = new Panel_Drink(this);
		
	}
	
	void addLayout() {

		tab.addTab("main", panel_main);
		tab.addTab("라면", panel_noodle);
		tab.addTab("분식", panel_food);
		tab.addTab("간식", panel_snack);
		tab.addTab("음료", panel_drink);
		add(tab,BorderLayout.CENTER);
		
		setBounds(100, 100, 900, 700);
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
