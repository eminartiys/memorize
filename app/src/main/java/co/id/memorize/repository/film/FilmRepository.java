package co.id.memorize.repository.film;

import java.util.List;

import co.id.memorize.model.Film;

/**
 * Created by eminartiys on 17/02/18.
 */

public class FilmRepository implements FilmDataSource {

    private FilmDataSource remoteDataSource;

    public FilmRepository(FilmDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getFilm(final LoadDataCallback callback) {
        remoteDataSource.getFilm(new LoadDataCallback() {
            @Override
            public void onDataLoaded(List<Film> films) {
                callback.onDataLoaded(films);
            }

            @Override
            public void onNoDataLoaded() {
                callback.onNoDataLoaded();
            }

            @Override
            public void onError(Throwable e) {
                callback.onError(e);
            }
        });
    }
}
