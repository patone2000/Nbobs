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
package NBobs.experiences;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import NBobs.entities.BobVersion1;
import NBobs.environment.Room;


public class LaunchExperience1 {


	

		public static void main(String[] args) throws SlickException {
			Room environment2d=new Room(10,10);
			
			
			BobVersion1 bob= new BobVersion1("Bob", environment2d);
			bob.setPosition(environment2d.getPosition(2, 2));
			environment2d.addAnimated(bob);
			
			System.out.println(environment2d.toString());
			int pixelWidth=500;
			int pixelHeight=500;
			EnvironmentLauncher eL= new EnvironmentLauncher(environment2d, "Experience1", pixelWidth, pixelHeight);
			new AppGameContainer(eL, pixelWidth,pixelHeight, false).start();

			
		}

		
}

	
