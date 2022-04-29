package nl.hhs.omnibus.models.exceptions;

import nl.hhs.omnibus.common.Constants;

public class TooManyResultsException extends RuntimeException {
    public TooManyResultsException(int listSize, String queriedOnProperty, String query) {
        super(String.format(Constants.TO_MANY_SEARCH_RESULTS, listSize, queriedOnProperty, query));
    }
}
