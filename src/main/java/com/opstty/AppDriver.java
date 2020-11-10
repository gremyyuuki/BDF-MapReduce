package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("districttree", DistrictContainTree.class,
                    "A map/reduce program that tells which districts have trees.");
            programDriver.addClass("kind", Kind.class,
                    "A map/reduce program that calculate the number of trees of each kind.");
            programDriver.addClass("species", Species.class,
                    "A map/reduce program that calculate the number of trees of each species.");
            programDriver.addClass("maxheight", MaxHeight.class,
                    "A map/reduce program that calculate the max height per tree species.");
            programDriver.addClass("sortheight", SortHeight.class,
                    "A map/reduce program that sorts the height from smallest to largest.");
            programDriver.addClass("oldtree", DistrictOldTree.class,
                    "A map/reduce program that finds the district of the oldest tree.");
            programDriver.addClass("districtmosttrees", DistrictMostTrees.class,
                    "A map/reduce program that finds the district with the most trees.");



            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
