package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {

        StringTokenizer stringTokenizer = new StringTokenizer(source);
        List<String> list = new ArrayList<>();

        for (int i = 0; stringTokenizer.hasMoreTokens(); i++) {
            list.add(stringTokenizer.nextToken(delimiters.toString()));
        }
        return list;
    }
}
