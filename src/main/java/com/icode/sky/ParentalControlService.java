package com.icode.sky;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kerimc on 23.05.2017.
 */
@RestController
@RequestMapping("/api")
public class ParentalControlService {
    private final Logger log = LoggerFactory.getLogger(ParentalControlService.class);
    private final MovieService movieService;


    public ParentalControlService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/canwatch")
    public ResponseEntity<Boolean> canWatchMovie(@RequestParam(value = "pclStr") String pclStr,
                                                 @RequestParam(value = "movieId") String movieId){
        log.debug("REST request to check movie parental control");
        try {
            ParentalControlLevelEnum pcl = ParentalControlLevelEnum.findPCL(pclStr);
            ParentalControlLevelEnum moviePcl = ParentalControlLevelEnum.findPCL(movieService.getParentalControlLevel(movieId));
            Boolean result = moviePcl.getOrder() <= pcl.getOrder();
            return ResponseEntity.ok().body(result);
        }catch (TitleNotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }catch (TechnicalFailureException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.METHOD_FAILURE);
        }
    }
}
