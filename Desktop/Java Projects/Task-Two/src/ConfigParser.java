

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConfigParser {
    private final Map<String, String> map;

    public ConfigParser(String file) throws IOException {
        map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();

        //continue loop when there is still something to read from file
        while(line != null){
            if(line.equals("")) {
                //if a line is an empty string, go to next line
                line = reader.readLine();
                continue;
            }
            if(line.equalsIgnoreCase("[application]")){
                while(line != null && line.length() != 0){
                    //loop while there are still non empty strings or hasn't reached end of line
                    line = reader.readLine();
                    split("application." + line);
                }
            }else{
                split(line);
                line = reader.readLine();
            }
        }
    };

    public String get(String key){
        return map.get(key);
    }

    public void split(String line){
        if (line == null || line.endsWith(".") || line.endsWith(".null")) {
            return;
        }
        //create key-value pair by splitting string at the equal operator
        String[] splitStr = line.split("=");
        // if the map already has the key, do not add to map
        if(map.containsKey(splitStr[0])) return;
        map.put(splitStr[0], splitStr[1]);
    }
}
