package com.example.demos.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static com.example.demos.settings.ViewSettings.matchScoreCountTableRows;

public class NumirableTableRowsByPageService <E> {


    // обрезает нужную страницу в переданном массиве и возвращает массив.length == matchScoreCountTableRows
    public <E> List<ArrayList<Object>> cutForOnePage(ArrayList<E> array, int page) {

        List<ArrayList<Object>> retArr = new ArrayList<>(page);
        int start = 0;
        if (page > 1) start = (page * matchScoreCountTableRows ) - matchScoreCountTableRows;

        int end = page * matchScoreCountTableRows - 1;
        int numeric = 0;

        System.out.println(start + " / " + end );

        for (E val : array) {
            if (numeric >= start && numeric <= end) {
                ArrayList<Object> obj = new ArrayList<>();
                obj.add(numeric + 1);
                obj.add(val);
                retArr.add(obj);
            }
            numeric++;
        }


        return retArr;
    }
}
