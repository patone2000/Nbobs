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
package NBobs.parameter;

/**
 *  it represents an life parameter of entity
 *
 */
public class LifeParameter {
	private String name="";
	private Object oldValue=null;
	private Object currentValue=null;
	private boolean hasBeenModified=false;

	public LifeParameter(String name) {
		this.name=name;
	}
	public void setValue(Object newValue) {
		this.oldValue=currentValue;
		this.currentValue=newValue;
		if( oldValue!=newValue) {}
		this.hasBeenModified=true;
	}
	public boolean hasbeenModified() {
		return hasBeenModified;
	}
	/** every steps lifeparamter must be reintialized.**/
	public void cleanModification() {
		this.hasBeenModified=false;
	}
	public String getName() {
		return this.name;
	}
}
