package zpChopper;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Players;
import org.rev317.api.wrappers.scene.Tile;

public class OakToBank implements Strategy {
	
	public Tile Bank = new Tile (3092, 3245, 0);
	public Tile Willow = new Tile (3086, 3234, 0);
	
    public int OAK = 1281;
    public int BOX = 9398;
    public int[] WILLOW = { 1308, 5553, 5551, 5552 };


    @Override
    public boolean activate() {
                 return (Players.getLocal().getLocation() != Willow);
    }

    @Override
    public void execute() {
            Time.sleep(50);
            Willow.clickMM();
            Time.sleep(100);
         }
        }
