package cn.itcast.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

@Service
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {

//	@Resource
//	private DepartmentDao departmentDao;
//
//	public void delete(Long id) {
//		departmentDao.delete(id);
//	}
//
//	public List<Department> findAll() {
//		return departmentDao.findAll();
//	}
//
//	public Department getById(Long id) {
//		if (id == null) {
//			return null;
//		} else {
//			return departmentDao.getById(id);
//		}
//	}
//
//	public void save(Department department) {
//		departmentDao.save(department);
//	}
//
//	public void update(Department department) {
//		departmentDao.update(department);
//	}

	public List<Department> findTopList() {
		return getSession().createQuery(//
				"From Department d where d.parent is null")
				.list();
	}

	public List<Department> findChildren(Long parentId) {
		return getSession().createQuery("From Department d where d.parent.id = ?")
				.setParameter(0, parentId)
				.list();
	}

}
