package zpChopper;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.hud.Item;
import org.rev317.api.wrappers.scene.SceneObject;
import org.rev317.api.wrappers.scene.Tile;

public class Bank implements Strategy {
	
	
	public Tile Bank = new Tile (3092, 3245, 0);

    @Override
    public boolean activate() {
        return (Players.getLocal().getLocation() != Bank
                && Players.getLocal().getAnimation() == -1);
    }


            @Override
            public void execute() {
                   final SceneObject[] Bank = SceneObjects.getNearest(2213);
                 final SceneObject b = Bank[0];
                 if(!b.isOnScreen()) {
                         b.interact("Use-quickly");
                         Time.sleep(400);
                 } else {
                	 for (Item item : Inventory.getItems()) {
                         if (b.isOnScreen());
                         if (item.getId() == 1521) {
                        	 item.interact("Store all");
                        	 Time.sleep(50);
                           
 
           }
        }
  	 }
  }
}