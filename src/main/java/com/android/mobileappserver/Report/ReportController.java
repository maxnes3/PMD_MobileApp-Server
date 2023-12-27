package com.android.mobileappserver.Report;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/report")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    @GetMapping("/createReport/{dateFrom}/{dateTo}")
    public ReportDTO createReport(@PathVariable("dateFrom") Long dateFrom,
                                  @PathVariable("dateTo") Long dateTo){
        return reportService.createReport(dateFrom, dateTo);
    }
}
