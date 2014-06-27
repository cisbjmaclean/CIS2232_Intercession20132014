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

    /**
     * This method calls the methods that create the comparators and then calls
     * the method to sort the storage units for customers.
     *
     * @param storageUnits
     * @return
     */
    public static ArrayList<StorageUnitForm> sortDefault(ArrayList<StorageUnitForm> storageUnits) {
        storageUnitsSorted = new ArrayList();
        ComparatorChain chain = new ComparatorChain();
        chain.addComparator(comparatorAvailability);
        chain.addComparator(comparatorDimensions);
        chain.addComparator(comparatorDateTo);
        storageUnitsSorted = sort(storageUnits, chain);
        return storageUnitsSorted;
    }

    /**
     * This method calls the methods that create the comparators and then calls
     * the method to sort the storage units for admins.
     *
     * @param storageUnits
     * @return
     */
    public static ArrayList<StorageUnitForm> sortAdmin(ArrayList<StorageUnitForm> storageUnits) {
        storageUnitsSorted = new ArrayList();
        ComparatorChain chain = new ComparatorChain();
        chain.addComparator(comparatorUnitId);
        storageUnitsSorted = sort(storageUnits, chain);
        return storageUnitsSorted;
    }

    /**
     * This comparator sorts by unitID.
     */
    public static Comparator<StorageUnitForm> comparatorUnitId = new Comparator<StorageUnitForm>() {
        @Override
        public int compare(StorageUnitForm o1, StorageUnitForm o2) {
            return o1.getUnitID() - (o2.getUnitID());
        }
    };

    /**
     * This comparator sorts by availability.
     */
    public static Comparator<StorageUnitForm> comparatorAvailability = new Comparator<StorageUnitForm>() {
        @Override
        public int compare(StorageUnitForm o1, StorageUnitForm o2) {
            return o1.getUnitAvailability() - (o2.getUnitAvailability());
        }
    };

    /**
     * This comparator sorts by dimensions.
     */
    public static Comparator<StorageUnitForm> comparatorDimensions = new Comparator<StorageUnitForm>() {
        @Override
        public int compare(StorageUnitForm o1, StorageUnitForm o2) {
            return o1.getUnitDimensions().compareTo(o2.getUnitDimensions());
        }
    };

    /**
     * This comparator sorts by date to.
     */
    public static Comparator<StorageUnitForm> comparatorDateTo = new Comparator<StorageUnitForm>() {
        @Override
        public int compare(StorageUnitForm o1, StorageUnitForm o2) {
            return o1.getUnitDateTo().compareTo(o2.getUnitDateTo());
        }
    };

    /**
     * This method calls Collection.sort then returns the results.
     *
     * @param storageUnits
     * @param chain
     * @return
     */
    public static ArrayList<StorageUnitForm> sort(ArrayList<StorageUnitForm> storageUnits, ComparatorChain chain) {
        Collections.sort(storageUnits, chain);
        return storageUnits;
    }
}
