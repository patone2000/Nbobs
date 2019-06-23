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

import NBobs.entities.Floor;
import NBobs.entities.Wall;

/**
 * Create a environement 2D that is build with wall and Floors
 * @author Patrick
 *
 */
public class Room extends BasicEnvironment2D {

	public Room(int row, int column) {
		super(row, column);
		
		for(int i=0; i<getColumns(); i++) {
			for (int j=0; j<getRows(); j++) {
				if (i ==0 || j==0 ||i==getColumns()-1||j==getRows()-1) {
					Wall wall= new Wall();
					this.addEntity(i, j,wall);
				}
				else {
					Floor floor= new Floor();
					this.addEntity(i, j,floor);
				}
			}
		}
	}

}
