import java.util.ArrayList;
import java.util.List;

public class DocumentsJoiner {

    List<String> joined;

    public DocumentsJoiner() {
        joined = new ArrayList<>();
    }

    public void joinDocuments(List<String> questions, List<String> answers) {

        int index = 2;
        int pausedQuestionIndex = 0;
        int pausedAnswerIndex = 0;

        while (pausedQuestionIndex != questions.size()) {

            pausedQuestionIndex = addNextQuestionToList(questions, index, pausedQuestionIndex);
            pausedAnswerIndex = addNextAnswerToList(answers, index, pausedAnswerIndex);

            index++;
        }
        Converter.convertListToFile(joined);
    }

    private int addNextAnswerToList(List<String> answers, int index, int pausedAnswerIndex) {
        for (int i = pausedAnswerIndex; i < answers.size(); i++) {
            if (answers.get(i).equals(index + ".")) break;
            if (answers.get(i).equals((index + 1) + ".")) {
                System.out.println("There is problem with answer " + index);
            }
            pausedAnswerIndex++;
            joined.add(answers.get(i));
        }
        return pausedAnswerIndex;
    }

    private int addNextQuestionToList(List<String> questions, int index, int pausedQuestionIndex) {
        for (int i = pausedQuestionIndex; i < questions.size(); i++) {
            if (questions.get(i).contains("Pytanie nr " + index)) break;
            if (questions.get(i).contains("Pytanie nr " + (index + 1))) {
                System.out.println("There is problem with question " + index);
            }
            pausedQuestionIndex++;
            joined.add(questions.get(i));
        }
        return pausedQuestionIndex;
    }
}