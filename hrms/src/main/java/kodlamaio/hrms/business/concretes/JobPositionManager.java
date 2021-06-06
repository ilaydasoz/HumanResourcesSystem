package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobPositionDao;
	
	public JobPositionManager(){
		
	}

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Job positions listed.");
		
	}
	
	@Override
	public DataResult<JobPosition> getbyId(int id) {
		
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.getById(id));
		
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if(jobPosition.getName() == null || jobPosition.getName() == "") {
			
			return new ErrorResult("Position name can not be left blank!");
			
		}
		
		if(jobPosition.getName() != null) {
			
			return new ErrorResult("This position already exist!");
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Position added.");
		
	}

	@Override
	public Result update(JobPosition jobPosition) {
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Position updated.");
		
	}

	@Override
	public Result delete(JobPosition jobPosition) {
		
		this.jobPositionDao.delete(jobPosition);
		return new SuccessResult("Position deleted.");
		
	}


	
		

}
