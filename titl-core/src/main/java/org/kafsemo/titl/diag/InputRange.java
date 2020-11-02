/*
 *  titl - Tools for iTunes Libraries
 *  Copyright (C) 2008-2011 Joseph Walton
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.kafsemo.titl.diag;

public class InputRange
{
    public final long origin;   // position of hdr.fileData
    public int length;          // block length:[4:7]
    public String type;         // block type:[0:3]
    public Object more;         // for hohm block : hohmType:[8:11] + [] + val
    public String details;      // contents in a lot of types 

    public InputRange(long origin)
    {
        this.origin = origin;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("0x%08x: %s (%4d)", origin, type, length));
        if (more != null) {
            sb.append(" ");
            sb.append(more);
        }
        if (details != null) {
            sb.append(" \"");
            sb.append(details);
            sb.append("\"");
        }
        return sb.toString().replaceAll("(\\r\\n|\\n|\\n\\r)","<br/>");
    }
}
