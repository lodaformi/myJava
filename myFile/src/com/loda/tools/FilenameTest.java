package com.loda.tools;

import org.apache.commons.io.FilenameUtils;

public class FilenameTest {
    public static void main(String[] args) {
        String name = FilenameUtils.concat("G:/msb/", "a/b/c.txt");
        System.out.println(name);

        boolean yesOrNo = FilenameUtils.equals("a.txt", "a.txt");
        System.out.println(yesOrNo);

        String fname = "G:/msb/software/HBuilderProjects/";
        System.out.println(FilenameUtils.directoryContains(fname,"mashibing010103javascript2"));
//        System.out.println(FilenameUtils.getPrefix(fname));
//        System.out.println(FilenameUtils.getPrefixLength(fname));
//        System.out.println(FilenameUtils.indexOfExtension(fname));
//        System.out.println(FilenameUtils.indexOfLastSeparator(fname));
//        System.out.println(FilenameUtils.isExtension(fname, "mp4", "mp3", "jpg"));
//        System.out.println(FilenameUtils.normalize(fname,true));
//        System.out.println(FilenameUtils.removeExtension(fname));
//        System.out.println(FilenameUtils.separatorsToSystem(fname));
//        System.out.println(FilenameUtils.separatorsToWindows(fname));
//        System.out.println(FilenameUtils.separatorsToUnix(fname));
//        System.out.println(FilenameUtils.wildcardMatch(fname,"*.mp4"));
//        System.out.println(FilenameUtils.wildcardMatch(fname,"*"));
//        System.out.println(FilenameUtils.getBaseName(fname));
//        System.out.println(FilenameUtils.getExtension(fname));
//        System.out.println(FilenameUtils.getPath(fname));
//        System.out.println(FilenameUtils.getFullPath(fname));
//        System.out.println(FilenameUtils.getFullPathNoEndSeparator(fname));
//
//        System.out.println(FilenameUtils.getName(fname));

//        String fname2 = "G:\\a";
//        System.out.println(FilenameUtils.getName(fname2));

    }
}
