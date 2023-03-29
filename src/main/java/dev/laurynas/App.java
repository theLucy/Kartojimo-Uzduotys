package dev.laurynas;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        /*Random rnd = new Random();

        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rnd.nextInt(-10, 11);
        }

        var numsList = numArrToStringList(nums);
        System.out.println(numsList);

        System.out.println("*".repeat(50));

        System.out.println(Arrays.toString(nums));
        numsArrInfo(nums);*/


    }

    public static Optional<TreeSet<String>> findPlants(String type) {
        Plant[] plants = {
                new Plant("Obuolys", "Vaisius"),
                new Plant("Kriause", "Vaisius"),
                new Plant("Morka", "Darzove"),
                new Plant("Agurkas", "Darzove"),
                new Plant("Bulve", "Darzove"),
                new Plant("Vysnia", "Uoga")
        };

        TreeMap<String, TreeSet<String>> groupedPlants = Arrays.stream(plants)
                .collect(Collectors.groupingBy(Plant::getType, TreeMap::new, Collectors.mapping(Plant::getName,Collectors.toCollection(TreeSet::new))));

        TreeSet<String> result = groupedPlants.get(type);

        return Optional.ofNullable(result);
    }

    public static List<String> numArrToStringList(int[] nums) {
        return Arrays.stream(nums)
                .filter(x -> x < 0)
                .map(x -> x * x)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
    }

    public static void numsArrInfo(int[] nums) {
        int min = Arrays.stream(nums).min().orElse(0);
        int max = Arrays.stream(nums).max().orElse(0);
        long count = Arrays.stream(nums).count();
        int sum = Arrays.stream(nums).sum();
        long product = Arrays.stream(nums).reduce((a, b) -> a * b).orElse(0);
        double average = Arrays.stream(nums).average().orElse(0);
        System.out.printf("""
                min = %d
                max = %d
                count = %d
                sum = %d
                product = %d
                average = %f
                """, min, max, count, sum, product, average);

        int[][] nums2 = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };

        System.out.println(sumOfArrArr(nums2));
    }

    public static int sumOfArrArr(int[][] nums) {
        return Arrays.stream(nums)
                .flatMapToInt(Arrays::stream)
                .sum();
    }
}