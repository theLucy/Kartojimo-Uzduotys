package dev.laurynas;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        List<Integer> a = List.of(1, 2, 3,4);
        List<Double> b = List.of(4.1, 5.2, 6.3);
        List<Float> c = List.of(17.2f, 13.6f, 99f);
        List<BigDecimal> d = List.of(new BigDecimal("41.1"), new BigDecimal("52.2"), new BigDecimal("69.3"));
        System.out.println(vidurkis(a));
        System.out.println(vidurkis(b));
        System.out.println(vidurkis(c));
        System.out.println(vidurkis(d));

        Integer[] array1 = {1,2,3};
        Integer[] array2 = {4,5,6};
        Integer[] array3 = {7,8,9};


        Integer[] newArray = concatArrays(array1, array2, array3);
        int[] intArr = new int[newArray.length];

        IntStream.range(0, newArray.length)
                .forEach(i -> intArr[i] = newArray[i]);

        System.out.println(Arrays.toString(intArr));
    }


    public static <T> T getFirstElement(List<T> list) {
        return list.get(0);
    }

    @SafeVarargs
    public static <T> T[] concatArrays(T[] ... arrs) {
        int newLength = 0;
        for (T[] arr : arrs) {
            newLength += arr.length;
        }

        T[] result = (T[]) Array.newInstance(
                arrs.getClass().getComponentType().getComponentType(),
                newLength);
        int offset = 0;
        for (T[] arr : arrs) {
            System.arraycopy(arr, 0, result, offset, arr.length);
            offset += arr.length;
        }

        return result;

    }

    public static double vidurkis(List<? extends Number> list) {
        double vidurkis = 0;

        for (Number number : list)
            vidurkis += number.doubleValue();

        return vidurkis / list.size();
    }
}