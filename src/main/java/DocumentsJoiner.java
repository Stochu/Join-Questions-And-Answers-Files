import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DocumentsJoiner {

    public void joinDocuments(List<String> questions, List<String> answers) {

        int index = 2;
        int pausedQuestionIndex = 0;
        int pausedAnswerIndex = 0;
        List<String> joined = new ArrayList<>();

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
        Converter.convertListToFile(joined);
    }
}