
public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	double drag = 0;
	boolean isActive = true;
	int moveLeft = 1;
	boolean moveRight = false;
	boolean moveUp = false;
	boolean moveDown = false;

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {

	}
}
