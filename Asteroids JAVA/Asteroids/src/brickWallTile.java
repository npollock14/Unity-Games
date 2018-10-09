public class brickWallTile extends Tile {

	public brickWallTile(int id) {
		super(assets.brickWall, id);
	}
	@Override
	public boolean isSolid() {
		return true;
	}

}