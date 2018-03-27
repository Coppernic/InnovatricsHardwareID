package fr.coppernic.innovatricshid;

/**
 * Created by benoist on 27/03/18.
 */

public class HardwareId {
    public String serialNumber;
    public String hardwareId;
    public String editor;
    public String product;

    public HardwareId() {

    }

    public HardwareId(String editor, String product, String serialNumber, String hardwareId) {
        this.editor = editor;
        this.product = product;
        this.serialNumber = serialNumber;
        this.hardwareId = hardwareId;
    }
}
