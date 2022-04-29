package nl.hhs.omnibus.models.exceptions;

import nl.hhs.omnibus.common.Constants;

public class NoResultsException extends RuntimeException{
    public NoResultsException(String queriedOnProperty, String query) {
        super(String.format(Constants.NO_SEARCH_RESULTS, queriedOnProperty, query));
    }
}
