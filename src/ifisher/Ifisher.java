package ifisher;

import java.util.ArrayList;

import org.parabot.core.ui.components.LogArea;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Npcs;
import org.rev317.api.methods.Players;
import org.rev317.api.wrappers.hud.Item;
import org.rev317.api.wrappers.hud.Tab;
import org.rev317.api.wrappers.interactive.Npc;

@ScriptManifest(author = "Envy", category = Category.FISHING, description = "The ultimate fishing script", name = "iFisher", servers = { "RuneOnline" }, version = 1)
public class Ifisher extends Script {
	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
		
	public int[] barbRaw = {335, 331}; 
	public int flyRod = 309;
	public int feather = 314;
	Npc[] trout = Npcs.getNearest(331);

	@Override
	public boolean onExecute() {
		LogArea.log("iFisher has started");
		strategies.add(new Trout());
		strategies.add(new Drop());
		provide(strategies);
		return true;
	}
	
		public class Trout implements Strategy {

		@Override
		public boolean activate() {
			return (Players.getLocal().getAnimation() == -1); 
		}

		@Override
		public void execute() {
	        if(trout != null){
	            trout[0].interact("Lure");
	            Time.sleep(1000);
	            
	        }
		}
	}	

public class Drop implements Strategy {

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
}