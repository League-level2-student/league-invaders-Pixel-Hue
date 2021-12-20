import java.util.ArrayList;
import java.util.Random;

public class ObjectManager  {
Rocketship rs;
Alien alien;

ArrayList<Projectile> projectiles = new ArrayList();
ArrayList<Alien> aliens = new ArrayList();
	public ObjectManager(Rocketship rocket) {
	this.rs=rocket;
}
	public void addProjectile(Projectile pj) {
		
	}
	void addAlien() {
		aliens.add(new Alien(new Random().nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void update() {
		for (int i = 0; i < aliens.size() -1; i++) {
		aliens.get(i).update();
		if (aliens.get(i).y > LeagueInvaders.HEIGHT) {
			aliens.get(i).isActive = false;
		}
		}
	
	}
}
