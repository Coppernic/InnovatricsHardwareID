package fr.coppernic.innovatricshid.hardware;

import android.os.Build;

import com.innovatrics.iengine.ansiiso.AnsiIso;

import fr.coppernic.sdk.utils.core.CpcBytes;

/**
 * Created by benoist on 19/03/18.
 */

public class HardwareIdInteractorInnovatrics implements HardwareIdInteractor {
    private AnsiIso ansiIso;

    public HardwareIdInteractorInnovatrics() {
        ansiIso = new AnsiIso();
    }

    @Override
    public String getSerialNumber() {
        return Build.SERIAL;
    }

    @Override
    public String getHardwareId() {
        return CpcBytes.byteArrayToAsciiString(ansiIso.getHardwareId());
    }
}
