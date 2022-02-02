package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompetitionTest {


    @Test
    void readTest(){
        Path path = Paths.get("src/main/resources/result.txt");

        Competition competition = new Competition();
        competition.read(path);

        assertEquals("ABACD",competition.getSolution());

        List<String> expected = Arrays.asList("X","B","A","X","D");
        assertEquals(expected,competition.getAnswers().get("AH2"));
    }

    @Test
    void readWrongFileNameTest(){
        Path path = Paths.get("src/main/resources/result1.txt");

        Competition competition = new Competition();

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                                            () -> competition.read(path));

        assertEquals("Wrong filename",iae.getMessage());
    }

    @Test
    void readWrongFileStructureTest(){
        Path path = Paths.get("src/main/resources/result2.txt");

        Competition competition = new Competition();

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> competition.read(path));

        assertEquals("Invalid line: AB123 C fawewawe",iae.getMessage());
    }


    @Test
    void isAnswerCorrectTest(){
        Path path = Paths.get("src/main/resources/result.txt");

        Competition competition = new Competition();
        competition.read(path);

        assertTrue(competition.isAnswerCorrect("AH2",2));
        assertFalse(competition.isAnswerCorrect("BD452",5));

        IllegalArgumentException iae1 = assertThrows(IllegalArgumentException.class,
                () -> competition.isAnswerCorrect("  ",5));

        assertEquals("Wrong group name",iae1.getMessage());

        IllegalArgumentException iae2 = assertThrows(IllegalArgumentException.class,
                () -> competition.isAnswerCorrect("BD452",0));

        assertEquals("Wrong question number",iae2.getMessage());
    }

    @Test
    void getWinnerTest(){
        Path path = Paths.get("src/main/resources/result.txt");

        Competition competition = new Competition();
        competition.read(path);

        assertEquals("GH1234",competition.getWinner());
    }



}
