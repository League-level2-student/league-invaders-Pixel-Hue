import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Font subtitleFont;
    Timer FrameDraw;
    public GamePanel() {
    	   titleFont = new Font("Arial", Font.PLAIN, 48);	
    	   subtitleFont = new Font("Arial", Font.PLAIN, 32);
   	    FrameDraw = new Timer(1000/60,this);
   FrameDraw.start();
    }
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	 void updateMenuState() {  
		 
	 }
	 void updateGameState() {  
		 
	 }
	 void updateEndState()  {  
		 
	 }
	 void drawMenuState(Graphics g) {  
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("LEAGUE INVADERS", 25,100);
		g.setFont(subtitleFont);
		 g.drawString("Press ENTER to start", 80,400);
		 
		 g.drawString("Press SPACE for instructions", 25,600);
	 }
void drawGameState(Graphics g) {  
	 g.setColor(Color.BLACK);
	 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
}
void drawEndState(Graphics g)  {  
	 g.setColor(Color.RED);
	 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	 g.setFont(titleFont);
	 g.setColor(Color.YELLOW);
	 g.drawString("Game Over", 100,100);
	g.setFont(subtitleFont);
	 g.drawString("You killed " + " enemies", 90,400);
	 g.drawString("Press ENTER to restart", 65,600);
	 
	
}
@Override
public void actionPerformed(ActionEvent e) {
	if(currentState == MENU){
	    updateMenuState();
	   
	    repaint();
	}else if(currentState == GAME){
	    updateGameState();
	  
	    repaint();
	}else if(currentState == END){
	    updateEndState();
	  
	    repaint();
	}
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if (e.getKeyCode()==KeyEvent.VK_ENTER) {
	    if (currentState == END) {
	        currentState = MENU;
	    } else {
	        currentState++;
	    }
	    if (e.getKeyCode()==KeyEvent.VK_W) {
    System.out.println("UP");
}
	    if (e.getKeyCode()==KeyEvent.VK_S) {
    System.out.println("DOWN");
}
	    if (e.getKeyCode()==KeyEvent.VK_A) {
    System.out.println("LEFT");
}
	    if (e.getKeyCode()==KeyEvent.VK_D) {
    System.out.println("RIGHT");
}
	    //fix
	}   
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
