package mx.employees.employees.controller;


import mx.employees.employees.common.dto.*;
import mx.employees.employees.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "/employee" )
public class EmployeeController {

    private static Logger log = LogManager.getLogger(EmployeeController.class);

    @Autowired
    private CreateEmployeeService createEmployeeService;

    @PostMapping("/create")
    public CreateEmployeeResponse create(@RequestBody CreateEmployeeRequest request) {

        return createEmployeeService.create(request);

    }

    @Autowired
    private GetEmployeesByJobService getEmployeesByJobService;

    @PostMapping("/getByJob")
    public GetEmployeesByJobResponse getByJob(@RequestBody GetEmployeesByJobRequest request) {

        return this.getEmployeesByJobService.getByJob(request);

    }

    @Autowired
    private GetEmployeesByListService getEmployeesByListService;

    @PostMapping("/getByList")
    public GetEmployeesByListResponse getList(@RequestBody GetEmployeesByListRequest request) {

        return this.getEmployeesByListService.getByList(request);

    }

    @Autowired
    private GetWorkedHoursEmployeeService getWorkedHoursEmployeeService;

    @PostMapping("/getWorkedHours")
    public GetWorkedHoursEmployeeResponse getWorkedHours(@RequestBody GetWorkedHoursEmployeeRequest request) {

        return this.getWorkedHoursEmployeeService.getWorkedHoursEmployee(request);

    }

    @Autowired
    private GetPayRollEmployeeService getPayRollEmployeeService;

    @PostMapping("/getPayRoll")
    public GetPayRollEmployeeResponse getWorkedHours(@RequestBody GetPayRollEmployeeRequest request) {

        return this.getPayRollEmployeeService.getPayRoll(request);

    }

}
