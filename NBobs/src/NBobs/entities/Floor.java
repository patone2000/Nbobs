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

import NBobs.knowledge.KnowledgeType;

public class Floor extends BasicObject {

	
	public Floor() {
		super("F");
	}

	public void move (Animated animated) {
			animated.setPosition(this.getPosition());
	}

	@Override
	public KnowledgeType actOn(Entity e) {
		if( e instanceof Animated) {
			move((Animated)e);
			return new KnowledgeType(this, "Move");
		}
		return super.actOn(e);
	}
}
