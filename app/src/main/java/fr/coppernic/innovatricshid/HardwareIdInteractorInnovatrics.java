package fr.coppernic.innovatricshid;

import android.os.Build;

import com.innovatrics.iengine.ansiiso.AnsiIso;

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
    public byte[] getHardwareId() {
        return ansiIso.getHardwareId();
    }


}
