package NBobs.entities;

import java.util.ArrayList;
import java.util.Random;

import NBobs.environment.Environment2D;
import NBobs.environment.Position;

public class BobVersion1 extends BasicObject implements Animated  {

	protected Environment2D environment;

	public BobVersion1(String name,  Environment2D environment2d) {
		super(name);
		this.environment=environment2d;
		System.out.println("Bob: I'm alive");
	}

	@Override
	public String agir(Entity e) {
		return "";
	}

	public ArrayList<Position>getNeighbour(){
		return environment.getNeighbour(getPosition());
	}

	@Override
	public void doAction() {
		System.out.println("Bob: I do an action :");
		ArrayList<Position> neighbour=environment.getNeighbour(position);
		Random r = new Random();
		int valeur = r.nextInt(neighbour.size());
		neighbour.get(valeur).getEntities().get(0).agir(this);
		System.out.println("Bob: I do an action on :"+neighbour.get(valeur));
	}

	@Override
	public void setPosition(Position newPosition) {

		if(this.position!=null) {
			this.position.getEntities().remove(this);
		}
		super.setPosition(newPosition);
		if(!newPosition.getEntities().contains(this)) {
			newPosition.getEntities().add(this);
		}
	}	
	@Override
	public void plan() {

	}

	@Override
	public void setEnviroment(Environment2D evEnvironment2d) {
		this.environment=evEnvironment2d;

	}

}
