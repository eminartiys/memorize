package co.id.memorize;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
final class AppModule {

    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    Context provideContext() {
        return application;
    }
}
