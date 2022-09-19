import java.util.List;

public class Main {



    public static void main(String[] args) {

        DocumentsJoiner documentsJoiner = new DocumentsJoiner();

        List<String> questions = Converter.convertFileToList("src/main/resources/questions.txt", true);
        List<String> answers = Converter.convertFileToList("src/main/resources/answers.txt", false);

        Sorter sorter = new Sorter(questions);


        List<String> orderedQuestions = sorter.sortQuestions();

        Converter.convertListToFile(orderedQuestions, "src/main/resources/questions.txt");

        documentsJoiner.checkQuestionsOrder(orderedQuestions);
        documentsJoiner.joinDocuments(orderedQuestions, answers);
    }
}
