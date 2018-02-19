package co.id.memorize.api.service;

import java.util.List;

import co.id.memorize.model.Film;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by eminartiys on 17/02/18.
 */

public interface FilmService {
    @GET("films")
    Call<List<Film>> getFilm();
}
