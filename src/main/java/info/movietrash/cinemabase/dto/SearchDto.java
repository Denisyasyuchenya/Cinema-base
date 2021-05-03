package info.movietrash.cinemabase.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {

    private String query;                   //Pass a text query to search. This value should be URI encoded.
//    private String lang;                    //default: en-US
    private boolean includeAdult;

}
