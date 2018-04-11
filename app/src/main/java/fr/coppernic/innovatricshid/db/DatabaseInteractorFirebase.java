package fr.coppernic.innovatricshid.db;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Data base interactor for firebase
 */

public class DatabaseInteractorFirebase extends DatabaseInteractorBase {
    @Override
    public void saveHwId(String editor, String product, String group, String serialNumber, String hwId) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference(TABLE_NAME);
        databaseReference.child(editor).child(product).child(group).child(serialNumber).child(DATE_FIELD).setValue(getDate());
        databaseReference.child(editor).child(product).child(group).child(serialNumber).child(HWID_FIELD).setValue(hwId);
    }
}
