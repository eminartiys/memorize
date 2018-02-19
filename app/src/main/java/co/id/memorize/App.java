package co.id.memorize;

import android.app.Application;
import android.content.Context;

/**
 * Created by eminartiys on 17/02/18.
 */

public final class App extends Application {

    private AppGraph appGraph;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Dagger
        appGraph = Injector.create(this);
        appGraph.inject(this);

    }

    AppGraph getInjector() {
        return appGraph;
    }
}
