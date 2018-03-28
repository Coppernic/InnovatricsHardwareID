package fr.coppernic.innovatricshid.authentication;

/**
 * Created by benoist on 28/03/18.
 */

public interface AuthenticationInteractor {

    interface AuthenticationListener {
        void onAuthenticationSuccess();
        void onAuthenticationError();
    }

    void anonymousSignIn(AuthenticationListener listener);
}
