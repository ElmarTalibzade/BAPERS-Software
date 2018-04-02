/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

/**
 * A static class for calling common functions such as ID generation.
 * @author Elmar Talibzade
 */
public class Utils {
    
    /**
     * Generates a unique string of letters
     * @param length Length of a randomly generated string
     * @return Randomly generated string
     */
    public String genCodeId(int length)
    {
        throw new UnsupportedOperationException();
    }
    
    public static String splitCamelCase(String s) {
        return s.replaceAll(
            String.format("%s|%s|%s",
            "(?<=[A-Z])(?=[A-Z][a-z])",
            "(?<=[^A-Z])(?=[A-Z])",
            "(?<=[A-Za-z])(?=[^A-Za-z])"
            ), " "
        );
    }
}