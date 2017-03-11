package Nbob.experiences;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import NBobs.entities.BobVersion1;
import NBobs.entities.Floor;
import NBobs.entities.Wall;
import NBobs.environment.BasicEnvironment2D;
import NBobs.environment.Environment2D;
import NBobs.experiences.EnvironmentLauncher;


public class LaunchExperience1 {


	

		public static void main(String[] args) throws SlickException {
			Environment2D environment2d=new BasicEnvironment2D(5,5);
			
			Wall w1= new Wall();
			environment2d.addEntity(0, 0,w1);
			Wall w2= new Wall();
			environment2d.addEntity(0, 1,w2);
			Wall w3= new Wall();
			environment2d.addEntity(0, 2,w3);
			Wall w4= new Wall();
			environment2d.addEntity(0, 3,w4);
			Wall w5= new Wall();
			environment2d.addEntity(0, 4,w5);
			
			Wall w11= new Wall();
			environment2d.addEntity(1, 0,w11);
			Floor w12= new Floor();
			environment2d.addEntity(1, 01,w12);
			Floor w13= new Floor();
			environment2d.addEntity(01, 02,w13);
			Floor w14= new Floor();
			environment2d.addEntity(01, 03,w14);
			Wall w15= new Wall();
			environment2d.addEntity(01, 04,w15);
			
			Wall w21= new Wall();
			environment2d.addEntity(02, 0,w21);
			Floor w22= new Floor();
			environment2d.addEntity(02, 01,w22);
			Floor w23= new Floor();
			environment2d.addEntity(02, 02,w23);
			Floor w24= new Floor();
			environment2d.addEntity(02, 03,w24);
			Wall w25= new Wall();
			environment2d.addEntity(02, 04,w25);
			
			Wall w31= new Wall();
			environment2d.addEntity(03, 0,w31);
			Floor w32= new Floor();
			environment2d.addEntity(03, 01,w32);
			Floor w33= new Floor();
			environment2d.addEntity(03, 02,w33);
			Floor w34= new Floor();
			environment2d.addEntity(03, 03,w34);
			Wall w35= new Wall();
			environment2d.addEntity(03, 04,w35);
			
			Wall w41= new Wall();
			environment2d.addEntity(04, 0,w41);
			Wall w42= new Wall();
			environment2d.addEntity(04, 01,w42);
			Wall w43= new Wall();
			environment2d.addEntity(04, 02,w43);
			Wall w44= new Wall();
			environment2d.addEntity(04, 03,w44);
			Wall w45= new Wall();
			environment2d.addEntity(04, 04,w45);
			
			BobVersion1 bob= new BobVersion1("Bob", environment2d);
			environment2d.addEntity(2, 2,bob);
			environment2d.addAnimated(bob);
			
			System.out.println(environment2d.toString());
			int pixelWidth=500;
			int pixelHeight=500;
			EnvironmentLauncher eL= new EnvironmentLauncher(environment2d, "Experience1", pixelWidth, pixelHeight);
			new AppGameContainer(eL, pixelWidth,pixelHeight, false).start();

			
		}

		
}

	
