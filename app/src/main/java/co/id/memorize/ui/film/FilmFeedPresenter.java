package co.id.memorize.ui.film;

import java.util.List;

import co.id.memorize.model.Film;
import co.id.memorize.repository.film.FilmDataSource;
import co.id.memorize.repository.film.FilmRepository;

/**
 * Created by eminartiys on 17/02/18.
 */

public class FilmFeedPresenter implements FilmFeedContract.Presenter {

    private FilmFeedContract.View view;
    private FilmRepository repository;

    public FilmFeedPresenter(FilmFeedContract.View view, FilmRepository repository) {
        this.view = view;
        this.repository = repository;

        this.view.setPresenter(this);
    }

    @Override
    public void start() {
        loadData();
    }

    @Override
    public void loadData() {
        repository.getFilm(new FilmDataSource.LoadDataCallback() {
            @Override
            public void onDataLoaded(List<Film> films) {
                view.setItemToView(films);
            }

            @Override
            public void onNoDataLoaded() {
                view.setNoDataLoadToView();
            }

            @Override
            public void onError(Throwable e) {
                view.setErrorToView();
            }
        });
    }
}
