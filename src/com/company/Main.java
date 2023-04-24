package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> companyToNumberOfEmployeesMap = new HashMap<>();

        companyToNumberOfEmployeesMap.put("Goods Inc", 550);
        companyToNumberOfEmployeesMap.put("BestDevStudio", 1200);
        companyToNumberOfEmployeesMap.put("Ggl", 1000000);
        //Name: BestDevStudio, Num: 1200
        //Name: Goods Inc, Num: 550
        //Name: Ggl, Num: 1000000

        companyToNumberOfEmployeesMap.merge("Goods Inc", 50, Integer::sum); // adding 50
        companyToNumberOfEmployeesMap.merge("Healthy Eating", 100, Integer::sum); // a new company
        //Name: BestDevStudio, Num: 1200
        //Name: Goods Inc, Num: 600
        //Name: Ggl, Num: 1000000
        //Name: Healthy Eating, Num: 100

        companyToNumberOfEmployeesMap.compute("Ggl", (company, employees) -> (int) (employees * 0.8));
        //Name: Ggl, Num: 800000

        companyToNumberOfEmployeesMap.compute("Unknown",
                (company, employees) -> Objects.nonNull(employees) ? (int) (employees * 0.8) : 0);

        companyToNumberOfEmployeesMap.computeIfAbsent("New company", MergeMap::calculateSomehow);

//        int employees = calculateSomehow("New company");
//        companyToNumberOfEmployeesMap.putIfAbsent("New company", employees);

        printArray(companyToNumberOfEmployeesMap);
    }

    public static int calculateSomehow(String company) {
        // simulate complex calculations
        return 30;
    }

    public static void printArray(Map<String, Integer> array) {
        array.forEach((name, num) -> System.out.printf("Name: %s, Num: %d\n", name, num));
    }
}
