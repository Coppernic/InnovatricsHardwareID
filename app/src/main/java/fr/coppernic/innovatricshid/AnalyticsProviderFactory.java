package fr.coppernic.innovatricshid;

/**
 * <p>Created on 06/12/17
 *
 * @author bastien
 */
public class AnalyticsProviderFactory {

    public AnalyticsProvider getAnalyticsProvider() {
        return new AnswerProvider();
    }
}
