package org.example;

import java.util.Arrays;

public class GetDistinct {

    public GetDistinct(String str) {
    }

    public static int[] getDistinctNumbers (int[] ints) {
        return Arrays.stream(ints).distinct().toArray();
    }
}


//Метод Java Stream distinct()возвращает новый поток различных элементов.
// Поэтому его можно использовать для удаления дубликатов элементов из набора.