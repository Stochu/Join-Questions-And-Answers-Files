import java.util.ArrayList;
import java.util.List;

public class Sorter {

    List<String> questions;

    public Sorter(List<String> questions) {
        this.questions = questions;
    }

    public List<String> sortQuestions() {

        int index = 1;
        List<String> orderedQuestions = new ArrayList<>();

        while (index <= 204) {
            orderedQuestions.addAll(sortQuestionsByNumber(index));
            index++;
        }
        return orderedQuestions;
    }

    private List<String> sortQuestionsByNumber(int index) {
        List<String> orderedQuestions = new ArrayList<>();
        boolean nextQuestionFound = false;
        for (int i = 0; i < questions.size(); i++) {
            String quest = DocumentsJoiner.QUESTION + index;
            if (questions.get(i).equals(quest)) {
                orderedQuestions.add(questions.get(i));
                for (int j = i + 1; j < questions.size(); j++) {
                    if (questions.get(j).startsWith(DocumentsJoiner.QUESTION)) {
                        nextQuestionFound = true;
                        break;
                    } else {
                        orderedQuestions.add(questions.get(j));
                    }
                }
            }
            if (nextQuestionFound) break;
        }
        return orderedQuestions;
    }
}
