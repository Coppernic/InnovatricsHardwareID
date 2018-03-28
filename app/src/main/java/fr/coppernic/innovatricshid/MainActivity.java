package fr.coppernic.innovatricshid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.coppernic.innovatricshid.authentication.AuthenticationInteractor;
import fr.coppernic.innovatricshid.authentication.AuthenticationInteractorFirebase;
import fr.coppernic.innovatricshid.db.DatabaseInteractor;
import fr.coppernic.innovatricshid.db.DatabaseInteractorFirebase;
import fr.coppernic.innovatricshid.hardware.HardwareIdInteractor;
import fr.coppernic.innovatricshid.hardware.HardwareIdInteractorInnovatrics;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.tvHardwareId)
    TextView tvHardwareId;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        HardwareIdInteractor interactor = new HardwareIdInteractorInnovatrics();
        DatabaseInteractor dataabseInteractor = new DatabaseInteractorFirebase();
        AuthenticationInteractor authenticationInteractor = new AuthenticationInteractorFirebase(this);

        presenter = new MainPresenterImpl(this, interactor, dataabseInteractor, authenticationInteractor);
    }

    @Override
    public void showHardwareId(String hardwareId) {
        tvHardwareId.setText(hardwareId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getHardwareId();
    }
}
