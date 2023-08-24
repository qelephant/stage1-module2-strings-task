package com.epam.mjc;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String input, List<String> delimiters) {
        String regex = "[" + String.join("", delimiters) + "]";
        String[] tokens = input.split(regex);
        
        List<String> result = new ArrayList<>();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                result.add(token);
            }
        }
        
        return result;
    }
}
