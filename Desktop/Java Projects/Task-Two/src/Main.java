

import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "" + Paths.get("").toAbsolutePath();
        if(!path.endsWith("/src")){
            path = path +"/src";
        }
        ConfigParser configParser;

        if (args.length == 0 || args[0].equalsIgnoreCase("production")){
            //if no argument or if production is passed to terminal, read config.txt file
            configParser = new ConfigParser(path + "/config.txt");
        } else if (args[0].equalsIgnoreCase("development")){
            //if development argument is passed to terminal, read config.txt.dev file
            configParser = new ConfigParser(path + "/config.txt.dev");
        } else if (args[0].equalsIgnoreCase("staging")){
            //if staging argument is passed to terminal, read config.txt.staging file
            configParser = new ConfigParser(path + "/config.txt.staging");
        } else {
            // if none of the above action is carried out, then illegal argument has been passed, throw exception
            throw new IllegalArgumentException("Invalid parameters passed, Specify: \n" +
                    "\"java Main production\" for production, \"java Main development\" for development, \"java Main staging\" for staging");
        }

        System.out.println(configParser.get("mode"));
    }
}
