package com.icode.sky;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by kerimc on 23.05.2017.
 */
@Document(collection = "movie")
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @NotNull
    @Field("status")
    private ParentalControlLevelEnum pcl;

    public ParentalControlLevelEnum getPcl() {
        return pcl;
    }

    public void setPcl(ParentalControlLevelEnum pcl) {
        this.pcl = pcl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", pcl=" + pcl +
                '}';
    }
}
