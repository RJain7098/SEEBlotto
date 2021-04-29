import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class blotto {
    public static void main(String[] args) {
        Entry[] entries = new Entry[9];
        entries[0] = new Entry(new int[]{1, 0, 34, 6, 22, 16, 7, 5, 4, 5});
        entries[1] = new Entry(new int[]{0,0,12,17,22,2,3,42,2,0});
        entries[2] = new Entry(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        entries[3] = new Entry(new int[]{0, 33, 33, 34, 0, 0, 0, 0, 0, 0});
        entries[4] = new Entry(new int[]{0, 0, 0, 0, 0, 33, 33, 34, 0, 0});
        entries[5] = new Entry(new int[]{1, 1, 1, 1, 31, 31, 31, 1, 1, 1});
        entries[6] = new Entry(new int[]{13, 20, 27, 24, 9, 2, 2, 0, 2, 1});
        entries[7] = new Entry(new int[]{28, 22, 15, 10, 10, 8, 4, 2, 1, 0});
        entries[8] = new Entry(new int[]{14, 27, 22, 17, 9, 3, 4, 2, 2, 0});
        int maxEntries = 9;
//        Entry[] entries = new Entry[maxEntries];
//        entries[0] = new Entry(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
//        for (int i = 1; i < maxEntries; i++) {
//            entries[i] = new Entry();
//        }
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
}