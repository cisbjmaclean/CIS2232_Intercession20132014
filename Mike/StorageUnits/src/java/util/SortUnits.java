package util;

import forms.StorageUnitForm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Michael
 * @since Jun 14, 2014
 */
public class SortUnits {

    public static void compare(ArrayList<StorageUnitForm> storageUnits) {
        Collections.sort(storageUnits, new Comparator<StorageUnitForm>() {
            public int compare(StorageUnitForm form1, StorageUnitForm form2) {
                return String.valueOf(form1.getUnitId()).compareTo(String.valueOf(form2.getUnitId()));
            }
        });
    }
}
