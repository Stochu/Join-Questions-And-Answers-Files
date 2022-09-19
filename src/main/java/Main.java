import java.util.List;

public class Main {

    public static void main(String[] args) {


        connectQuestionsAndAnswers();
        extractQuestionsFromJoinedFile();
    }

    private static void extractQuestionsFromJoinedFile() {
        List<String> joined = Converter.convertFileToList("src/main/resources/joined_to_extract.txt", false);
        Filter filter = new Filter(joined);
        List<String> questions = filter.extractQuestions();
        Converter.convertListToFile(questions, "src/main/resources/extracted_questions.txt");
    }

    private static void connectQuestionsAndAnswers() {
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
