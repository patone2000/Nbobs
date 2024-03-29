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

import NBobs.environment.Position;
import NBobs.knowledge.KnowledgeType;
import NBobs.knowledge.Nothing;

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
	public KnowledgeType actOn(Entity e) {
		return new Nothing(this);
	}

	@Override
	public String getName() {
		return name;
	}

}
