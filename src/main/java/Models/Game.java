package Models;

import java.io.*;
import java.util.*;

public class Game {
    private String username;
    private LinkedHashMap<String, Integer> results;

    public Game(String username){
        this.username = username;
        loadResults();
    }

    public String getUsername() {
        return username;
    }

    public void addResult(int score){
        for(Map.Entry<String, Integer> set: results.entrySet()){
            if (username.equals(set.getKey())){
                if(score > set.getValue()){
                    results.replace(username, score);
                    sortResults();
                    saveResults();
                }
                return;
            }
        }
        results.put(username, score);
        sortResults();
        saveResults();
        getTop5();
    }

    public int checkUserScore(){
        for (Map.Entry<String, Integer> entry :
                results.entrySet()) {
            if(entry.getKey().equals(username)){
                return entry.getValue();
            }
        }
        return 0;
    }

    public LinkedHashMap<String, Integer> getTop5(){
        LinkedHashMap<String, Integer> top5 = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry :
                results.entrySet()) {
            top5.put(entry.getKey(), entry.getValue());
            if (top5.size() == 5){
                break;
            }
        }
        return top5;
    }

    private void loadResults(){
        LinkedHashMap<String, Integer> map
                = new LinkedHashMap<String, Integer>();
        BufferedReader br = null;

        try {

            File file = new File("src/main/resources/results.txt");

            br = new BufferedReader(new FileReader(file));

            String line = null;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(" ");

                String name = parts[0].trim();
                String number = parts[1].trim();

                if (!name.equals("") && !number.equals(""))
                    map.put(name, Integer.valueOf(number));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }

        results = map;
        sortResults();
    }

    private void sortResults(){
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, Collections.reverseOrder());
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : results.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        results = sortedMap;
    }

    private void saveResults(){
        File file = new File("src/main/resources/results.txt");

        BufferedWriter bf = null;

        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, Integer> entry :
                    results.entrySet()) {

                bf.write(entry.getKey() + " "
                        + entry.getValue());
                bf.newLine();
            }

            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                bf.close();
            }
            catch (Exception e) {
            }
        }
    }
}
