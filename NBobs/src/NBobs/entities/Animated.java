package NBobs.entities;

import NBobs.environment.Environment2D;

public interface Animated extends Entity {
	public void doAction();
	public void plan();
	public void setEnviroment(Environment2D evEnvironment2d);

}
