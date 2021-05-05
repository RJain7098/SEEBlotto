import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class blotto {
    public static void main(String[] args) {
        //findBest(10000);
        //manualComparison();
        smartComparison();
//        Entry test1 = new Entry(new int[]{10, 10, 10, 10, 20, 0, 0, 0, 20, 20});
//        Entry test2 = new Entry(new int[]{20, 0, 10, 5, 10, 5, 10, 20, 0, 0});
//        test1.compete(test2);
//        System.out.print(test1.averageScore);
//        System.out.print(" ");
//        test1.printEntry();
//        System.out.print(test2.averageScore);
//        System.out.print(" ");
//        test2.printEntry();
    }


    /**
     * Compares my possible entries against a select subset of "smart" entries, as well as
     * some random ones, and sorts and prints the results.
     */
    public static void smartComparison() {
        int max = 1000;
        Entry[] entries = new Entry[max];
        entries[0] = new Entry(new int[]{1, 1, 59, 17, 19, 1, 1, 1, 0, 0});
        entries[1] = new Entry(new int[]{1, 8, 50, 21, 9, 4, 3, 1, 2, 1});
//        entries[2] = new Entry(new int[]{1, 1, 90, 4, 4, 0, 0, 0, 0, 0});
//        entries[3] = new Entry(new int[]{1, 1, 35, 32, 31, 0, 0, 0, 0, 0});
//        entries[4] = new Entry(new int[]{0, 0, 34, 33, 33, 0, 0, 0, 0, 0});
        for (int i = 2; i < 100; i++) {
            entries[i] = new Entry(new int[]{33, 33, 34, 0, 0, 0, 0, 0, 0, 0});
        }
        for (int i = 200; i < 400; i++) {
            entries[i] = new Entry(new int[]{0, 0, 36, 33, 31, 0, 0, 0, 0, 0});
        }
        for (int i = 400; i < 600; i++) {
            entries[i] = new Entry(new int[]{1, 1, 60, 18, 15, 2, 2, 2, 0, 0});
            //entries[i] = new Entry();
        }
        for (int i = 600; i < 800; i++) {
            entries[i] = new Entry(new int[]{16, 16, 58, 8, 1, 1, 0, 0, 0, 0});
        }
        for (int i = 800; i < 1000; i++) {
            entries[i] = new Entry();
        }
        for (int i = 100; i < 200; i++) {
            entries[i] = new Entry(new int[]{6, 17, 39, 18, 12, 2, 3, 1, 2, 0});
        }
        for (int i = 0; i < max; i++) {
            for (int j = i + 1; j < max; j++) {
                if (entries[i] != null && entries[j] != null) {
                    entries[i].compete(entries[j]);
                }
            }
        }
        Arrays.sort(entries);
        for (Entry e : entries) {
            if (e != null) {
                System.out.print(e.averageScore);
                System.out.print("       ");
                e.printEntry();
            }
        }
    }
    public static void manualComparison() {
        int maxEntries = 12;
        Entry[] entries = new Entry[maxEntries];
        entries[0] = new Entry(new int[]{1, 0, 34, 6, 22, 16, 7, 5, 4, 5});
        entries[1] = new Entry(new int[]{0,0,12,17,22,2,3,42,2,0});
        entries[2] = new Entry(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        entries[3] = new Entry(new int[]{0, 33, 33, 34, 0, 0, 0, 0, 0, 0});
        entries[4] = new Entry(new int[]{0, 0, 0, 0, 0, 33, 33, 34, 0, 0});
        entries[5] = new Entry(new int[]{1, 1, 1, 1, 31, 31, 31, 1, 1, 1});
        entries[6] = new Entry(new int[]{13, 20, 27, 24, 9, 2, 2, 0, 2, 1});
        entries[7] = new Entry(new int[]{28, 22, 15, 10, 10, 8, 4, 2, 1, 0});
        entries[8] = new Entry(new int[]{14, 27, 22, 17, 9, 3, 4, 2, 2, 0});
        entries[9] = new Entry(new int[]{2, 1, 19, 28, 10, 18, 9, 7, 4, 2});
        entries[10] = new Entry(new int[]{3, 3, 10, 33, 19, 9, 11, 7, 3, 2});
        entries[11] = new Entry(new int[]{6, 0, 1, 34, 20, 23, 9, 4, 2, 1});
        for (int i = 0; i < maxEntries; i++) {
            for (int j = i + 1; j < maxEntries; j++) {
                if (entries[i] != null && entries[j] != null) {
                    entries[i].compete(entries[j]);
                }
            }
        }
        Arrays.sort(entries);
        for (Entry e : entries) {
            if (e != null) {
                System.out.print(e.averageScore);
                System.out.print("       ");
                e.printEntry();
            }
        }
    }
    /**
     * Generates a lot of completely random entries and plays them all against each other and then
     * sorts by average score and prints.
     * @param max The number of entries to generate
     */
    public static void findBest(int max) {
        Entry[] entries = new Entry[max];
        entries[0] = new Entry(new int[]{1, 2, 59, 18, 18, 1, 1, 0, 0, 0});
        entries[1] = new Entry(new int[]{33, 33, 34, 0, 0, 0, 0, 0, 0, 0});
        for (int i = 2; i < max; i++) {
            entries[i] = new Entry();
        }
        for (int i = 0; i < max; i++) {
            for (int j = i + 1; j < max; j++) {
                if (entries[i] != null && entries[j] != null) {
                    entries[i].compete(entries[j]);
                }
            }
        }
        Arrays.sort(entries);
        for (Entry e : entries) {
            if (e != null) {
                System.out.print(e.averageScore);
                System.out.print("       ");
                e.printEntry();
            }
        }
    }

    /**
     * Obsolete method left only in case I find some use for it
     * @param max the number of entries to generate
     */
    public static void findBestRearrange(int max) {
        Entry[] entries = new Entry[max];
        entries[0] = new Entry(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        for (int i = 1; i < max; i++) {
            entries[i] = new Entry();
        }
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < max; j++) {
                entries[0].rearrange(entries[j]);
            }
        }
        for (int i = 0; i < max; i++) {
            entries[0].compete(entries[i]);
        }

        System.out.print(entries[0].averageScore);
        System.out.print("       ");
        entries[0].printEntry();
    }
}