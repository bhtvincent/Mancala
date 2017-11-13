
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectStyle extends JFrame{

	public SelectStyle() {
		JPanel panel = new JPanel();
		setLayout(null);
		setSize(500,300);
		
		JLabel label = new JLabel("Choose a style to play with!");
		
		JButton button1 = new JButton("Style 1");
		button1.setPreferredSize(new Dimension(100,50));
		button1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				//Load mancala game
				InputMarbles input = new InputMarbles();
				SelectStyle.super.dispose();
			}
			
		});
		
		JButton button2 = new JButton("Style 2");
		button2.setPreferredSize(new Dimension(100,50));
		button2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				//Load mancala game
				InputMarbles input = new InputMarbles();
				SelectStyle.super.dispose();
			}
			
		});
		
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		panel.setBounds(getWidth() / 2 - 50, getHeight() / 2 - 50, 200, 150);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
