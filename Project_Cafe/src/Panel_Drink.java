import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel_Drink extends JPanel{
	JButton aBtn = new JButton("A button");

	public Panel_Drink() {
		setBackground(Color.RED);
		setLayout(new GridLayout());
		add(aBtn);
	}
}
