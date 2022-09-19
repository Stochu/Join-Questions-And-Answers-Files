import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<String> convertFileToList(String fileName, boolean isQuestion) {

        List<String> lines = new ArrayList<>();

        try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = file.readLine()) != null) {
                if (line.trim().matches("[0-9]+") && isQuestion) {
                    lines.add("Nr " + line);
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void convertListToFile(List<String> fileList, String filename) {

        try (FileOutputStream finalDocument = new FileOutputStream(filename, false);
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
