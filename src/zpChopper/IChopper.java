package zpChopper;

import java.util.ArrayList;

import org.parabot.core.ui.components.LogArea;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

@ScriptManifest(author = "Cynical", category = Category.WOODCUTTING, description = "Simply Woodcutting!", name = "ZPChopper", servers = { "RuneOnline" }, version = 1)
public class IChopper extends Script  {
    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

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
}


