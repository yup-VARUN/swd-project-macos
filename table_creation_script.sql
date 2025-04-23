create Database swd_company_db;

use Database swd_company_db;

create table if not exists Employees (
	emp_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    ssn VARCHAR(9),  -- No dashes, only numbers
    job_title VARCHAR(100),
    division VARCHAR(100),
    salary DECIMAL(10, 2),
    hire_date DATE
);

create table if not exists Payments (
	payment_id INT auto_increment primary KEY,
	emp_id int,
	payment_date date,
	amount int,
	foreign key (emp_id) references Employees(emp_id)
);