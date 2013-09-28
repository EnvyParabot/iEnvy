package ifisher;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Players;
import org.rev317.api.wrappers.hud.Item;

public class Drop implements Strategy {
	public int[] barbRaw = {335, 331}; 

	@Override
	public boolean activate() {
		return (Players.getLocal().getAnimation() == -1 
				&& Inventory.isFull());
	}

	@Override
	public void execute() {
			for (final Item raw : Inventory.getItems(barbRaw)) {
				raw.interact("Drop");
				Time.sleep(100);
			
		}

	}
 }