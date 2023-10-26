package com.ssafy.test.emp.member.model.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.test.EmployeeException;
import com.ssafy.test.emp.model.dao.EmployeeDao;
import com.ssafy.test.emp.model.dto.Employee;
import com.ssafy.test.emp.model.dto.PageBean;
import com.ssafy.test.util.PageUtility;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	private EmployeeDao dao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public void regist(Employee employee) {
		logger.debug("EmployeeServiceImpl.regist.......................");
		logger.debug("employee:{}", employee);

		try {
			Employee find = dao.search(employee.getEmpno());
			if (find != null)
				throw new EmployeeException("이미 등록된 사원번호 입니다. ");
			dao.regist(employee);
			logger.debug("EmployeeServiceImpl.regist.......................등록 OK");

		} catch (SQLException e) {
			logger.error("EmployeeServiceImpl.regist................. msg:{}", e.getMessage());
			throw new EmployeeException("사원 정보 등록 중 오류 발생");
		}

	}

	@Transactional
	@Override
	public void update(Employee employee) {
		logger.debug("EmployeeServiceImpl.update.......................");
		logger.debug("employee:{}", employee);

		try {
			Employee find = dao.search(employee.getEmpno());
			if (find == null)
				throw new EmployeeException("수정할 사원이 없습니다. ");
			dao.update(employee);
			logger.debug("EmployeeServiceImpl.update.......................등록 OK");

		} catch (SQLException e) {
			logger.error("EmployeeServiceImpl.update................. msg:{}", e.getMessage());
			throw new EmployeeException("사원 정보 수정 중 오류 발생");
		}
	}

	@Transactional
	@Override
	public void remove(int empno) {
		logger.debug("EmployeeServiceImpl.remove.......................");
		logger.debug("employee:{}", empno);

		try {
			Employee find = dao.search(empno);
			if (find == null)
				throw new EmployeeException("삭제할 사원이 없습니다. ");
			dao.remove(empno);
			logger.debug("EmployeeServiceImpl.remove.......................등록 OK");

		} catch (SQLException e) {
			logger.error("EmployeeServiceImpl.remove................. msg:{}", e.getMessage());
			throw new EmployeeException("사원 정보 삭제 중 오류 발생");
		}

	}

	@Transactional(readOnly = true)
	@Override
	public Employee search(int empno) {
		logger.error("EmployeeServiceImpl.search.............empno:{}", empno);
		try {
			Employee emp = dao.search(empno);
			if (emp == null)
				throw new EmployeeException("요청한 사원은 등록되지 않은 정보입니다. ");
			return emp;

		} catch (SQLException e) {
			logger.error("EmployeeServiceImpl.search................. msg:{}", e.getMessage());
			throw new EmployeeException("사원 정보 조회 중 오류 발생");
		}

	}

    @Transactional(readOnly = true)
    @Override
    public List<Employee> searchAll(PageBean bean) {
        logger.debug("EmployeeServiceImpl.searchAll.................................");
        try {
            int total = dao.totalCount(bean);
            PageUtility page = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "");
            bean.setPageLink(page.getPageBar());
            return dao.searchAll(bean);
        } catch (Exception e) {
        	e.printStackTrace();
            logger.error("EmployeeServiceImpl.searchAll.................................msg:{}", e.getMessage());
        }
        return null;
    }

}
