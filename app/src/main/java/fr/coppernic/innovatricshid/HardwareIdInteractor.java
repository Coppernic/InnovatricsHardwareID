package fr.coppernic.innovatricshid;

/**
 * Created by benoist on 19/03/18.
 */

public interface HardwareIdInteractor {
    String getSerialNumber();
    byte[] getHardwareId();
}
