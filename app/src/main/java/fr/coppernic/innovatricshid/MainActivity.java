package fr.coppernic.innovatricshid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        presenter = new MainPresenterImpl(this, interactor);
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
