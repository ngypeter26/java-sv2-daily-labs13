package day04;

import java.util.*;

public class VowelMap {

    private List<Character> vowels = Arrays.asList('a','e','i','o','u');

    public Map<Character,Integer> getNumberOfVowels(String word){
        Map<Character,Integer> result = new LinkedHashMap<>();

        char[] wordChar = word.toLowerCase().toCharArray();
        int actualNr;

        for (Character c : wordChar){
            if (vowels.contains(c)){
                actualNr = !result.containsKey(c) ? 0 : result.get(c);
                result.put(c,actualNr+1);

            }
        }
        return result;
    }
}
