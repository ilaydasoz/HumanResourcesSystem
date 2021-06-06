package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Employees listed.");
		
	}
	
	@Override
	public DataResult<Employee> getById(int id) {
	
		return new SuccessDataResult<Employee>(this.employeeDao.getById(id));
		
	}

	@Override
	public Result add(Employee employee) {
		
		this.employeeDao.save(employee);
		return new SuccessResult("Employee added.");
		
	}


	@Override
	public Result delete(Employee employee) {
		
		this.employeeDao.delete(employee);
		return new SuccessResult("Employee deleted.");
		
	}

	@Override
	public Result update(Employee employee) {
		
		this.employeeDao.save(employee);
		return new SuccessResult("Employee updated.");
		
	}

}
