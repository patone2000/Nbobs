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
package NBobs.knowledge;

import NBobs.entities.Entity;

/**
 * This type of knowledege is to explain that there is nothing to able to do on a given entity
 *
 */
public class Nothing extends KnowledgeType {

	public Nothing(Entity entity) {
		super(entity, "NOTHING");
	}

}
