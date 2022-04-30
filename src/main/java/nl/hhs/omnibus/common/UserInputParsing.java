package nl.hhs.omnibus.common;

import nl.hhs.omnibus.Omnibus;

import java.util.List;
import java.util.Optional;

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

    public static String processUserInputWithOptions(String question, List<String> acceptedAnswers) {
        System.out.print(question);
        String input = Omnibus.USER_INPUT.nextLine();

        Optional<String> chosenAnswer = acceptedAnswers.stream()
            .filter(answer -> answer.equalsIgnoreCase(input))
            .findFirst();

        return chosenAnswer.orElseGet(() -> {
            System.out.printf(Constants.NO_CORRECT_ANSWER, input, acceptedAnswers);

            return processUserInputWithOptions(question, acceptedAnswers);
        });
    }
}
