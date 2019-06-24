/**NBobs is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    Foobar is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 **/
package NBobs.experiences;

import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import NBobs.entities.Animated;
import NBobs.entities.Entity;
import NBobs.entities.Floor;
import NBobs.entities.Wall;
import NBobs.environment.Environment2D;
import NBobs.environment.Position;

public class EnvironmentLauncher extends BasicGame implements EnvironmentEngine {

	protected Environment2D environment2d=null;
	protected GameContainer gc;
	protected int pixelWidth=100;
	protected int pixelHeight=100;
	protected int casewidth;
	protected int caseheight;
	protected Image wall=null;
	protected Image floor=null;
	protected Image zombie=null;
	protected ArrayList<Image> aninated=new ArrayList<Image>();
	protected int counterUpdate=0;
	protected  int frequency=2000;

	public EnvironmentLauncher(Environment2D environment2d, String worldName,int pixelWidth,int pixelHeight) {
		super(worldName);
		this.environment2d=environment2d;
		this.pixelWidth=pixelWidth;
		this.pixelHeight=pixelHeight;
		casewidth=pixelWidth/environment2d.getColumns();
		caseheight=pixelHeight/environment2d.getRows();
		

	}
	public EnvironmentLauncher(Environment2D environment2d, String worldName,int pixelWidth,int pixelHeight, int frequency) {
	this(environment2d, worldName, pixelWidth, pixelHeight);
	this.frequency=frequency;
	}
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.setColor( Color.white );
		g.drawString( getTitle(), 0, 0);

		for (int i=0; i<environment2d.getRows();i++) {
			for(int j=0; j<environment2d.getColumns();j++) {
				Position currentPosition=environment2d.getPosition(i, j);
				for (Entity e : currentPosition.getEntities()) {
					if( e instanceof Wall) {
						drawWall(g, i, j);
					}
					if( e instanceof Floor) {
						drawFloor(g, i, j);
					}
				}


			}
		}
		//display bob
		for (int i=0; i<environment2d.getRows();i++) {
			for(int j=0; j<environment2d.getColumns();j++) {
				Position currentPosition=environment2d.getPosition(i, j);
				for (Entity e : currentPosition.getEntities()) {
					if( e instanceof Animated) {
						drawAnimated(g, i, j,(Animated)e);
					}
				}
			}
		}

	}
	public void drawAnimated(Graphics g, int row, int column, Animated e) {
		int currentX= column*casewidth;
		int currentY=row*caseheight;
		if((environment2d.getAnimated().indexOf(e))==-1) {
			g.drawImage(zombie, currentX, currentY, currentX+casewidth, currentY+caseheight,0,0,300,300);
		}
		g.drawImage(aninated.get(environment2d.getAnimated().indexOf(e)), currentX, currentY, currentX+casewidth, currentY+caseheight,0,0,300,300);
	}

	public void drawWall(Graphics g, int row, int column) {
		int currentX= column*casewidth;
		int currentY=row*caseheight;
		g.drawImage(wall, currentX, currentY, currentX+casewidth, currentY+caseheight,0,0,400,400);

	}
	public void drawFloor(Graphics g, int row, int column) {
		int currentX= column*casewidth;
		int currentY=row*caseheight;

		g.setColor( Color.darkGray );
		g.fillRect(currentX, currentY, casewidth, caseheight);
		g.setColor( Color.lightGray );
		g.drawRect(currentX, currentY, casewidth, caseheight);


	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException {
		this.gc=gameContainer;
		this.wall= new Image("tileSet/floor.png");
		this.aninated.add( new Image("tileSet/normal/07.png"));
		this.aninated.add( new Image("tileSet/extra/Devil-2-icon.png"));
		this.aninated.add( new Image("tileSet/extra/Alien-icon.png"));
		this.aninated.add( new Image("tileSet/extra/Red-Skull-icon.png"));
		this.aninated.add( new Image("tileSet/extra/Dracula-icon.png"));
		this.zombie= new Image("tileSet/extra/Zombie-icon.png");


	}

	@Override
	public void update(GameContainer gameContaier, int arg1) throws SlickException {
		try {
			Thread.sleep(frequency);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		everyBodyDoAction();
		if( counterUpdate%5==0) {
			displayKnowledge();
		}
		counterUpdate++;

	}

	private void displayKnowledge() {
		for (Animated animated : environment2d.getAnimated()) {
			animated.expressKnowledge();
		}
	}
	@Override
	public void keyReleased(int key, char c) {
		if (Input.KEY_ESCAPE == key) {
			this.gc.exit();
		}
	}
	@Override
	public void everyBodyDoAction() {
		for (Animated animated : environment2d.getAnimated()) {
			animated.doAction();
		}
	}
	@Override
	public void runIA() {
		try {
			while(true) {
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
