package co.id.memorize.ui.film;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import co.id.memorize.model.Film;
import co.id.memorize.repository.film.FilmDataSource;
import co.id.memorize.repository.film.FilmRepository;

import static org.mockito.Mockito.verify;

/**
 * Created by eminartiys on 21/02/18.
 */

public class FilmFeedPresenterTest {

    private static final List<Film> ITEMS = Collections.emptyList();
    private static final Throwable THROWABLE = new Throwable();

    @Mock FilmRepository repository;
    @Mock FilmFeedContract.View view;

    private FilmFeedPresenter presenter;

    @Captor
    private ArgumentCaptor<FilmDataSource.LoadDataCallback> loadCallbackArgumentCaptor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        presenter = new FilmFeedPresenter(view, repository);
    }

    @Test
    public void initPresenterToViewTest() {
        presenter = new FilmFeedPresenter(view, repository);

        verify(view).setPresenter(presenter);
    }

    @Test
    public void loadDataToViewTest() {
        presenter.loadData();
        verify(repository).getFilm(loadCallbackArgumentCaptor.capture());

        loadCallbackArgumentCaptor.getValue().onDataLoaded(ITEMS);

        verify(view).setItemToView(ITEMS);

    }

    @Test
    public void loadErrorToViewTest() {
        presenter.start();
        verify(repository).getFilm(loadCallbackArgumentCaptor.capture());

        loadCallbackArgumentCaptor.getValue().onError(THROWABLE);

        verify(view).setErrorToView();

    }
}
