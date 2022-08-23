CREATE DEFINER=`root`@`localhost` FUNCTION `get_total_worked_hours_by_employee`(employee_id INTEGER, start_date DATE, end_date DATE) RETURNS int
BEGIN

	DECLARE _total_worked_hours INTEGER;
    
    SELECT SUM(worked_hours) FROM employee_worked_hours
    WHERE worked_date between start_date AND end_date
    AND employee_id = employee_id
	INTO _total_worked_hours;
    
    RETURN _total_worked_hours;
    
END

== ==================================================================================================

CREATE DEFINER=`root`@`localhost` FUNCTION `get_pay_roll_by_employee`(employee_id INTEGER, start_date DATE, end_date DATE) RETURNS decimal(9,2)
BEGIN

    DECLARE _salary DECIMAL(9, 2);
    DECLARE _job_id INTEGER;
    DECLARE _worked_hours INTEGER;
    
    SELECT job_id FROM employees WHERE id = employee_id
    INTO _job_id;
    
    SELECT salary FROM employees.jobs WHERE id = _job_id
    INTO _salary;
    
    SELECT get_total_worked_hours_by_employee(employee_id, start_date, end_date)
    INTO _worked_hours;
    
    RETURN _salary * _worked_hours;
END