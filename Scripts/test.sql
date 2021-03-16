select user (), database ();

show tables;

desc title;
desc department; 
desc employee;

-- title
select tno, tname from title;
select tno, tname from title where tno = 1;

update title set tname = '계약직' where tno = 6;
delete from title where tno = 6;
insert into title values(6,'인턴');

-- join (selectSameTitleEmployeeByTitleNo) 
select tno, tname, empno, empname, title, manager, salary, dept
	from title t join employee e on t.tno =e.title
 where t.tno = 3;

-- department
select deptNo, deptName, floor from department;
select deptNo, deptName, floor from department where deptno = 1;

update department set deptName = '회계' where deptNo = 5;
delete from department where deptNo = 5;
insert into department values(5, '마케팅', 20);


-- employee
select empno, empname, title, manager, salary, dept from employee;
select empno, empname, title, manager, salary, dept from employee where empno = 2106;

insert into employee values(1004, '박규영', 5, 1003, 2000000, 3);
update employee 
set empname = '천사', title = 3, manager = 4377, salary = 4000000, dept = 2
where empno = 1004;
delete from employee where empno = 1004;

-- employee join
select e.*, t.*, m.empno, m.empname, d.*
from employee e join title t on e.title = t.tno 
	left join employee m on e.manager = m.empno 
	join department d on e.dept= d.deptno;

--

create or replace view vw_full_employee
as
select e.empno
     , e.empname
     , t.tno as title_no
     , t.tname as title_name
     , e.manager as manager_no
     , m.empname as manager_name
     , e.salary
     , d.deptNo
     , d.deptName
     , d.floor
  from employee e join title t on e.title = t.tno
       left join employee m on e.manager = m.empno 
       join department d on e.dept = d.deptNo ;

select empno, empname, title_no, title_name, manager_no, manager_name, salary, deptNo, deptName, floor 
from vw_full_employee;

drop view vw_full_employee;

select empno, empname, title as title_no,
manager as manager_no, salary, dept as deptNo 
from employee
where empno = 1003;
    	
select * from vm_employee;


select * from title;

select *
  from employee
 where empno = 1003;

-- 해당 직책을 가지고 있는 사원목록을 검색
select empname, empno
  from employee e 
  join title t
    on e.title  = t.tno
 where tno = 5;
 
-- 해당 부서 소속된 사원목록을 검색
select empname, empno, deptno
  from employee e 
  join department d
    on e.dept = d.deptNo 
 where dept = 2;

-- 해당 직책별 사원수
select tname, count(*) as 사원수
  from title t left join employee e on t.tno = e.title 
 group by tno;
 
-- pass 길이 확인
-- 단반향 함수(Hash:MDS)
select password('asdaafsdafdaf'), length(password('asdaafsdafdaf')) from dual;

select password('1234'); 

-- emp_detail insert
INSERT INTO erp.emp_detail (empno, pic, gender, hiredate, pass)
VALUES(?, ?, ?, ?, ?);

delete from emp_detail where empno = 1003;

select empno, pic, gender, hiredate, pass from emp_detail where empno = 1003;

-- emp_detail update
UPDATE erp.emp_detail
SET pic = ?, gender = ?, hiredate = ?, pass = ?
WHERE empno = ?;

select * from emp_detail;



