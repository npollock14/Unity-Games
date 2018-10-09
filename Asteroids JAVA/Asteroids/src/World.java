import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class World {

	private Handler handler;
	private int width, height; // in tiles
	private int spawnX, spawnY;
	public static int SPAWN_X, SPAWN_Y;
	private int[][] tiles;
	// Entities
	private EntityManager entityManager;

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler,
				new Player(handler, SPAWN_X * Tile.TILE_WIDTH, SPAWN_Y * Tile.TILE_HEIGHT, (float) (Math.PI / 2)));

		loadWorld(path);
		entityManager.getPlayer().setX(spawnX * Tile.TILE_WIDTH);
		entityManager.getPlayer().setY(spawnY * Tile.TILE_HEIGHT);
		entityManager.addEntity(new asteroid(handler,
				(ThreadLocalRandom.current().nextInt(1, width - 2)) * Tile.TILE_WIDTH,
				(ThreadLocalRandom.current().nextInt(2, height - 2)) * Tile.TILE_HEIGHT, (float) (Math.PI / 2)));
		entityManager.addEntity(new asteroid(handler,
				(ThreadLocalRandom.current().nextInt(1, width - 2)) * Tile.TILE_WIDTH,
				(ThreadLocalRandom.current().nextInt(2, height - 2)) * Tile.TILE_HEIGHT, (float) (Math.PI / 2)));
		entityManager.addEntity(new asteroid(handler,
				(ThreadLocalRandom.current().nextInt(1, width - 2)) * Tile.TILE_WIDTH,
				(ThreadLocalRandom.current().nextInt(2, height - 2)) * Tile.TILE_HEIGHT, (float) (Math.PI / 2)));
		entityManager.addEntity(new asteroid(handler,
				(ThreadLocalRandom.current().nextInt(1, width - 2)) * Tile.TILE_WIDTH,
				(ThreadLocalRandom.current().nextInt(2, height - 2)) * Tile.TILE_HEIGHT, (float) (Math.PI / 2)));
		entityManager.addEntity(new asteroid(handler,
				(ThreadLocalRandom.current().nextInt(1, width - 2)) * Tile.TILE_WIDTH,
				(ThreadLocalRandom.current().nextInt(2, height - 2)) * Tile.TILE_HEIGHT, (float) (Math.PI / 2)));

	}

	public void tick() {
		entityManager.tick();
	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH - 1); // better rendering
																									// add 1 for test
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT - 1);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));

			}
		}
		entityManager.render(g);

	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) { // if outside of the map
			System.out.println("Debug: Outside Map");
			return Tile.GrassTile;
		}

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			System.out.println("Debug: Map Boundary Error\n" + "x:" + x + "y:" + y);
			return Tile.DirtTile;
		}
		return t;
	}

	private void loadWorld(String path) {
		String file = utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = utils.parseInt(tokens[0]);
		height = utils.parseInt(tokens[1]);
		spawnX = utils.parseInt(tokens[2]);
		spawnY = utils.parseInt(tokens[3]);
		SPAWN_X = spawnX;
		SPAWN_Y = spawnY;

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
