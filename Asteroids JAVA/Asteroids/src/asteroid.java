import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class asteroid extends Creature {

	public asteroid(Handler handler, float x, float y, float angle) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, angle);
		// by default its the entire width of entity
		bounds.x = 16; // start x and y
		bounds.y = 16;
		bounds.width = 32; // width and height of bound box
		bounds.height = 32;
		xMove = ThreadLocalRandom.current().nextInt(-3, 3);
		yMove = ThreadLocalRandom.current().nextInt(-3, 3);
	}

	@Override
	public void tick() {
		asteroidMoveX();
		asteroidMoveY();
		asteroidRotate();
	}
	
	public void die() {
		System.out.println("Debug: Asteroid Killed");
	}

	private void asteroidMoveX() {
		if (xMove > 0) { // moving right collision test

			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else {
				// ran into a wall
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

	private void asteroidMoveY() {
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

	private void asteroidRotate() {

	}

	@Override
	public void render(Graphics g) {
		// System.out.println("ASTEROID INCOMING");
		g.drawImage(assets.asteroid, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null); // gets x and y from entity

	}
}
