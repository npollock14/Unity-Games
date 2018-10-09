import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean upW, upArrow, downS, downArrow, leftA, leftArrow, rightD, rightArrow,space;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		upW = keys[KeyEvent.VK_W];
		upArrow = keys[38];
		downS = keys[KeyEvent.VK_S];
		downArrow = keys[40];
		leftA = keys[KeyEvent.VK_A];
		leftArrow = keys[37];
		rightD = keys[KeyEvent.VK_D];
		rightArrow = keys[39];
		space = keys[KeyEvent.VK_SPACE];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		//System.out.println(e.getKeyChar() + " Pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		//System.out.println("Released");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
