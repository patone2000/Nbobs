package NBobs.experiences;

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
	protected Image aninated=null;

	public EnvironmentLauncher(Environment2D environment2d, String worldName,int pixelWidth,int pixelHeight) {
		super(worldName);
		this.environment2d=environment2d;
		this.pixelWidth=pixelWidth;
		this.pixelHeight=pixelHeight;
		casewidth=pixelWidth/environment2d.getColumns();
		caseheight=pixelHeight/environment2d.getRows();

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
						drawAnimated(g, i, j);
					}
				}


			}
		}


	}
	public void drawAnimated(Graphics g, int row, int column) {
		int currentX= column*casewidth;
		int currentY=row*caseheight;
		//g.drawImage(aninated, currentX, currentY, currentX+casewidth, currentY+caseheight,0,0,162,162);
		g.drawImage(aninated, currentX, currentY, currentX+casewidth, currentY+caseheight,0,0,300,300);

		
	}
	public void drawWall(Graphics g, int row, int column) {
		int currentX= column*casewidth;
		int currentY=row*caseheight;
		//g.drawImage(wall, currentX, currentY, currentX+casewidth, currentY+caseheight,0,0,64,64);
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
		//this.wall= new Image("tileSet/piece.png");
	//	this.aninated= new Image("tileSet/bob.png");
		this.aninated= new Image("tileSet/PNG/07.png");

	}

	@Override
	public void update(GameContainer gameContaier, int arg1) throws SlickException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		everyBodyDoAction();
	//	System.out.println(environment2d);

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
