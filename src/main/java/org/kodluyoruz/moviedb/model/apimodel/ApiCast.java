package org.kodluyoruz.moviedb.model.apimodel;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public final class ApiCast implements Serializable {

    private String character;

    private String name;

    private Integer order;

    @SerializedName("profile_path")
    private String image;

}
