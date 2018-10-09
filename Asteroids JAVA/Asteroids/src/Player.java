import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.util.concurrent.ThreadLocalRandom;

public class Player extends Creature {

	public static long lastAttackTimer, attackCooldown = 500, attackTimer = attackCooldown;
	
	
	public Player(Handler handler, float x, float y, float angle) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, angle); // specifies the
																										// width and
																										// height for
																										// creatures by
																										// default
		// by default its the entire width of entity
		bounds.x = 16; // start x and y
		bounds.y = 16;
		bounds.width = 32; // width and height of bound box
		bounds.height = 32;
	}

	@Override
	public void tick() {
		getInput();
		move();
		rotate();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	

	public void die() {
		System.out.println("You Lose");
	}

	private void getInput() {
		// xMove = 0;
		// yMove = 0;
		angleMove = 0;

		if (handler.getKeyManager().upArrow || handler.getKeyManager().upW) {
			yMove = (float) (-DEFAULT_MOVE_SPEED * Math.sin(angle)) + yMove;
		}
		if (handler.getKeyManager().downArrow || handler.getKeyManager().downS) {
			yMove = (float) (DEFAULT_MOVE_SPEED * Math.sin(angle)) + yMove;
		}
		if (handler.getKeyManager().upArrow || handler.getKeyManager().upW) {
			xMove = (float) (-DEFAULT_MOVE_SPEED * Math.cos(angle)) + xMove;
		}
		if (handler.getKeyManager().downArrow || handler.getKeyManager().downS) {
			xMove = (float) (DEFAULT_MOVE_SPEED * Math.cos(angle)) + xMove;
		}
		if (handler.getKeyManager().leftArrow || handler.getKeyManager().leftA) {
			angleMove = -DEFAULT_ROTATION_SPEED;
			System.out.println(angle);
		}
		if (handler.getKeyManager().rightArrow || handler.getKeyManager().rightD) {
			angleMove = DEFAULT_ROTATION_SPEED;
			System.out.println(angle);
		}
		
	}

	@Override
	public void render(Graphics g) {
		AffineTransform tx = AffineTransform.getTranslateInstance((int) (x - handler.getGameCamera().getxOffset()), (y - handler.getGameCamera().getyOffset()));
		tx.rotate(angle - (Math.PI/2), width/2, height/2);
		tx.scale(2, 2);
		//AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(assets.player, tx, null);
		//g.drawImage(assets.player, (int) (x - handler.getGameCamera().getxOffset()),
			//	(int) (y - handler.getGameCamera().getyOffset()), width, height, null); // gets x and y from entity
																						// class
		//g.setColor(Color.red);
		//g.drawLine((int) (x + width) / 2, (int) (y + height) / 2, (int) (-1000 * Math.cos(angle) + (x + width) / 2),
		//		(int) (-1000 * Math.sin(angle) + (y + height) / 2));
		// g.setColor(Color.red);
		// g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
		// (int)(y+bounds.y - handler.getGameCamera().getyOffset()), bounds.width,
		// bounds.height);
	}

}
