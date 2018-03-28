package fr.coppernic.innovatricshid.db;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Base database interactor
 */

public abstract class DatabaseInteractorBase implements DatabaseInteractor {
    static final String TABLE_NAME = "hardware_ids";
    static final String DATE_FIELD = "date";
    static final String HWID_FIELD = "hwid";

    String getDate() {
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
        return format.format(currentTime);
    }
}
