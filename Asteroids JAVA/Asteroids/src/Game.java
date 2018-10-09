import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;

	private boolean running = false;

	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	// STATES
	private State gameState;
	private State menuState;
	private State settingsState;

	// INPUT
	private KeyManager keyManager;

	// CAMERA
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();

	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		assets.init();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		

		// init states
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		settingsState = new SettingsState(handler);
		// set initial state ususly menu
		State.setState(gameState);

		// testImage = ImageLoader.loadImage("/textures/testPic.png"); //loads images
		// that will be displayed
	}

	private void tick() {
		keyManager.tick();

		if (State.getState() != null) {
			State.getState().tick();
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics(); // creating a 'paintbrush'
		g.clearRect(0, 0, width, height); // Clear screen

		if (State.getState() != null) { // makes sure a state is set and renders the current state
			State.getState().render(g);
		}
		// draw start

		// draw end
		bs.show();
		g.dispose();
	}

	public void run() {
		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps; // max amt of time to run methods
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {

			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				// System.out.println(ticks + " FPS");
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start(); // will call run method
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
