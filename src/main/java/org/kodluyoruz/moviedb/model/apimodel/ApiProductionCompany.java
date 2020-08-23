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
public final class ApiProductionCompany implements Serializable {

    private Integer id;

    private String name;

    @SerializedName("logo_path")
    private String image;

}
