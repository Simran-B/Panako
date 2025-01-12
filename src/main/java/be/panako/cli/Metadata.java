/***************************************************************************
 *                                                                          *
 * Panako - acoustic fingerprinting                                         *
 * Copyright (C) 2014 - 2022 - Joren Six / IPEM                             *
 *                                                                          *
 * This program is free software: you can redistribute it and/or modify     *
 * it under the terms of the GNU Affero General Public License as           *
 * published by the Free Software Foundation, either version 3 of the       *
 * License, or (at your option) any later version.                          *
 *                                                                          *
 * This program is distributed in the hope that it will be useful,          *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of           *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            *
 * GNU Affero General Public License for more details.                      *
 *                                                                          *
 * You should have received a copy of the GNU Affero General Public License *
 * along with this program.  If not, see <http://www.gnu.org/licenses/>     *
 *                                                                          *
 ****************************************************************************
 *    ______   ________   ___   __    ________   ___   ___   ______         *
 *   /_____/\ /_______/\ /__/\ /__/\ /_______/\ /___/\/__/\ /_____/\        *
 *   \:::_ \ \\::: _  \ \\::\_\\  \ \\::: _  \ \\::.\ \\ \ \\:::_ \ \       *
 *    \:(_) \ \\::(_)  \ \\:. `-\  \ \\::(_)  \ \\:: \/_) \ \\:\ \ \ \      *
 *     \: ___\/ \:: __  \ \\:. _    \ \\:: __  \ \\:. __  ( ( \:\ \ \ \     *
 *      \ \ \    \:.\ \  \ \\. \`-\  \ \\:.\ \  \ \\: \ )  \ \ \:\_\ \ \    *
 *       \_\/     \__\/\__\/ \__\/ \__\/ \__\/\__\/ \__\/\__\/  \_____\/    *
 *                                                                          *
 ****************************************************************************
 *                                                                          *
 *                              Panako                                      *
 *                       Acoustic Fingerprinting                            *
 *                                                                          *
 ****************************************************************************/

package be.panako.cli;

import be.panako.strategy.Strategy;

import java.io.File;
import java.util.List;

/**
 * A command line application to show the stored meta-data for a media file.
 */
public class Metadata extends Application{

    @Override
    public void run(String... args) {
        Strategy strategy = Strategy.getInstance();
        List<File> files = getFilesFromArguments(args);

        for(File f : files) {
            if(strategy.hasResource(f.getAbsolutePath()))
                System.out.println(strategy.metadata(f.getAbsolutePath()));
            else
                System.out.println(f.getName() + " is not indexed.");
        }
    }

    @Override
    public String description() {
        return "Print the stored meta-data for media files";
    }

    @Override
    public String synopsis() {
        return "[audio_file...]";
    }

    @Override
    public boolean needsStorage() {
        return true;
    }

    @Override
    public boolean writesToStorage() {
        return false;
    }
}
