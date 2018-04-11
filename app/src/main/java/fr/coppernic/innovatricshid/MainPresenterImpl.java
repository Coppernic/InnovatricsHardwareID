package fr.coppernic.innovatricshid;

import fr.coppernic.innovatricshid.authentication.AuthenticationInteractor;
import fr.coppernic.innovatricshid.db.DatabaseInteractor;
import fr.coppernic.innovatricshid.db.DatabaseInteractorFirebase;
import fr.coppernic.innovatricshid.hardware.HardwareIdInteractor;

/**
 * Main Presenter implementation
 */

public class MainPresenterImpl implements MainPresenter, AuthenticationInteractor.AuthenticationListener {
    private static final String EDITOR = "Innovatrics";
    private static final String PRODUCT = "AnsiIso";

    private HardwareIdInteractor hardwareIdInteractor;
    private MainView mainView;
    private DatabaseInteractor database;
    private AuthenticationInteractor authenticationInteractor;

    public MainPresenterImpl(MainView mainView, HardwareIdInteractor hardwareIdInteractor, DatabaseInteractor database, AuthenticationInteractor authenticationInteractor) {
        this.mainView = mainView;
        this.hardwareIdInteractor = hardwareIdInteractor;
        this.database = database;
        this.authenticationInteractor = authenticationInteractor;
    }

    @Override
    public void getHardwareId() {
        // Authentication is not working without GMS, I keep the code in case for future use
        String hwId = hardwareIdInteractor.getHardwareId();

        if (hwId.compareTo("") != 0) {
            mainView.showHardwareId(hwId);
            // Writes hardware ID into database
            database.saveHwId(EDITOR, PRODUCT, mainView.getGroup(), hardwareIdInteractor.getSerialNumber(), hwId);
            mainView.showResult(true);
        } else {
            mainView.showHardwareId("Error");
            database.saveHwId(EDITOR, PRODUCT, mainView.getGroup(), hardwareIdInteractor.getSerialNumber(), "Error");
            mainView.showResult(false);
        }
    }

    @Override
    public void onAuthenticationSuccess() {

    }

    @Override
    public void onAuthenticationError() {

    }
}
