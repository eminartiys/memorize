package co.id.memorize.repository;

import javax.inject.Singleton;

import co.id.memorize.api.service.FilmService;
import co.id.memorize.repository.film.FilmRemoteDataSource;
import co.id.memorize.repository.film.FilmRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by eminartiys on 17/02/18.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    FilmRemoteDataSource provideFilmRemoteDataSource(FilmService filmService) {
        return new FilmRemoteDataSource(filmService);
    }

    @Provides
    @Singleton
    FilmRepository provideFilmRepository(FilmRemoteDataSource filmRemoteDataSource) {
        return new FilmRepository(filmRemoteDataSource);
    }
}
