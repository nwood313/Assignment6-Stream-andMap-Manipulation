package com.coderscampus.tesla;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {

    public List<AnnualReport> readAnnualReport(String filename) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines
                    .skip(1)
                    .map(line -> {
                        String[] parts = line.split(",");
                        YearMonth date = YearMonth.parse(parts[0], DateTimeFormatter.ofPattern("MMM-yy"));
                        Integer sales = Integer.parseInt(parts[1]);
                        return new AnnualReport(date, sales);
                    }).collect(Collectors.toList());
        }


    }

    public Optional<AnnualReport> findBestMonth(List<AnnualReport> annualReports) {
        return annualReports.stream().max(Comparator.comparingInt(AnnualReport::getSales));

    }

    public Optional<AnnualReport> findWorstMonth(List<AnnualReport> annualReports) {
        return annualReports.stream().min(Comparator.comparingInt(AnnualReport::getSales));
    }
}
