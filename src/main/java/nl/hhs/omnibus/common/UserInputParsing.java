package nl.hhs.omnibus.common;

import nl.hhs.omnibus.Omnibus;

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
}
