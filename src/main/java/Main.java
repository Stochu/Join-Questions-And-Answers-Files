import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DocumentsJoiner documentsJoiner = new DocumentsJoiner();
        List<String> joined = new ArrayList<>();

        List<String> questions = documentsJoiner.convertFileToList("src/main/resources/questions.txt");
        List<String> answers = documentsJoiner.convertFileToList("src/main/resources/answers.txt");

        int index = 2;
        int pausedQuestionIndex = 0;
        int pausedAnswerIndex = 0;

        while (pausedQuestionIndex != questions.size()) {

            for (int i = pausedAnswerIndex; i < answers.size(); i++) {
                if (answers.get(i).contains("Pytanie nr " + index)) break;
                pausedAnswerIndex++;
                joined.add(answers.get(i));
            }

            for (int i = pausedQuestionIndex; i < questions.size(); i++) {
                if (questions.get(i).equals(index + ".")) break;
                pausedQuestionIndex++;
                joined.add(questions.get(i));
            }
            index++;
        }
        documentsJoiner.convertListToFile(joined);
    }
}
