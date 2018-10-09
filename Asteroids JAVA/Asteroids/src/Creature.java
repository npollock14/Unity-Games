
public abstract class Creature extends Entity {

	public static final float DEFAULT_MOVE_SPEED = .1f;
	public static final float DEFAULT_ROTATION_SPEED = (float)Math.PI/96;
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
	

	protected float moveSpeed, rotateSpeed;
	protected float xMove, yMove, angleMove;

	public Creature(Handler handler, float x, float y, int width, int height, float angle) {
		super(handler, x, y, width, height, angle); // refers to the entity class
		moveSpeed = DEFAULT_MOVE_SPEED;
		xMove = 0;
		yMove = 0;
		angleMove = 0;

	}

	public void move() {
		moveX();
		moveY();
	}
	public void rotate() {
		angle += angleMove;
	}

	public void moveX() {
		if (xMove > 0) { // moving right collision test

			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else {
				// no move
				xMove = -xMove;
			}

		} else if (xMove < 0) { // moving left collision test
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
			
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else {
				// no move
				xMove = -xMove;
				
			}

		}
	}

	public void moveY() {
		if (yMove < 0) { // going up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			} else {
				// no move
				yMove = -yMove;
			}

		} else if (yMove > 0) { // going down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			} else {
				// no move
				yMove = -yMove;
			}
		}
	}

	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	// source --> getters and setters

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return moveSpeed;
	}

	public void setSpeed(float speed) {
		this.moveSpeed = speed;
	}

}
