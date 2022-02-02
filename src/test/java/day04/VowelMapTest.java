package day04;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VowelMapTest {

    @Test
    void  getNumberOfVowelsTest(){
        VowelMap vm = new VowelMap();

        Map<Character,Integer> word1 = vm.getNumberOfVowels("appleTrEE");



        assertEquals(1,word1.get('a'));
        assertEquals(3,word1.get('e'));


    }
}
