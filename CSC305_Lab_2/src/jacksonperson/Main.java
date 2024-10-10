package jacksonperson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File; 

public class Main {
    public static void main(String[] args) {
        String filePath = "CSC305_Lab_2\\input2.json";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Dignitary dignitary = objectMapper.readValue(new File(filePath), Dignitary.class);
            System.out.println(dignitary);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
