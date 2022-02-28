import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	int score = 0;

	ArrayList<Projectile> projectiles = new ArrayList();
	ArrayList<Alien> aliens = new ArrayList();

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	public void addProjectile(Projectile pj) {
		projectiles.add(new Projectile(rocket.x + 21, rocket.y - 10, 50, 50));
	}

	void addAlien() {
		aliens.add(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		rocket.update();
		for (int i = 0; i < aliens.size() - 1; i++) {
			aliens.get(i).update();
			if (aliens.get(i).y > LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
		}
		for (int j = 0; j < projectiles.size() - 1; j++) {
			projectiles.get(j).update();
			if (projectiles.get(j).y > LeagueInvaders.HEIGHT) {
				projectiles.get(j).isActive = false;
			}

		}

		if (rocket.isActive == true) {
			checkCollision();
			purgeObjects();
		}

	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size() - 1; i++) {
			aliens.get(i).draw(g);

		}
		for (int i = 0; i < projectiles.size() - 1; i++) {
			projectiles.get(i).draw(g);

		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size() - 1; i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size() - 1; i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}

		}
		if (rocket.isActive == false) {
			rocket.x = 700;
		}
	}

	void checkCollision() {
		for (int i = 0; i < aliens.size() - 1; i++) {
			Alien alien = aliens.get(i);

			if (rocket.collisionBox.intersects(alien.collisionBox)) {
				rocket.isActive = false;

			}
		}
		for (int i = 0; i < aliens.size() - 1; i++) {
			Alien alien = aliens.get(i);
			for (int j = 0; j < projectiles.size() - 1; j++) {
				Projectile pj = projectiles.get(j);
				if (pj.collisionBox.intersects(alien.collisionBox)) {
					aliens.remove(i);
					projectiles.remove(j);
					score++;
				}
			}
		}
	}

	void removeAliens() {
		for (int i = 0; i < aliens.size() - 1; i++) {
			aliens.remove(i);
		}
	}
	void removeProjectiles() {
		for (int i = 0; i < projectiles.size() - 1; i++) {
			projectiles.remove(i);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		addAlien();

	}


}
