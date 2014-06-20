package util;

import forms.StorageUnitForm;
import java.util.Comparator;

/**
 *
 * @author Michael
 * @since Jun 14, 2014
 */
public class SortUnits implements Comparator<StorageUnitForm> {

    @Override
    public int compare(StorageUnitForm t, StorageUnitForm t1) {
        int unitId1 = t.getCustomerId();
        int unitId2 = t1.getCustomerId();
        return unitId1 - unitId2;
    }
}
