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
import NBobs.parameter.LifeParameter;

/**
 * Type of knowledge that can been learn by an Entity
 *
 */
public class KnowledgeType {
	private String type="";
	private Class<?> entityType=null;
	String lifeParameter=null;
	public KnowledgeType ( Entity entity,String type) {
		this.type=type;
		this.entityType= entity.getClass();
	}

	@Override
	public String toString() {
		return ""+ entityType.getName()+ " "+type + " "+lifeParameter ;
	}
	public String toKey() {
		return ""+ entityType.getName()+ " "+type;
	}
	/**
	 * in order to know if a type of knowledge can modify a lifeParameter
	 * @param lifeParameter
	 */
	public void addParameterLifeChange(LifeParameter lifeParameter) {
		this.lifeParameter=lifeParameter.getName();
	}
}
