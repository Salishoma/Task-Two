

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

//public class ConfigParser {
//    private final Map<String, String> map;
//
//
//    public ConfigParser() throws IOException {
//        this("./config.txt");
//    };
//
//    public ConfigParser(String file) throws IOException {
//        System.out.println(file);
//        map = new HashMap<>();
//        BufferedReader reader = new BufferedReader(new FileReader(file));
//        String line = reader.readLine();
//        while(line != null){
//            if(line.equals("")) {
//                line = reader.readLine();
//                continue;
//            }
//            boolean isNull = false;
//            if(line.equalsIgnoreCase("[application]")){
//                while(line != null && line.length() != 0){
//                    line = reader.readLine();
////                    if(line.equals("")) break;
//                   isNull = split("application." + line, false);
//                   if(isNull) break;
//                }
//            }else{
//                split(line, isNull);
//                line = reader.readLine();
//            }
//        }
//    };
//
//    public String get(String key){
//        return map.get(key);
//    }
//
//    public boolean split(String line, boolean isNull){
//        System.out.println(map);
//        System.out.println(line);
//        if(line == null) {
//            isNull = true;
//            return isNull;
//        }
//        String[] splitStr = line.split("=");
//        if(map.containsKey(splitStr[0])) return !isNull;
//        map.put(splitStr[0], splitStr[1]);
//        System.out.println(map);
//        return !isNull;
//    }
//}


//public class ConfigParser {
//    private final Map<String, String> configMap;
//
//    /**
//     * default no argument constructor which calls the constructor with argument parsing a default filename to it
//     *
//     */
//    public ConfigParser(){
//        this("./src/config.txt");
//    }
//
//    /**
//     * constructor with String parameter to represent the file | config path file.
//     * the constructor calls BufferedReader to read each line from the config file.
//     * and the line, if need be, is modified to fit.
//     * @param file
//     */
//    public ConfigParser(String file) {
//        configMap = new HashMap<>();
//        String line;
//        try(BufferedReader reader = new BufferedReader(new FileReader(file));){
//            while((line = reader.readLine()) != null){
//                if (line.equals("")) continue;
//                else if (line.equalsIgnoreCase("[application]")){
//                    while (!(line = reader.readLine()).equals("")) {
//                        line = "application." + line;
//                        mapLine(line);
//                    }
//                    continue;
//                }
//                mapLine(line);
//            }
//        } catch (NullPointerException e){}
//        catch (IOException e){}
//    }
//
//    /**
//     * get() returns the value of mapKey, which is assumed to be valid key
//     * @param mapKey
//     * @return
//     */
//    public String get(String mapKey){
//        return configMap.get(mapKey);
//    }
//
//    /**
//     * mapLine takes each line from the config file and breaks to form a key value pair
//     * each pair is then put into configMap map for storage.
//     * @param line
//     */
//    private void mapLine(String line) {
//        String [] keyValue = line.split("=");
//        if (configMap.containsKey(keyValue[0])) return;
//        configMap.put(keyValue[0], keyValue[1]);
//    }
//}