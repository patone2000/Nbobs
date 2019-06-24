/**NBobs is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    NBobs is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with NBobs.  If not, see <http://www.gnu.org/licenses/>.
 **/
package NBobs.entities;

import java.util.ArrayList;
import java.util.Random;

import NBobs.environment.Environment2D;
import NBobs.environment.Position;
import NBobs.knowledge.KnowledgeType;
import NBobs.parameter.PositionParameter;

/** this bob can learn knowledge and know which parameter has changed**/
public class BobVersion3 extends BobVersion2 {
	PositionParameter positionParameter= new PositionParameter();
	public BobVersion3(String name, Environment2D environment2d) {
		super(name, environment2d);
	}


	@Override
	public void doAction() {
		System.out.println(name+": I have no plan action");
		doRandomAction();
		
	}

	@Override
	public void setPosition(Position position) {
		super.setPosition(position);
		this.positionParameter.setValue(position);
	}

	public void learnKnowledge(KnowledgeType knowledge) {
		if (this.positionParameter.hasbeenModified()) {
			knowledge.addParameterLifeChange(this.positionParameter);
		}

		this.knowledge.put(""+knowledge.toKey(), knowledge);
		System.out.println(" k="+this.knowledge.size());
	}
	
	/** use to discover action when there is no plan
	 *
	 */
	public void doRandomAction() {
		ArrayList<Position> neighbour=environment.getNeighbour(position);
		//choose neighbor
		Random r = new Random();
		int neighbourIndex = r.nextInt(neighbour.size());
		//choose Entity
		int entityIndex = r.nextInt(neighbour.get(neighbourIndex).getEntities().size());
		KnowledgeType knowledge=neighbour.get(neighbourIndex).getEntities().get(entityIndex).actOn(this);
		learnKnowledge(knowledge);
		System.out.println(name+": I do a radom  action on :"+neighbour.get(neighbourIndex).getEntities().get(entityIndex) );
		this.positionParameter.cleanModification();
	}

}
