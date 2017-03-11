package NBobs.environment;

import java.util.ArrayList;
import java.util.List;

import NBobs.entities.Entity;

public class BasicPosition implements Position {

	ArrayList<Entity> entities= new ArrayList<Entity>();

	protected String name="";
	public BasicPosition(String name) {
		this.name=name;
	}
	@Override
	public void setName(String name) {
		this.name=name;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<Entity> getEntities() {
		return this.entities;
	}

	public String toString() {
		String out="[";
		if(getEntities().size()==0) {
			out=out+ name;
		}
		else {

			for (int i=0; i<getEntities().size();i++) {
				out=out+getEntities().get(i).getName()+" ";

			}
		}
		out=out+"]";
		return out;
	}

}
