import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class DocumentsJoiner {

    List<String> joined;
    public static final String QUESTION = "Nr ";

    public DocumentsJoiner() {
        joined = new ArrayList<>();
    }

    public void joinDocuments(List<String> questions, List<String> answers) {

        int index = 2;
        int pausedQuestionIndex = 0;
        int pausedAnswerIndex = 0;

        while (pausedAnswerIndex != answers.size()) {


            pausedQuestionIndex = addNextQuestionToList(questions, index, pausedQuestionIndex);
            pausedAnswerIndex = addNextAnswerToList(answers, index, pausedAnswerIndex);

            index++;
        }
        Converter.convertListToFile(joined, "src/main/resources/2013_wiosna.txt");
    }

    private int addNextAnswerToList(List<String> answers, int index, int pausedAnswerIndex) {
        for (int i = pausedAnswerIndex; i < answers.size(); i++) {
            if (answers.get(i).trim().equals(index + "")) {
                joined.add("\n");
                break;
            }
            if (answers.get(i).equals((index + 1) + "")) out.println("There is missing answer " + index);
            // If there is two answers in row with text in the same line as numbers
            if (answers.get(i).startsWith(index + " ")) out.println("There is problem with answer " + index);
            pausedAnswerIndex++;
            joined.add(answers.get(i));
        }
        return pausedAnswerIndex;
    }

    private int addNextQuestionToList(List<String> questions, int index, int pausedQuestionIndex) {
        for (int i = pausedQuestionIndex; i < questions.size(); i++) {
            if (questions.get(i).contains(QUESTION + index) || questions.get(i).equals("" + index)) {
                joined.add("\n");
                break;
            }
            if (questions.get(i).contains(QUESTION + (index + 1))) out.println("There is missing question " + index);

            pausedQuestionIndex++;
            joined.add(questions.get(i));
        }
        return pausedQuestionIndex;
    }

    public void checkQuestionsOrder(List<String> questions) {
        int index = 1;
        for (String question : questions) {
            if (question.contains(QUESTION)) {
                if (!question.contains("" + index)) {
                    out.println("There is problem with question " + index);
                }
                index++;
            }
        }
    }
}