package ifisher;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Npcs;
import org.rev317.api.methods.Players;
import org.rev317.api.wrappers.interactive.Npc;

public class Trout implements Strategy {
	Npc[] trout = Npcs.getNearest(331);

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
