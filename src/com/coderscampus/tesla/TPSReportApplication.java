package com.coderscampus.tesla;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TPSReportApplication {

    public static void main(String[] args) throws IOException {
        FileService fileService = new FileService();

        //Model 3 info
        System.out.println("Model 3 Annual Sales Report");
        System.out.println("---------------------------");
        List<AnnualReport> model3Sales = fileService.readAnnualReport("model3.csv");

        Map<Integer, Integer> Sumof3Sales = model3Sales.stream()
                                                       .collect(Collectors.groupingBy(report -> report.getDate().getYear(), Collectors.summingInt(AnnualReport::getSales)
                ));
        Sumof3Sales.forEach((year, sales) -> System.out.println(year + " -> " + sales));
        System.out.println();
        fileService.findBestMonth(model3Sales).ifPresent(report -> System.out.println("The best month for Model 3 was " + report.getDate()));
        fileService.findWorstMonth(model3Sales).ifPresent(report -> System.out.println("The worst month for Model 3 was " + report.getDate()));

        //Model S report
        System.out.println();
        System.out.println("Model S Annual Sales Report");
        System.out.println("---------------------------");

        List<AnnualReport> modelSSales = fileService.readAnnualReport("modelS.csv");

        Map<Integer, Integer> SumofSSales = modelSSales.stream()
                .collect(Collectors.groupingBy(report ->
                        report.getDate().getYear(), Collectors.summingInt(AnnualReport::getSales)
                ));
        SumofSSales.forEach((year, sales) -> System.out.println(year + " -> " + sales));
        System.out.println();
        fileService.findBestMonth(modelSSales).ifPresent(report -> System.out.println("The best month for Model S was " + report.getDate()));
        fileService.findWorstMonth(modelSSales).ifPresent(report -> System.out.println("The worst month for Model S was " + report.getDate()));

        //Model X report
        System.out.println("\n");
        System.out.println("Model X Annual Sales Report");
        System.out.println("----------------------------");

        List<AnnualReport> modelXSales = fileService.readAnnualReport("modelX.csv");

        Map<Integer, Integer> SumofXSales = modelXSales.stream()
                                                       .collect(Collectors.groupingBy(report ->
                        report.getDate().getYear(), Collectors.summingInt(AnnualReport::getSales)
                ));
        SumofXSales.forEach((year, sales) -> System.out.println(year + " -> " + sales));
        System.out.println("\n");
        fileService.findBestMonth(modelXSales).ifPresent(report -> System.out.println("The best month for Model X was " + report.getDate()));
        fileService.findWorstMonth(modelXSales).ifPresent(report -> System.out.println("The worst month for Model X was " + report.getDate()));


    }
}
