package com.devel.hr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindWordsNotPresentInBothLists {


    public static List<String> findWordsNotPresentInBothLists(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();

        // First sort both lists
        list1.sort(Comparator.naturalOrder());
        list2.sort(Comparator.naturalOrder());

        // Start by looking into list1 and flip each time
        // I find my element is higher than the other list
        List<String> lookInto = list1;
        List<String> theOther = list2;
        int max = Math.max(list1.size(), list2.size());

        for (int i = 0, j = 0; i < max; ) {
            if (j != theOther.size() && lookInto.get(i).compareTo(theOther.get(j)) == 0) {
                i++;
                j++;
                continue;
            }
            if (j == theOther.size() || lookInto.get(i).compareTo(theOther.get(j)) < 0) {
                result.add(lookInto.get(i));
                i++;
            }
            if ((i == lookInto.size()) /* I finished with this list force one flip to continue comparing form the other list */
                    || lookInto.get(i).compareTo(theOther.get(j)) > 0) {
                // flip reference since I reached a higher string than the one on the other list
                List<String> aux = lookInto;
                lookInto = theOther;
                theOther = aux;
                int x = i;
                i = j;
                j = x;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list1 = Stream.of("this", "is", "a", "test").collect(Collectors.toList());
        List<String> list2 = Stream.of("that", "is", "b", "not", "test").collect(Collectors.toList());
        System.out.println(FindWordsNotPresentInBothLists.findWordsNotPresentInBothLists(list1, list2));
    }

}
