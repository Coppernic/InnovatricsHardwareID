package fr.coppernic.innovatricshid;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.coppernic.innovatricshid.authentication.AuthenticationInteractor;
import fr.coppernic.innovatricshid.authentication.AuthenticationInteractorFirebase;
import fr.coppernic.innovatricshid.db.DatabaseInteractor;
import fr.coppernic.innovatricshid.db.DatabaseInteractorFirebase;
import fr.coppernic.innovatricshid.hardware.HardwareIdInteractor;
import fr.coppernic.innovatricshid.hardware.HardwareIdInteractorInnovatrics;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.tvHardwareId)
    TextView tvHardwareId;
    @BindView(R.id.etGroup)
    EditText etGroup;

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
    public String getGroup() {
        return etGroup.getText().toString();
    }

    @Override
    public void showResult(boolean result) {
        Snackbar.make(tvHardwareId,result?R.string.hardwareid_created:R.string.error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.floatingActionButton)
    void sendHwId() {
        presenter.getHardwareId();
    }
}
