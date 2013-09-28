package test;

import java.util.ArrayList;

import org.parabot.core.ui.components.LogArea;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.api.utils.Timer;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Camera;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.hud.Item;
import org.rev317.api.wrappers.scene.SceneObject;
import org.rev317.api.wrappers.scene.Tile;

@ScriptManifest(author = "Cynical", category = Category.WOODCUTTING, description = "Simply Woodcutting!", name = "ZPChopper", servers = { "RuneOnline" }, version = 1)
public class ZPChopper extends Script  {
    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	
	public Tile Bank = new Tile (3092, 3245, 0);
	public Tile Willow = new Tile (3086, 3234, 0);
	
    public int OAK = 1281;
    public int BOX = 9398;
    public int[] WILLOW = { 1308, 5553, 5551, 5552 };
    
    Timer t = new Timer(200);

    @Override
    public boolean onExecute() {
    	LogArea.log("Script Started!");
    	strategies.add(new Chop());
        strategies.add(new OakToBank());
        strategies.add(new Bank());
        strategies.add(new BankToWillow());
        provide(strategies);
        return true;
    }

    @Override
    public void onFinish() {
    	LogArea.log("Thankyou for using ZPChopper");
    	LogArea.log("Script made by Cynical");

    }
    
    public class Chop implements Strategy {

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

    
    public class BankToWillow implements Strategy {


    	  @Override
          public boolean activate() {
                  return !Inventory.isEmpty() 
                		  && Players.getLocal().getLocation() != Bank;
          }
   
          @Override
          public void execute() {
	                Willow.clickMM();
	                Time.sleep(1000);
          }
    }
    
    public class OakToBank implements Strategy {
    	
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
        
       
    public class Bank implements Strategy {

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
} 
