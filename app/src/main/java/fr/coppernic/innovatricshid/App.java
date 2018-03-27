package fr.coppernic.innovatricshid;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;

import io.fabric.sdk.android.Fabric;

/**
 * Created by benoist on 27/03/18.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Set up Crashlytics, disabled for debug builds
        Crashlytics crashlyticsKit = new Crashlytics.Builder()
                .core(new CrashlyticsCore.Builder().disabled(false).build())
                .build();
        // Initialize Fabric with the debug-disabled crashlytics.
        Fabric.with(this, crashlyticsKit);
    }
}
