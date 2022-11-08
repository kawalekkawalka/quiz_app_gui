package Models;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

public class Questions {
    private static JSONArray questionsList;

    private static void loadQuestions(){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/questions.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            questionsList = (JSONArray) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String, String> parseQuestionObject(JSONObject elem){
        HashMap<String, String> question = new HashMap<String, String>();
        question.put("correctAnswer", (String) elem.get("odp_poprawna"));
        question.put("content", (String) elem.get("tresc"));
        JSONArray answers = (JSONArray) elem.get("odp");
        question.put("answerA", (String) answers.get(0));
        question.put("answerB", (String) answers.get(1));
        question.put("answerC", (String) answers.get(2));
        question.put("answerD", (String) answers.get(3));
        return question;
    }

    public static HashMap<String, String> getQuestion(){
        if (questionsList == null){
            loadQuestions();
        }
        int number = (int)(Math.random() * questionsList.size());
        return parseQuestionObject((JSONObject) questionsList.get(number));
    }
}
