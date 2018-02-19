package co.id.memorize.repository.film;

import java.util.List;

import co.id.memorize.model.Film;

/**
 * Created by eminartiys on 17/02/18.
 */

public interface FilmDataSource {

    void getFilm(LoadDataCallback callback);

    interface LoadDataCallback {

        void onDataLoaded(List<Film> films);

        void onNoDataLoaded();

        void onError(Throwable e);
    }
}
