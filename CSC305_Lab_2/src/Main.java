
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import person.Award;

import person.Dignitary;

public class Main {
    public static void main(String[] args) {
        String filePath = "CSC305_Lab_2\\input1.json";
        List<Dignitary> dignitaries = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);

            Dignitary dignitary = parseDignitary(jsonObject);
            dignitaries.add(dignitary);

            for(Dignitary d : dignitaries) {
                System.out.println(d);
                System.err.println("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
    
    private static Dignitary parseDignitary(JSONObject jsonObject) {
        try {        
            String name = jsonObject.getString("name");

            List<String> knownFor = new ArrayList<>();
            JSONArray knownForArray = jsonObject.getJSONArray("knownFor");
            for(int j = 0; j <knownForArray.length(); j++) {
                knownFor.add(knownForArray.getString(j));
            }

            List<Award> awards = new ArrayList<>();
            JSONArray awardsArray = jsonObject.getJSONArray("awards");
            for(int j =0; j<awardsArray.length(); j++) {
                JSONObject awardObj = awardsArray.getJSONObject(j);
                String awardName = awardObj.getString("name");
                int awardYear = awardObj.getInt("year");
                awards.add(new Award(awardName, awardYear));
            }
            return new Dignitary(name, knownFor, awards);
        } catch(JSONException e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
            return null;
        }
    }
}

