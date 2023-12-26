package com.android.mobileappserver.Report;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/report")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    @PostMapping("/createReport")
    public ReportDTO createReport(@RequestBody ReportCreateDTO reportCreateDTO){
        return reportService.createReport(reportCreateDTO);
    }
}
