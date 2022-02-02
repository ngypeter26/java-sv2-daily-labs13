package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.*;

public class Competition {
    private Map<String, List<String>> answers = new LinkedHashMap<>();
    private String solution;

    public Map<String, List<String>> getAnswers() {
        return answers;
    }

    public String getSolution() {
        return solution;
    }

    public void read(Path path) {
        String line;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            solution = reader.readLine();
            while ((line = reader.readLine()) != null) {
                parseLine(line);
            }
        }
        catch(IOException ioe){
            throw new IllegalArgumentException("Wrong filename");
        }



    }

    private void parseLine(String line) {
        String[] fields = line.split(" ");
        if (fields.length != 2) {
            throw new IllegalArgumentException("Invalid line: " + line);
        }
        String groupName = fields[0];
        String answer = fields[1];
        addAnswer(groupName, answer);
    }

    private void addAnswer(String groupName, String answer) {
       if (answers.containsKey(groupName)){
           answers.get(groupName).add(answer);
       }else{
           List<String> answerList = new ArrayList<>(Arrays.asList(answer));
           answers.put(groupName,answerList);
       }
    }

    public boolean isAnswerCorrect(String group, int question){
        if (!answers.containsKey(group)){
            throw new IllegalArgumentException("Wrong group name");
        }
        if (question<1 || question>5){
            throw new IllegalArgumentException("Wrong question number");
        }
        String actualAnswer = answers.get(group).get(question-1);
        String actualSolution = Character.toString(solution.charAt(question-1));
        return actualAnswer.equals(actualSolution);
    }

    public int correctTest(String group){
        int sum = 0;
        for (int i = 1; i<6; i++){
            sum += isAnswerCorrect(group,i) ? i : 0;
        }
        return sum;
    }

    public String getWinner(){
        String winner = null;
        int maxPoint = 0;
        int actualPoint = 0;

        for (String group : answers.keySet()){
            actualPoint =  correctTest(group);
            if (actualPoint > maxPoint){
                maxPoint = actualPoint;
                winner = group;
            }
        }
        return winner;
    }



}
