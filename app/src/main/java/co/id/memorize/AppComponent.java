package co.id.memorize;

import javax.inject.Singleton;

import co.id.memorize.api.ApiModule;
import co.id.memorize.repository.RepositoryModule;
import dagger.Component;

@Component(
        modules = {
                AppModule.class,
                ApiModule.class,
                RepositoryModule.class
        }
)

@Singleton
public interface AppComponent extends AppGraph {
}
