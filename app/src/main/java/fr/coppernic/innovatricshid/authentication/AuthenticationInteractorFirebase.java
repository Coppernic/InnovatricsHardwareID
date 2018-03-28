package fr.coppernic.innovatricshid.authentication;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by benoist on 28/03/18.
 */

public class AuthenticationInteractorFirebase implements AuthenticationInteractor {
    private Activity activity;

    public AuthenticationInteractorFirebase(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void anonymousSignIn(final AuthenticationListener listener) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInAnonymously().addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    listener.onAuthenticationSuccess();
                } else {
                    listener.onAuthenticationError();
                }
            }
        });
    }
}
