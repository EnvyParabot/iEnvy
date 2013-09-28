package zpAgility;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.parabot.core.ui.components.LogArea;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Camera;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.methods.Skill;
import org.rev317.api.wrappers.scene.SceneObject;
import org.rev317.api.wrappers.scene.Tile;

/**
 * Made by: Envy
 */

@ScriptManifest(author = "Envy", category = Category.AGILITY, description = "One Of A Kind!", name = "ZPAgility", servers = { "DeviousPK & RecklessPK" }, version = 2)
public class ZPAgility extends Script implements Paintable {
	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

	public int startExp = 0;
	public int currentExp = 0;
	public int startLevel = 0;
	static long startTime;
	public int currentLevel = 0;
	public String status;
	public int pipe;
	private boolean isClicking = false;

	public Tile OBSTACLEPIPE = new Tile(2484, 3430, 0);
	public Tile BOTTOMPIPE = new Tile(2484, 3437, 0);
	public Tile FAILSAFE = new Tile(2483, 3431, 0);

	public final int bushID = 1276;
	public final int pipeID = 154;

	private final Color color1 = new Color(0, 0, 0, 74);
	private final Color color2 = new Color(0, 0, 0);
	private final Color color3 = new Color(255, 255, 255);
	private final BasicStroke stroke1 = new BasicStroke(1);
	private final Font font1 = new Font("Bitstream Charter", 0, 10);

	public String runTime(long i) {
		DecimalFormat nf = new DecimalFormat("00");
		long millis = System.currentTimeMillis() - i;
		long hours = millis / (1000 * 60 * 60);
		millis -= hours * (1000 * 60 * 60);
		long minutes = millis / (1000 * 60);
		millis -= minutes * (1000 * 60);
		long seconds = millis / 1000;
		return nf.format(hours) + ":" + nf.format(minutes) + ":"
				+ nf.format(seconds);

	}

	public void paint(Graphics g1) {
		currentExp = Skill.AGILITY.getExperience();
		currentExp -= startExp;
		Graphics2D g = (Graphics2D) g1;
		g.setColor(color1);
		g.fillRect(2, 324, 515, 15);
		g.setColor(color2);
		g.setStroke(stroke1);
		g.drawRect(2, 324, 515, 15);
		g.setFont(font1);
		g.setColor(color3);
		g.drawString("Time Running:" + runTime(startTime), 6, 335);
		g.drawString("||", 161, 334);
		g.drawString("Xp Gained:" + currentExp, 171, 335);
		g.drawString("||", 298, 334);
		g.drawString("Status:" + status, 310, 335);
		g.drawString("||", 409, 334);
		g.drawString("Level:" + currentLevel, 422, 335);
	}

	@Override
	public boolean onExecute() {
		LogArea.log("Script Started");
		strategies.add(new Pipe());
		strategies.add(new Walk());
		startTime = System.currentTimeMillis();
		startExp = Skill.AGILITY.getExperience();
		currentLevel = Skill.AGILITY.getLevel();
		provide(strategies);
		return true;
	}

	@Override
	public void onFinish() {
		LogArea.log("Thankyou for using ZPAgility");
		LogArea.log("Script made by Envy");

	}

	public class Pipe implements Strategy {

		@Override
		public boolean activate() {
			return (Players.getLocal().getLocation() != OBSTACLEPIPE
					&& OBSTACLEPIPE.distanceTo() < 1
					&& Players.getLocal().getAnimation() == -1 && !isClicking);
		}

		@Override
		public void execute() {
			final SceneObject[] obstaclePipe = SceneObjects.getNearest(pipeID);
			final SceneObject i = obstaclePipe[0];
			isClicking = false;
			if (i != null);
			Time.sleep(5);
			if (i.isOnScreen()) {
				status = "Interacting";
				i.interact("Squeeze-through");
				Time.sleep(5);
				i.interact("Squeeze-through");
				i.interact("Squeeze-through");
				i.interact("Squeeze-through");
				i.interact("Squeeze-through");
				i.interact("Squeeze-through");
				i.interact("Squeeze-through");
				i.interact("Squeeze-through");
				Time.sleep(100);
			} else if (i.distanceTo() < 2);
			status = "FailSafe";
			OBSTACLEPIPE.clickMM();
			status = "Completed";
			Time.sleep(100);
		}
	}
	
	public class Walk implements Strategy {

		public boolean activate() {
			return (Players.getLocal().getLocation() != BOTTOMPIPE
					&& Players.getLocal().getAnimation() == -1
					&& Players.getLocal().getLocation() != OBSTACLEPIPE);

		}

		public void execute() {
			final SceneObject[] bush = SceneObjects.getNearest(bushID);
			final SceneObject b = bush[0];
			status = "Walking";
			if(b.isOnScreen());
			Camera.turnTo(b);
			OBSTACLEPIPE.clickMM();
			Time.sleep(2000);
	}
 }
}
