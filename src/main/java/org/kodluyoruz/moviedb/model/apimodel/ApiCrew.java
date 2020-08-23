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
public final class ApiCrew implements Serializable {

    private String name;

    private String job;

    @SerializedName("profile_path")
    private String image;
}
