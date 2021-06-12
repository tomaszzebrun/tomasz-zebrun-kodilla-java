package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer element: numbers) {
            if (element % 2 == 0 ) {
                result.add(element);
            }
        }
        return result;
    }
}
