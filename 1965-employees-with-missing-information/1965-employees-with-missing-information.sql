# Write your MySQL query statement below
select employee_id from Employees
natural left join Salaries
where salary is null
union
select employee_id from Employees
natural right join Salaries
where name is null
order by employee_id;