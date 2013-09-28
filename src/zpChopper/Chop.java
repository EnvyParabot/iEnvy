package zpChopper;

import org.parabot.core.ui.components.LogArea;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Camera;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;
import org.rev317.api.wrappers.scene.Tile;

public class Chop implements Strategy {
	
	public Tile Bank = new Tile (3092, 3245, 0);
	public Tile Willow = new Tile (3086, 3234, 0);
	
    public int OAK = 1281;
    public int BOX = 9398;
    public int[] WILLOW = { 1308, 5553, 5551, 5552 };


	@Override
	public boolean activate() {
		return(Players.getLocal().getAnimation() == -1
				&& Willow.distanceTo() < 2);
	}

	@Override
	public void execute() {
		final SceneObject[] Willow = SceneObjects.getNearest(WILLOW);
		final SceneObject w = Willow[0];
		if(w == null);
		LogArea.log("Turning Camera to (Willow)");
		Camera.turnTo(w);
		Time.sleep(100);
		{
		if(w.isOnScreen());
		LogArea.log("Chopping");
		w.interact("Chop down");
		Time.sleep(2000);
			
		}
		
		}
	
	}