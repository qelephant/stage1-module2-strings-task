package com.epam.mjc;

import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> substrings = new ArrayList<>();
        StringBuilder currentSubstring = new StringBuilder();
        for (char c : source.toCharArray()) {
            boolean delimiterFound = false;

            for (String delimiter : delimiters) {
                if (delimiter.indexOf(c) != -1) {
                    if (currentSubstring.length() > 0) {
                      
                        substrings.add(currentSubstring.toString()); 
                        currentSubstring.setLength(0);
                    }
                    delimiterFound = true;
                    break;
                }
            }

            if (!delimiterFound) {
                currentSubstring.append(c);
            }
        }
        if (currentSubstring.length() > 0) {
            substrings.add(currentSubstring.toString());
        }
        return substrings;
    }
}
