package nl.hhs.omnibus.common;

import nl.hhs.omnibus.Omnibus;

import java.util.List;

public class UserInputParsing {
    /**
     * Asks the provided question to a User and tries to convert the provided input value to an Integer.
     * When the provided value is not an Integer, the question is repeated until a valid Integer value is provided.
     */
    public static int processUserInputToInt(String question) {
        System.out.print(question);
        String input = Omnibus.USER_INPUT.nextLine();

        try {
            return Integer.parseInt(input);
        }

        // Make the User aware that his value was not a whole number.
        catch (NumberFormatException exception) {
            System.out.println("\tSorry, we could not process your response correctly. Please, provide whole numbers only.\n");

            return processUserInputToInt(question);
        }
    }

    /** Makes the User able to select from the provided options based on their index. */
    public static String processUserInputWithOptions(String question, List<String> acceptedAnswers) {
        StringBuilder formattedQuestion = new StringBuilder(question);

        for (int index = 0; index < acceptedAnswers.size(); index++) {
            formattedQuestion.append(String.format(" (%d)\t%s\n", index, acceptedAnswers.get(index)));
        }
        formattedQuestion.append(Constants.SELECTED_OPTION_LINE);

        int selectedOptionIndex = UserInputParsing.processUserInputToInt(formattedQuestion.toString());

        if (selectedOptionIndex < 0 || selectedOptionIndex > acceptedAnswers.size() - 1) {
            System.out.printf(Constants.SELECTION_OUTSIDE_RANGE_EXCEPTION_MESSAGE, selectedOptionIndex, acceptedAnswers.size() - 1);

            return UserInputParsing.processUserInputWithOptions(question, acceptedAnswers);
        }
        return acceptedAnswers.stream()
            .filter(answer -> acceptedAnswers.indexOf(answer) == selectedOptionIndex)
            .findFirst()
            .orElse(null);
    }
}
