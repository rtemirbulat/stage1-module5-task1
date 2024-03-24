package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String str : list) {
                if (str.isEmpty() || !Character.isUpperCase(str.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list->{
            List<Integer> even = list.stream()
                    .filter(k->k%2==0)
                    .toList();
            list.addAll(even);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return ()->{
            ArrayList<String> newAl = new ArrayList<>();
            for (String v: values) {
                        if(Character.isUpperCase(v.charAt(0)) && v.endsWith(".") && Arrays.stream(v.split(" ")).count()>3){
                            newAl.add(v);
                        }
                }
            return newAl;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Map<String, Integer> mapka = new HashMap<>();
        return x -> {
            for (String v: x) {
                mapka.put(v, v.length());
            }
            return mapka;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        ArrayList<Integer> newArr = new ArrayList<>();
        return (list1, list2) -> {
            newArr.addAll(list1);
            newArr.addAll(list2);
            return newArr;
        };
    }
}
