import java.util.ArrayList;
import java.util.List;

public class Filter {

    List<String> joined;

    public Filter(List<String> joined) {
        this.joined = joined;
    }

    public List<String> extractQuestions() {
        int index = 1;
        List<String> questions = new ArrayList<>();

        while (index <= 210) {
            questions.addAll(addQuestion(index));
            index++;
        }
        return questions;
    }

    private List<String> addQuestion(int index) {
        List<String> orderedQuestions = new ArrayList<>();
        boolean answerFound = false;
        for (int i = 0; i < joined.size(); i++) {
            String quest = DocumentsJoiner.QUESTION + index;
            if (joined.get(i).trim().equals(quest) || joined.get(i).trim().equals(quest + ".")) {
                orderedQuestions.add(joined.get(i));
                for (int j = i + 1; j < joined.size(); j++) {
                    if (joined.get(j).equals("" + index)) {
                        answerFound = true;
                        break;
                    } else {
                        orderedQuestions.add(joined.get(j));
                    }
                }
            }
            if (answerFound) break;
        }
        return orderedQuestions;
    }
}
