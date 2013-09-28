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
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Skill;

/**
 * Made by: Envy
 */

@ScriptManifest(author = "Envy", category = Category.AGILITY, description = "Simplicity Is Everything", name = "ZPAgility", servers = { "DeviousPK & RecklessPK" }, version = 2)
public class iAgility extends Script implements Paintable {
	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

	public int startExp = 0;
	public int currentExp = 0;
	public int startLevel = 0;
	static long startTime;
	public int currentLevel = 0;
	public int pipe;

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
		g.drawString("Comingsoon:", 310, 335);
		g.drawString("||", 409, 334);
		g.drawString("Level:" + currentLevel, 422, 335);
	}

	@Override
	public boolean onExecute() {
		LogArea.log("iAgility has started.");
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
		LogArea.log("Thankyou for using iAgility");
		LogArea.log("Script made by Envy");

	}
}