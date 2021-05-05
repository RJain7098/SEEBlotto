import java.util.Random;

@SuppressWarnings("checkstyle")
public class Entry implements Comparable {
    int[] values;
    int score;
    int totalScore;
    double averageScore;
    int matchesPlayed;

    public Entry() {
        values = new int[10];
        totalScore = 0;
        score = 0;
        generateRandom();
    }
    public Entry(int[] values) {
        this.values = values;
        totalScore = 0;
        score = 0;
    }

    /**
     * Randomly distribute the 100 soldiers, capping any one spot to 34
     */
    public void generateRandomCapped() {
        int total = 100;
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            values[i] = (total <= 34) ? random.nextInt(total + 1) : random.nextInt(35);
            total -= values[i];
        }
        values[9] = total;
    }

    /**
     * Randomly distribute the 100 soldiers among the 10 castles
     */
    public void generateRandom() {
        int total = 100;
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            values[i] = random.nextInt(total + 1);
            total -= values[i];
        }
        values[9] = total;
    }

    /**
     * Pits this entry against e in a head to head match, updating the scores
     * @param e The entry to play against
     */
    public void compete(Entry e) {
        Entry lastWon = null;
        int consecutiveWins = 0;
        for (int i = 0; i < 10; i++) {
            if (e.values[i] > this.values[i]) {
                e.score += i + 1;
                if (lastWon == e) {
                    if (consecutiveWins >= 2) {
                        e.winAll(i + 1);
                        i = 15;
                    } else {
                        consecutiveWins++;
                    }
                } else {
                    lastWon = e;
                    consecutiveWins = 1;
                }
            } else if (e.values[i] < this.values[i]) {
                score += i + 1;
                if (lastWon == this) {
                    if (consecutiveWins >= 2) {
                        winAll(i + 1);
                        i = 15;
                    } else {
                        consecutiveWins++;
                    }
                } else {
                    lastWon = this;
                    consecutiveWins = 1;
                }
            } else {
                lastWon = null;
                consecutiveWins = 0;
            }
        }
        totalScore += score;
        matchesPlayed++;
        averageScore = (double ) totalScore / (double) matchesPlayed;
        e.totalScore += e.score;
        e.matchesPlayed++;
        e.averageScore = (double) e.totalScore / (double) e.matchesPlayed;
        score = 0;
        e.score = 0;
    }

    /**
     * Obsolete method where I tried something and it didn't work
     * @param e the entry to compare against
     */
    public void rearrange(Entry e) {
        int biggestLoss = 1;
        int biggestLossIndex = -1;
        int smallestLoss = 99 ;
        int smallestLossIndex = -1;
        for (int i = 0; i < 10; i++) {
            int diff = e.values[i] - this.values[i];
            if (values[i] > 0 && diff > biggestLoss) {
                biggestLoss = diff;
                biggestLossIndex = i;
            }
            if (values[i] < 100 && diff > 0 && diff < smallestLoss) {
                smallestLoss = diff;
                smallestLossIndex = i;
            }
        }
        if (biggestLossIndex != -1 && smallestLossIndex != -1) {
            values[biggestLossIndex]--;
            values[smallestLossIndex]++;
        }
    }
    public void winAll(int start) {
        for (int i = start; i < 10; i++) {
            score += i + 1;
        }
    }

    public void printEntry() {
        System.out.print("[");
        System.out.print(values[0]);
        for (int i = 1; i < 10; i++) {
            System.out.print(", " + values[i]);
        }
        System.out.println("]");
    }


    @Override
    public int compareTo(Object o) {
        Entry e = (Entry) o;
        double temp = averageScore - e.averageScore;
        if (temp > 0) {
            return 1;
        } else if (temp < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
