package NBobs.environment;

import java.util.ArrayList;

import NBobs.entities.Animated;
import NBobs.entities.Entity;

public interface Environment2D {

	public int getColumns();
	public int getRows();
	//public Position getPosition(int x,int y);
	public ArrayList<Animated> getAnimated();
	public void addAnimated(Animated animated);
	public ArrayList<Position> getNeighbour(Position position);
	
	public void addEntity(int row, int column, Entity e) ;
	public Position getPosition(int row, int column);
}
