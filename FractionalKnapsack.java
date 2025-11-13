import java.util.*;

public class FractionalKnapsack {

    static class Item {
        int profit;
        int weight;
        double ratio;

        Item(int profit, int weight) {
            this.profit = profit;
            this.weight = weight;
            this.ratio = (double) profit / weight; // profit-to-weight ratio
        }
    }

    public static void main(String[] args) {
        int capacity = 20; // total weight capacity of knapsack

        // Hardcoded profit and weight
        //array of objects 
        Item[] items = {
            new Item(25, 18),
            new Item(24, 15),
            new Item(15, 10)
        };

        // Sort by ratio (descending)
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                if (b.ratio > a.ratio) return 1;
                else if (b.ratio < a.ratio) return -1;
                else return 0;
            }
        });

        double totalprofit = 0.0;
        int remainingCapacity = capacity;

        System.out.println("Item\tprofit\tWeight\tRatio");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i+1) + "\t" + items[i].profit + "\t" + items[i].weight + "\t" + items[i].ratio);
        }

        System.out.println("\nKnapsack process:");
        for (int i = 0; i < items.length; i++) {
            if (remainingCapacity == 0) break;

            if (items[i].weight <= remainingCapacity) {
                // Take full item
                totalprofit += items[i].profit;
                remainingCapacity -= items[i].weight;
                System.out.println("Taking full item " + (i+1));
            } else {
                // Take fractional part
                double fraction = (double) remainingCapacity / items[i].weight;
                totalprofit += items[i].profit * fraction;
                System.out.println("Taking " + (fraction * 100) + "% of item " + (i+1));
                remainingCapacity = 0;
            }
        }

        System.out.println("\nMaximum profit obtained = " + totalprofit);
    }
}
