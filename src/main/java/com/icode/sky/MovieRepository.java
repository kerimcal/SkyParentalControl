package com.icode.sky;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by kerimc on 23.05.2017.
 */
public interface MovieRepository extends MongoRepository<Movie, String> {
}
