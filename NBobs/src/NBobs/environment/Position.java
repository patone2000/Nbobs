package NBobs.environment;

import java.util.List;

import NBobs.entities.Entity;

public interface Position {
	public void setName(String name);
	public String getName();

	public List<Entity> getEntities();
}
