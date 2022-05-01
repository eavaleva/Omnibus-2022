package nl.hhs.omnibus.models.exceptions;

import nl.hhs.omnibus.common.Constants;

public class MissingOpponentException extends RuntimeException {
    public MissingOpponentException() {
        super(Constants.MISSING_OPPONENT_EXCEPTION_MESSAGE);
    }
}
