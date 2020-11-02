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

package org.kafsemo.titl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.kafsemo.titl.diag.InputRange;

/**
 * Saves the unobfuscated contents in a new file without parse whole itl libarary byte by byte.
 */
public class DecryptLibarary
{
    public static void main(String[] args) throws Exception, IOException, ItlException
    {
        if (args.length != 2) {
            System.err.println("Usage: DecryptLibarary <iTunes Library.itl> <output-directory>");
            System.exit(5);
        }

        File libFile = new File(args[0]);
        File outdir = new File(args[1]);

        outdir.mkdir();

        long fileLength = libFile.length();

        InputStream in = new FileInputStream(libFile);
        try {
            Input di = new InputImpl(in);

            Hdfm hdr = Hdfm.read(di, fileLength);

            OutputStream out = new FileOutputStream(new File(outdir, "decrypted-file"));
            out.write(hdr.fileData);
            out.close();

        } finally {
            in.close();
        }
    }
}


