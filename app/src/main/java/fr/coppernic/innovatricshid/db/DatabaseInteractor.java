package fr.coppernic.innovatricshid.db;

/**
 * Created by benoist on 28/03/18.
 */

public interface DatabaseInteractor {
    void saveHwId(String editor, String product, String group,  String serialNumber, String hwId);
}
