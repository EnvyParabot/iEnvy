package zpAgility;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Camera;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;
import org.rev317.api.wrappers.scene.Tile;

public class Walk implements Strategy {
	

	public Tile OBSTACLEPIPE = new Tile(2484, 3430, 0);
	public Tile BOTTOMPIPE = new Tile(2484, 3437, 0);
	public Tile FAILSAFE = new Tile(2483, 3431, 0);
	
	public final int bushID = 1276;
	public final int pipeID = 154;


	public boolean activate() {
		return (Players.getLocal().getLocation() != BOTTOMPIPE
				&& Players.getLocal().getAnimation() == -1
				&& Players.getLocal().getLocation() != OBSTACLEPIPE);

	}

	public void execute() {
		final SceneObject[] bush = SceneObjects.getNearest(bushID);
		final SceneObject b = bush[0];
		if(b.isOnScreen());
		Camera.turnTo(b);
		OBSTACLEPIPE.clickMM();
		Time.sleep(2000);
	}
		
}	