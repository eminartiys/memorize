package co.id.memorize.ui.film;

import java.util.List;

import co.id.memorize.BasePresenter;
import co.id.memorize.BaseView;
import co.id.memorize.model.Film;

/**
 * Created by eminartiys on 17/02/18.
 */

public class FilmFeedContract {

    interface View extends BaseView<Presenter> {

        void setItemToView(List<Film> list);

        void setNoDataLoadToView();

        void setErrorToView();
    }

    interface Presenter extends BasePresenter {

        void loadData();
    }
}
