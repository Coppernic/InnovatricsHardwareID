package fr.coppernic.innovatricshid;

import android.os.Build;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
            String hwId = CpcBytes.byteArrayToAsciiString(hwIdBytes);
            mainView.showHardwareId(hwId);
            new AnalyticsProviderFactory().getAnalyticsProvider().logEvent(hwId, "HardwareID", "ID for Innovatrics License generation");
            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("hardware_ids");
            HardwareId hardwareId = new HardwareId("Innovatrics", "Ansi/ISO", Build.SERIAL, hwId);
            myRef.child("Innovatrics").child("AnsiISO").child(Build.SERIAL).setValue(hwId);
        } else {
            mainView.showHardwareId("Error");
            new AnalyticsProviderFactory().getAnalyticsProvider().logEvent("Error", "HardwareID", "ID for Innovatrics License generation");
        }
    }
}
