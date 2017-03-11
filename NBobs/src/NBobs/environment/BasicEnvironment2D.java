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
import NBobs.environment.BasicPosition;
import NBobs.environment.Environment2D;
import NBobs.environment.Position;

public class BasicEnvironment2D implements Environment2D {

	public Position[][] map=null;
	protected int row;
	protected int column;
	protected ArrayList<Animated> animatedList= new ArrayList<Animated>();

	public BasicEnvironment2D(int row, int column) {
		this.map= new Position[row] [column];
		this.row=row;
		this.column=column;
		for (int i=0; i<row;i++) {
			for(int j=0; j<column;j++) {
				map[i][j]= new BasicPosition("P"+i+"_"+j);
			}
		}
	}

	public String toString() {
		String out="";
		for (int i=0; i<row;i++) {
			for(int j=0; j<column;j++) {
				out= out+" "+ map[i][j];
			}
			out=out+'\n';
		}
		return out;
	}

//	@Override
//	public Position getPosition(int x, int y) {
//		return map[x][y];
//	}

	@Override
	public int getColumns() {
		return column;
	}

	@Override
	public int getRows() {
		return row;
	}

	@Override
	public ArrayList<Animated> getAnimated() {
		return animatedList;
	}

	@Override
	public void addAnimated(Animated animated) {
		animatedList.add(animated);
		
	}

	@Override
	public ArrayList<Position> getNeighbour(Position position) {
		ArrayList<Position> neighbour=new ArrayList<Position>();
		int currentx=0;
		int currenty=0;
		
		Position possiblePosition=null;
		possiblePosition=map[currentx][currenty];
		while(!position.equals(possiblePosition)&& currenty<row) {
			currentx++;
			if (currentx==column) {
				currentx=0;
				currenty++;
			}
			possiblePosition=map[currentx][currenty];
		}
		if(currentx==0) {
			if( currenty==0) {
				neighbour.add(map[0][1]);
				neighbour.add(map[1][1]);
				neighbour.add(map[1][0]);
				return neighbour;
			}
			if( currenty==row-1) {
				neighbour.add(map[0][row-1]);
				neighbour.add(map[1][row-2]);
				neighbour.add(map[1][row-2]);
				return neighbour;
			}
		}
		if( currentx==column-1) {
			if( currenty==0) {
				neighbour.add(map[column-2][0]);
				neighbour.add(map[column-2][0]);
				neighbour.add(map[column-1][1]);
				return neighbour;
			}
			if( currenty==row-1) {
				neighbour.add(map[0][row-1]);
				neighbour.add(map[1][row-2]);
				neighbour.add(map[1][row-2]);
				return neighbour;
			}
		}
		neighbour.add(map[currentx-1][currenty-1]);
		neighbour.add(map[currentx-1][currenty-1]);
		neighbour.add(map[currentx+1][currenty-1]);
		neighbour.add(map[currentx-1][currenty]);
		neighbour.add(map[currentx+1][currenty]);
		neighbour.add(map[currentx-1][currenty+1]);
		neighbour.add(map[currentx-1][currenty+1]);
		neighbour.add(map[currentx+1][currenty+1]);
		
		
		return neighbour;
	}

	@Override
	public void addEntity(int row, int column, Entity e) {
		map[row][column].getEntities().add(e);
		e.setPosition(map[row][column]);
		
	}

	@Override
	public Position getPosition(int row, int column) {
		return map[row][column];
				
	}
	
}
