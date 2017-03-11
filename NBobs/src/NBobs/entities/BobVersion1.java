/**NBobs is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    Foobar is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
**/
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
