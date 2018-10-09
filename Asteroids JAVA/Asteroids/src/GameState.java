import java.awt.Graphics;

public class GameState extends State { // requires methods in State class

	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		// player = new Player(handler, 100, 100 , (float)Math.PI/2);
		// Asteroid = new asteroid(handler, 100,100,(float)Math.PI/2);

	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}
}
