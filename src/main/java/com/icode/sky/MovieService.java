package com.icode.sky;

/**
 * Created by kerimc on 23.05.2017.
 */
public interface MovieService {
    String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
