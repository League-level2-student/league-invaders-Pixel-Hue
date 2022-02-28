import javax.swing.JFrame;

public class LeagueInvaders {
	static GamePanel gp = new GamePanel();
	static JFrame frame = new JFrame();
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	public LeagueInvaders(JFrame frame, GamePanel gp) {
		this.frame = frame;
		this.gp = gp;

	}

	public static void main(String[] args) {
		LeagueInvaders LI = new LeagueInvaders(frame, gp);
		LI.setup();
	}

	void setup() {
		frame.add(gp);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(gp);
	}
}
