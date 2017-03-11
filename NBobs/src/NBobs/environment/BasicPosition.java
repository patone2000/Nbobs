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
