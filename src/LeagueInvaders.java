import javax.swing.JFrame;

public class LeagueInvaders {
	static JFrame frame = new JFrame();
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	public LeagueInvaders(JFrame frame) {
		this.frame = frame;
	}
public static void main(String[] args) {
LeagueInvaders LI = new LeagueInvaders(frame);
LI.setup();
}
void setup() {
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
