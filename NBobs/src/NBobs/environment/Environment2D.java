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

import NBobs.entities.Animated;
import NBobs.entities.Entity;

public interface Environment2D {

	public int getColumns();
	public int getRows();
	//public Position getPosition(int x,int y);
	public ArrayList<Animated> getAnimated();
	public void addAnimated(Animated animated);
	public ArrayList<Position> getNeighbour(Position position);
	
	public void addEntity(int row, int column, Entity e) ;
	public Position getPosition(int row, int column);
}
