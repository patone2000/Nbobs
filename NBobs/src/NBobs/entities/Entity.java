package NBobs.entities;

import NBobs.environment.Position;

public interface Entity {

	public Position getPosition();
	public void setPosition(Position position);
	
	public String agir(Entity e);
	public String getName();
	
}
