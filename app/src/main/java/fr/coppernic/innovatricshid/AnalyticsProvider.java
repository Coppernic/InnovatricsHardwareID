package fr.coppernic.innovatricshid;

/**
 * <p>Created on 06/12/17
 *
 * @author bastien
 */
public interface AnalyticsProvider {

    void logEvent(String id, String name, String type);
}
