package NBobs.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import NBobs.environment.Environment2D;
import NBobs.environment.Position;
import NBobs.knowledge.KnowledgeType;
/** this bob can learn knowledge **/
public class BobVersion2 extends BobVersion1 {

	protected HashMap<String, KnowledgeType> knowledge= new HashMap<String, KnowledgeType>();
	
	public BobVersion2(String name, Environment2D environment2d) {
		super(name, environment2d);
	}

	@Override
	public void doAction() {
		System.out.println(name+": I do an action : I don' t know");
		ArrayList<Position> neighbour=environment.getNeighbour(position);
		//choose neighbour
		Random r = new Random();
		int neighbourIndex = r.nextInt(neighbour.size());
		//choose Entity
		int entityIndex = r.nextInt(neighbour.get(neighbourIndex).getEntities().size());
		KnowledgeType knowledge=neighbour.get(neighbourIndex).getEntities().get(entityIndex).actOn(this);
		this.knowledge.put(""+knowledge, knowledge);
		System.out.println(name+": I do an action on :"+neighbour.get(neighbourIndex).getEntities().get(entityIndex) +" k="+this.knowledge.size());
	}
	@Override
	public void expressKnowledge() {
		System.out.println("************ "+this.getName());
		Iterator<String> iteratork= knowledge.keySet().iterator();
		while (iteratork.hasNext()) {
			String key = (String) iteratork.next();
			
			System.out.println("["+key+"="+knowledge.get(key));
			
		}
		System.out.println("*********************************** ");
	}
}
