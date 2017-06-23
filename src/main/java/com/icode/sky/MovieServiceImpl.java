package com.icode.sky;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by kerimc on 23.05.2017.
 */
@Service
public class MovieServiceImpl implements MovieService {

    private final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {
        try{
            Optional<Movie> selectedMovie = Optional.ofNullable(movieRepository.findOne(movieId));
            if(selectedMovie.isPresent()){
                return selectedMovie.map(movie -> movie.getPcl().toString()).get();
            }else{
                throw new TitleNotFoundException();
            }
        }catch (Exception e){
            throw new TechnicalFailureException();
        }
    }
}
