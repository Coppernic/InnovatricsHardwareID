package fr.coppernic.innovatricshid;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;

import fr.coppernic.sdk.utils.debug.L;

/**
 * <p>Created on 06/12/17
 *
 * @author bastien
 */
public class AnswerProvider implements AnalyticsProvider {
    private static final String TAG = "AnswerProvider";
    private static final boolean DEBUG = BuildConfig.DEBUG;

    @Override
    public void logEvent(String id, String name, String type) {
        L.m(TAG, DEBUG, String.format("%s, %s, %s", id, name, type));
        Answers.getInstance().logContentView(new ContentViewEvent()
                                                 .putContentId(id)
                                                 .putContentName(name)
                                                 .putContentType(type));
    }
}
