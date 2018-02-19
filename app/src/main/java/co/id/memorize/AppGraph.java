package co.id.memorize;

import co.id.memorize.ui.film.FilmFeedFragment;

/**
 * Created by eminartiys on 17/02/18.
 */

public interface AppGraph {

    void inject(App app);

    void inject(FilmFeedFragment filmFeedFragment);
}
