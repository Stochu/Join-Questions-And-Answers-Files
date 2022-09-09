import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DocumentsJoiner documentsJoiner = new DocumentsJoiner();

        List<String> questions = Converter.convertFileToList("src/main/resources/questions.txt");
        List<String> answers = Converter.convertFileToList("src/main/resources/answers.txt");

        documentsJoiner.joinDocuments(questions, answers);
    }


}
