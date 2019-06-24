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
package NBobs.experiences;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import NBobs.entities.BobVersion1;
import NBobs.entities.BobVersion3;
import NBobs.environment.Room;


/**
 * Now experience that learn with introspection
 *
 */
public class LaunchExperience5 {

		public static void main(String[] args) throws SlickException {
			Room environment2d=new Room(8,8);
			
			BobVersion1 bob= new BobVersion3("Bob", environment2d);
			environment2d.addAnimated(bob);
			bob.setPosition(environment2d.getPosition(2, 2));
			
			BobVersion1 boby= new BobVersion3("Boby", environment2d);
			boby.setPosition(environment2d.getPosition(2, 3));
			environment2d.addAnimated(boby);
			
			BobVersion1 bober= new BobVersion3("Bober", environment2d);
			bober.setPosition(environment2d.getPosition(3, 3));
			environment2d.addAnimated(bober);
			
			System.out.println(environment2d.toString());
			int pixelWidth=500;
			int pixelHeight=500;
			EnvironmentLauncher eL= new EnvironmentLauncher(environment2d, "Experience5", pixelWidth, pixelHeight,1000);
			new AppGameContainer(eL, pixelWidth,pixelHeight, false).start();

			
		}

		
}

	
