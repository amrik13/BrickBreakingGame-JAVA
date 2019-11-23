import java.awt.Color;

import javax.swing.JFrame;

public class BrickBallGame {

	public static void main(String[] args) {
			
		JFrame j = new JFrame("BrickBallGame");
		DrawGraphic draw = new DrawGraphic();
		j.add(draw);
		j.setResizable(false);
		j.setBounds(100, 80,800,600);
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLayout(null);
		j.getContentPane().setBackground(Color.BLACK);
		
		

	}

}
