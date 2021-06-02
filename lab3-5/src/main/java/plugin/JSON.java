package plugin;

import org.json.XML;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JSON implements IPlugin {
    @Override
    public void action(String extension) {
        try {
            List<String> reading = Files.readAllLines(Paths.get(IPlugin.srcName(extension)));
            StringBuilder builder = new StringBuilder();
            for (String s : reading) {
                builder.append(s);
            }
            FileWriter fWriter = new FileWriter("output.json", false);
            fWriter.write(XML.toJSONObject(builder.toString()).toString());
            fWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
