package NBobs.entities;

import NBobs.environment.Position;

public class BasicObject implements Object {
	protected Position position=null;
	protected String name=null;
	public BasicObject(String name) {
		this.name=name;
	}
	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(Position position) {
		this.position=position;

	}

	@Override
	public String agir(Entity e) {
		return "";
	}

	@Override
	public String getName() {
		return name;
	}

}
