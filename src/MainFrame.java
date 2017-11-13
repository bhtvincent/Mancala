import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	public MainFrame() {
		JPanel top = new JPanel();
		JLabel topArrow = new JLabel("<-------");
		JLabel topName = new JLabel("Player B");
		top.add(topArrow);
		top.add(topName);

		JPanel bottom = new JPanel();
		JLabel bottomArrow = new JLabel("------->");
		JLabel bottomName = new JLabel("Player A");
		bottom.add(bottomArrow);
		bottom.add(bottomName);

		JPanel left = new JPanel();
		JLabel leftPit = new JLabel();
		leftPit.setText("<html>M<br>A<br>N<br>C<br>A<br>L<br>A<br> <br>A</html>");
		leftPit.setPreferredSize(new Dimension(50, 50));
		leftPit.setHorizontalAlignment(JLabel.CENTER);
		left.setLayout(new BorderLayout());
		left.add(leftPit, BorderLayout.CENTER);

		JPanel right = new JPanel();
		JLabel rightPit = new JLabel();
		rightPit.setText("<html>M<br>A<br>N<br>C<br>A<br>L<br>A<br> <br>B</html>");
		rightPit.setPreferredSize(new Dimension(50, 50));
		rightPit.setHorizontalAlignment(JLabel.CENTER);
		right.setLayout(new BorderLayout());
		right.add(rightPit, BorderLayout.CENTER);

		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());

		setSize(1000, 700);
		setTitle("Mancala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main.add(top, BorderLayout.NORTH);
		main.add(bottom, BorderLayout.SOUTH);
		main.add(left, BorderLayout.WEST);
		main.add(right, BorderLayout.EAST);

		add(main, BorderLayout.CENTER);
		
		setVisible(true);

	}

}
