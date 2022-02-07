import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener  {
Rocketship rs;
Alien alien;

ArrayList<Projectile> projectiles = new ArrayList();
ArrayList<Alien> aliens = new ArrayList();
	public ObjectManager(Rocketship rocket) {
	this.rs=rocket;
}
	public void addProjectile(Projectile pj) {
		projectiles.add(new Projectile( rs.x +21, rs.y-10,50,50));
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
		for (int j = 0; j < projectiles.size() -1; j++) {
			projectiles.get(j).update();
			if (projectiles.get(j).y > LeagueInvaders.HEIGHT) {
				projectiles.get(j).isActive = false;
			}
			
		}
		if (rs.isActive==true) {
			checkCollision();
			purgeObjects();
		}
		
		}
	void draw(Graphics g) {
		rs.draw(g);
		for (int i = 0; i < aliens.size() -1; i++) {
			aliens.get(i).draw(g);
			
		}
		for (int i = 0; i < projectiles.size() -1; i++) {
			projectiles.get(i).draw(g);
			
		}
	}
	void purgeObjects() {
		for (int i = 0; i < aliens.size() -1; i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}}
		for (int i = 0; i < projectiles.size() -1; i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}}

	}
	void checkCollision() {
		System.out.println("red");
		for (int i = 0; i < aliens.size() - 1; i++) {
			System.out.println("hey");
			if (rs.collisionBox.intersects(alien.collisionBox)) {
				System.out.println("hello");
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		addAlien();
		
	}
}
