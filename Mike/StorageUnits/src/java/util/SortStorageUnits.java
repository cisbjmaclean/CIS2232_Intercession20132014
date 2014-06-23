package util;

import forms.StorageUnitForm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.apache.commons.collections4.comparators.ComparatorChain;

/**
 * @author Taken from
 * http://strangeoptics.blogspot.ca/2011/09/sorting-objects-by-multiple-attributes.html
 * @since 11/12/2011
 * @author Modified by Michael Fesser
 *
 */
public class SortStorageUnits {
    
    private static ArrayList<StorageUnitForm> storageUnitsSorted;

    public static ArrayList<StorageUnitForm> sortDefault(ArrayList<StorageUnitForm> storageUnits) {
        storageUnitsSorted = new ArrayList();
        ComparatorChain chain = new ComparatorChain();
        chain.addComparator(comparatorAvailability);
        chain.addComparator(comparatorDimensions);
        chain.addComparator(comparatorDateTo);
        storageUnitsSorted = sort(storageUnits, chain);
        return storageUnitsSorted;
    }
    
     public static ArrayList<StorageUnitForm> sortAdmin(ArrayList<StorageUnitForm> storageUnits) {
        storageUnitsSorted = new ArrayList();
        ComparatorChain chain = new ComparatorChain();
        chain.addComparator(comparatorUnitId);
        storageUnitsSorted = sort(storageUnits, chain);
        return storageUnitsSorted;
    }

      public static Comparator<StorageUnitForm> comparatorUnitId = new Comparator<StorageUnitForm>() {
        @Override
        public int compare(StorageUnitForm o1, StorageUnitForm o2) {
            return o1.getUnitId()- (o2.getUnitId());
        }
    };
      
    public static Comparator<StorageUnitForm> comparatorAvailability = new Comparator<StorageUnitForm>() {
        @Override
        public int compare(StorageUnitForm o1, StorageUnitForm o2) {
            return o1.getUnitAvailability() - (o2.getUnitAvailability());
        }
    };

    public static Comparator<StorageUnitForm> comparatorDimensions = new Comparator<StorageUnitForm>() {
        @Override
        public int compare(StorageUnitForm o1, StorageUnitForm o2) {
            return o1.getUnitDimensions().compareTo(o2.getUnitDimensions());
        }
    };

    public static Comparator<StorageUnitForm> comparatorDateTo = new Comparator<StorageUnitForm>() {
        @Override
        public int compare(StorageUnitForm o1, StorageUnitForm o2) {
            return o1.getUnitDateTo().compareTo(o2.getUnitDateTo());
        }
    };

public static ArrayList<StorageUnitForm> sort(ArrayList<StorageUnitForm> storageUnits, ComparatorChain chain) {
        Collections.sort(storageUnits, chain);
        return storageUnits;
    }
}
