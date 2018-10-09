import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	//STATIC STUFF
	
	public static Tile[] tiles = new Tile[256];
	public static Tile GrassTile = new grassTile(0); //0 is id
	public static Tile DirtTile = new dirtTile(1);
	public static Tile StoneTile = new rockTile(2);
	public static Tile BrickWall = new brickWallTile(3);
	public static Tile Space = new spaceTile(4);
	
	
	//CLASS
	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}
}
