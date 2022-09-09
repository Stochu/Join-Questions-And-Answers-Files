import java.util.ArrayList;
import java.util.List;

public class DocumentsJoiner {

    public void joinDocuments(List<String> questions, List<String> answers) {

        int index = 2;
        int pausedQuestionIndex = 0;
        int pausedAnswerIndex = 0;
        List<String> joined = new ArrayList<>();

        while (pausedQuestionIndex != questions.size()) {

            for (int i = pausedQuestionIndex; i < questions.size(); i++) {
                if (questions.get(i).contains("Pytanie nr " + index)) break;
                if (questions.get(i).contains("Pytanie nr " + (index + 1))) {
                    System.out.println("There is problem with question " + index);
                    System.exit(0);
                }
                pausedQuestionIndex++;
                joined.add(questions.get(i));
            }

            for (int i = pausedAnswerIndex; i < answers.size(); i++) {
                if (answers.get(i).equals(index + ".")) break;
                if (answers.get(i).contains((index + 1) + ".")) {
                    System.out.println("There is problem with answer " + index);
                    System.exit(0);
                }
                pausedAnswerIndex++;
                joined.add(answers.get(i));
            }
            index++;
        }
        Converter.convertListToFile(joined);
    }
}