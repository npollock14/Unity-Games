import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class lazer extends Creature{

	public static long timeToLive = 3000;
	
	public lazer(Handler handler, float x, float y, float angle) {
		super(handler, x, y, 16, 16, angle);
		bounds.x = 6;
		bounds.y = 0;
		bounds.width = 3;
		bounds.height = 16;
	}

	@Override
	public void tick() {
		moveLazer();
		
	}
	
	public void die() {
		System.out.println("Debug: Lazer Killed");
	}

	private void moveLazer() {
		xMove = (int) -(10*Math.cos(angle));
		yMove = (int) -(10*Math.sin(angle));
		x += xMove;
		y += yMove;
		
	}

	@Override
	public void render(Graphics g) {
		//TODO get lazers to be gone after a bit
		/*long startTime = System.currentTimeMillis();
		long currentTime = System.currentTimeMillis() - startTime;
		if(currentTime >= timeToLive) {
			health = 0;
			return;
		}*/

		// Rotation information

		double locationX = width/2;
		double locationY = height/2;
		AffineTransform tx = AffineTransform.getRotateInstance(angle - (Math.PI/2), locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		g.drawImage(op.filter(assets.lazer, null), (int) ((x - handler.getGameCamera().getxOffset())+(24)), (int) (y - handler.getGameCamera().getyOffset()),width,height, null);
		//g.drawImage(assets.lazer, (int) (x - handler.getGameCamera().getxOffset()),
				//(int) (y - handler.getGameCamera().getyOffset()), 16, 16, null); // gets x and y from entity
		
		
		
	}

}
