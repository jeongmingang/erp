package erp.service;

import java.util.List;

import erp.dao.DepartmentDao;
import erp.dao.EmployeeDao;
import erp.dao.impl.DepartmentDaoImpl;
import erp.dao.impl.EmployeeDaoImpl;
import erp.dto.Department;
import erp.dto.Employee;

public class DeptService {
	private DepartmentDao dao = DepartmentDaoImpl.getInstance();
	private EmployeeDao empDao = EmployeeDaoImpl.getInstance();
	
	public List<Department> showDepartment() {
		return dao.selectDepartmentByAll();
	}
	
	public List<Department> showDeptList(){
		return dao.selectDepartmentByAll();
	}
	
	public void addDepartment(Department dept) {
		dao.insertDepartment(dept);
	}
	
	public void removeDepartment(Department dept) {
		dao.deleteDepartment(dept);
	}
	
	public void modifyDepartment(Department dept) {
		dao.updateDepartment(dept);
	}
	
	public List<Employee> showEmployeeGroupByDepartment(Department dept){
		return empDao.selectEmployeeByDept(dept);
	}
}
