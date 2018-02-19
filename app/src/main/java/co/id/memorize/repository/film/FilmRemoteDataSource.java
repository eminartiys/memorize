package co.id.memorize.repository.film;

import java.util.List;

import co.id.memorize.api.service.FilmService;
import co.id.memorize.model.Film;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by eminartiys on 17/02/18.
 */

public class FilmRemoteDataSource implements FilmDataSource {

    private FilmService service;

    public FilmRemoteDataSource(FilmService service) {
        this.service = service;
    }

    @Override
    public void getFilm(final LoadDataCallback callback) {
        service.getFilm().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onDataLoaded(response.body());
                } else {
                    callback.onNoDataLoaded();
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
