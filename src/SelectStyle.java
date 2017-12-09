
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Viewer/controller for the viewer interface that allows the user to select the style they wish to use.
 * @author Grant Clegg
 * @author Daniel Fonyo
 * @author Vincent Tran
 *
 */
public class SelectStyle extends JFrame{

	public SelectStyle(ModelOfMancala mom) {
		JPanel panel = new JPanel();
		setLayout(null);
		setSize(500,300);
		
		JLabel label = new JLabel("Choose a style to play with!");
		
		JButton button1 = new JButton("Style 1");
		button1.setPreferredSize(new Dimension(100,50));
		button1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				//MainFrameOne frame = new MainFrameOne();
				InputMarbles input = new InputMarbles(mom, new StrategyOne());
				SelectStyle.super.dispose();
			}
			
		});
		
		JButton button2 = new JButton("Style 2");
		button2.setPreferredSize(new Dimension(100,50));
		button2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				//MainFrameOne frame = new MainFrameOne();
				InputMarbles input = new InputMarbles(mom, new StrategyTwo());
				SelectStyle.super.dispose();
			}
			
		});
		
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		panel.setBounds(getWidth() / 2 - 50, getHeight() / 2 - 50, 200, 150);
		add(panel);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
