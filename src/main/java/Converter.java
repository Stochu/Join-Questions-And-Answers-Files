import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<String> convertFileToList(String fileName) {

        List<String> lines = new ArrayList<>();

        try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = file.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void convertListToFile(List<String> fileList) {

        try (FileOutputStream finalDocument = new FileOutputStream("src/main/resources/joined.txt", false);
                OutputStreamWriter osw = new OutputStreamWriter(finalDocument, StandardCharsets.UTF_8);
                BufferedWriter writer = new BufferedWriter(osw)) {

            for (String s : fileList) {
                writer.append(s).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
