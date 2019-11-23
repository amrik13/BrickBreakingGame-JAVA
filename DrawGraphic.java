import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class DrawGraphic extends Panel implements ActionListener,KeyListener{
	private int barX = 200;
	private int ballX = 200;
	private int ballY = 200;
	private int score = 0;
	private boolean play= false;
	private Timer timer;
	private int delay = 8;
	private int ballXDir = -1;
	private int ballYDir = -1;
	private int x1,x2,x3,x4,x5,x6,x7,x8;
	private int y1,y2,y3,y4,y5,y6,y7,y8;
	
	public DrawGraphic() {
		addKeyListener(this);
		timer = new Timer(delay,this);
		timer.start();
		x1=x2=x3=x4=x5=x6=x7=x8 = 85;
		y1=y2=y3=y4=y5=y6=y7=y8 = 55;
	}
	
	public void paint(Graphics g) {
		//background
		setBackground(Color.BLACK);
		
		//border
		g.setColor(Color.RED);
		g.fillRect(0, 0, 5,570);
		g.fillRect(0, 0, 800,5);
		g.fillRect(795, 0, 5,570);
		g.fillRect(0,565, 800,5);
		
		//bar
		g.setColor(Color.BLUE);
		g.fillRect(barX, 550, 150, 10);
		
		//ball
		g.setColor(Color.WHITE);
		g.fillOval(ballX, ballY, 20,20);
		
		//bricks
		
		g.setColor(Color.GRAY);
		g.fillRect(15,10,x1,y1);
		g.fillRect(110,10,x2,y2);
		g.fillRect(205,10,x3,y3);
		g.fillRect(300,10,x4,y4);
		g.fillRect(395,10,x5,y5);
		g.fillRect(490,10,x6,y6);
		g.fillRect(585,10,x7,y7);
		g.fillRect(680,10,x8,y8);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(play) {
			ballX = ballX + ballXDir;
			ballY = ballY + ballYDir;
			
			if(ballX <= 5 || ballX >= 775) {
				ballXDir = -ballXDir;
			}
			if(ballY <= 5) {
				ballYDir = -ballYDir;
			}
			if(new Rectangle(barX, 550, 150, 10).intersects(
					new Rectangle(ballX, ballY, 20,20))) {
				ballYDir = -ballYDir;
			}
			if(ballY >= 565) {
				timer.stop();
				play = false;
				System.out.println("GAME OVER!!!");
			}
			
			if(new Rectangle(15,10,x1,y1).intersects(
					new Rectangle(ballX, ballY, 20,20))) {
				x1=y1=0;
				ballYDir = -ballYDir;
				score++;
				System.out.println(score);
				delay = delay - 1;
				timer.setDelay(delay);
			}
			if(new Rectangle(110,10,x2,y2).intersects(
					new Rectangle(ballX, ballY, 20,20))) {
				x2=y2=0;
				ballYDir = -ballYDir;
				score++;
				System.out.println(score);
				delay = delay - 1;
				timer.setDelay(delay);
			}
			if(new Rectangle(205,10,x3,y3).intersects(
					new Rectangle(ballX, ballY, 20,20))) {
				x3=y3=0;
				ballYDir = -ballYDir;
				score++;
				System.out.println(score);
				delay = delay - 1;
				timer.setDelay(delay);
			}
			if(new Rectangle(300,10,x4,y4).intersects(
					new Rectangle(ballX, ballY, 20,20))) {
				x4=y4=0;
				ballYDir = -ballYDir;
				score++;
				System.out.println(score);
				
				timer.setDelay(delay);
			}
			if(new Rectangle(395,10,x5,y5).intersects(
					new Rectangle(ballX, ballY, 20,20))) {
				x5=y5=0;
				ballYDir = -ballYDir;
				score++;
				System.out.println(score);
				delay = delay - 1;
				timer.setDelay(delay);
			}
			if(new Rectangle(490,10,x6,y6).intersects(
					new Rectangle(ballX, ballY, 20,20))) {
				x6=y6=0;
				ballYDir = -ballYDir;
				score++;
				System.out.println(score);
				delay = delay - 1;
				timer.setDelay(delay);
			}
			if(new Rectangle(585,10,x7,y7).intersects(
					new Rectangle(ballX, ballY, 20,20))) {
				x7=y7=0;
				ballYDir = -ballYDir;
				score++;
				System.out.println(score);
				
				timer.setDelay(delay);
			}
			if(new Rectangle(680,10,x8,y8).intersects(
					new Rectangle(ballX, ballY, 20,20))) {
				x8=y8=0;
				ballYDir = -ballYDir;
				score++;
				System.out.println(score);
				
				timer.setDelay(delay);
			}
			
			if(score >= 8) {
				timer.stop();
				play = false;
				System.out.println("WINNER WINNER CHICKER DINNER!!");
			}
			
			repaint();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			play = true;
			if(barX <= 5) {
				barX = 5;
			}else {
				barX = barX - 20;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			play = true;
			if(barX >= 795-150) {
				barX = 795-150;
			}else {
				barX = barX + 20;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}

}
