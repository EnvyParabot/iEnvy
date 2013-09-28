package zpAgility;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Game;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;
import org.rev317.api.wrappers.scene.Tile;

public class Pipe implements Strategy {

	public Tile OBSTACLEPIPE = new Tile(2484, 3430, 0);
	public Tile BOTTOMPIPE = new Tile(2484, 3437, 0);
	public Tile FAILSAFE = new Tile(2483, 3431, 0);

	public final int bushID = 1276;
	public final int pipeID = 154;	
	
	private boolean isClicking = false;


	@Override
	public boolean activate() {
		return (Players.getLocal().getLocation() != OBSTACLEPIPE
				&& OBSTACLEPIPE.distanceTo() < 1
				&& Players.getLocal().getAnimation() == -1 && !isClicking
				&& Game.isLoggedIn());
	}

	@Override
	public void execute() {
		final SceneObject[] obstaclePipe = SceneObjects.getNearest(pipeID);
		final SceneObject i = obstaclePipe[0];
		isClicking = false;
		if (i != null);
		Time.sleep(5);
		if (i.isOnScreen()) {
			i.interact("Squeeze-through");
			Time.sleep(5);
			i.interact("Squeeze-through");
			i.interact("Squeeze-through");
			i.interact("Squeeze-through");
			i.interact("Squeeze-through");
			i.interact("Squeeze-through");
			i.interact("Squeeze-through");
			i.interact("Squeeze-through");
			Time.sleep(100);
		} else if (i.distanceTo() < 2);
		OBSTACLEPIPE.clickMM();
		Time.sleep(100);
		
	}
	
}