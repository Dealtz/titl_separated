/*
 *  titl - Tools for iTunes Libraries
 *  Copyright (C) 2020 Dealtz
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

package org.kafsemo.titl.tools;

import java.io.File;
import java.io.IOException;

import org.kafsemo.titl.ItlException;
import org.kafsemo.titl.Library;
import org.kafsemo.titl.ParseLibrary;
import org.kafsemo.titl.Track;
import org.kafsemo.titl.diag.InputRange;

/**
 * A simple command-line tool to export all blocks as a comma-separated list.
 *
 * @author Dealtz
 */
public class ExportAllRanges
{
    public static void main(String[] args) throws IOException, ItlException
    {
        if (args.length != 1) {
            System.err.println("Usage: ExportAllRanges <library.itl>");
            System.exit(5);
        }

        Library lib = ParseLibrary.parse(new File(args[0]));
        
        for (InputRange ir : lib.getDiagnostics()) {
            System.out.println(ir.toString());
        }
    }
}
