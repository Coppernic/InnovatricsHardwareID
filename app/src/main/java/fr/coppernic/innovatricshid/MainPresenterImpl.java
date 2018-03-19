package fr.coppernic.innovatricshid;

import fr.coppernic.sdk.utils.core.CpcBytes;

/**
 * Created by benoist on 19/03/18.
 */

public class MainPresenterImpl implements MainPresenter {

    private HardwareIdInteractor hardwareIdInteractor;
    private MainView mainView;

    public MainPresenterImpl(MainView mainView, HardwareIdInteractor hardwareIdInteractor) {
        this.mainView = mainView;
        this.hardwareIdInteractor = hardwareIdInteractor;
    }

    @Override
    public void getHardwareId() {
        byte[] hwIdBytes = hardwareIdInteractor.getHardwareId();

        if (hwIdBytes != null) {
            mainView.showHardwareId(CpcBytes.byteArrayToAsciiString(hwIdBytes));
        } else {
            mainView.showHardwareId("Error");
        }
    }
}
