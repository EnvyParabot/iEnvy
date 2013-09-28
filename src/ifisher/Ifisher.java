package ifisher;

import java.util.ArrayList;

import org.parabot.core.ui.components.LogArea;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

@ScriptManifest(author = "Envy", category = Category.FISHING, description = "The ultimate fishing script", name = "iFisher", servers = { "RuneOnline" }, version = 1)
public class Ifisher extends Script {
	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

	@Override
	public boolean onExecute() {
		LogArea.log("iFisher has started");
		strategies.add(new Trout());
		strategies.add(new Drop());
		provide(strategies);
		return true;
	}
}