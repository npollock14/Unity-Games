import java.awt.image.BufferedImage;

public class assets {

	private static final int width = 32, height = 32;

	public static BufferedImage player, asteroid, grass, stone, dirt, brickWall, space, lazer;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"));

		player = sheet.crop(0, 0, width, height);
		asteroid = sheet.crop(width, 0, width, height);
		grass = sheet.crop(2 * width, 0, width, height);
		stone = sheet.crop(3 * width, 0, width, height);
		dirt = sheet.crop(0, height, width, height);
		brickWall = sheet.crop(width, height, width, height);
		space = sheet.crop(2*width, height, width, height);
		lazer = sheet.crop(3*width, height, width/2, height/2);
	}

}
