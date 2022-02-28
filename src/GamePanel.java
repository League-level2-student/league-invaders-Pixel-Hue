import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Rocketship rs = new Rocketship(225, 700, 50, 50);
	Font titleFont;
	Font subtitleFont;
	Timer FrameDraw;
	Timer movement;
	Timer alienSpawn;
	ObjectManager om;

	public GamePanel() {
		om = new ObjectManager(rs);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subtitleFont = new Font("Arial", Font.PLAIN, 32);
		FrameDraw = new Timer(1000 / 60, this);
		movement = new Timer(100, this);
		movement.setInitialDelay(1900);
		FrameDraw.start();
		if (needImage) {
			loadImage("space.png");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		om.update();
		if (rs.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {
		om.removeAliens();
		om.removeProjectiles();
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 25, 100);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to start", 80, 400);

		g.drawString("Press SPACE for instructions", 25, 600);
	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, 500, 800, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		rs.draw(g);
		om.draw(g);
		g.setColor(Color.WHITE);
		g.setFont(subtitleFont);
		g.drawString("Score: " + om.score, 5, 30);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Game Over", 100, 100);
		g.setFont(subtitleFont);
		g.drawString("You killed " + om.score + " enemies", 90, 400);
		g.drawString("Press ENTER to restart", 65, 600);

	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	void startGame() {
		alienSpawn = new Timer(1000, om);
		alienSpawn.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU) {
			updateMenuState();

			repaint();
		} else if (currentState == GAME) {
			updateGameState();

			repaint();
		} else if (currentState == END) {
			updateEndState();

			repaint();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {

				currentState = GAME;
				rs.isActive = true;
				rs.x=225;
				rs.y=700;
			
				alienSpawn.start();
				om.score = 0;
			} else {
				if (currentState == MENU) {
					startGame();
					currentState++;
				}
			
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			rs.up();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			rs.down();

		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			rs.left();

		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			rs.right();
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			om.addProjectile(rs.getProjectile());
		}
		if (currentState == END) {
			alienSpawn.stop();
			
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
