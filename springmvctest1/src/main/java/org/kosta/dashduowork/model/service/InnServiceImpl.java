package org.kosta.dashduowork.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.dashduowork.model.dao.InnDAO;
import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.InnVO;
import org.kosta.dashduowork.model.vo.SearchVO;
import org.springframework.stereotype.Service;

@Service
public class InnServiceImpl implements InnService {
	@Resource(name = "innDAOImpl")
	private InnDAO innDAO;
	
	@Override
	public List<InnVO> findInnByCheckedAmenity(AmenityVO vo) {
		System.out.println("Service의 findInnByCheckedAmenity");
		List<InnVO> list =  innDAO.selectInnByCheckedAmenity(vo);
		System.out.println(list);
		return list;
	}
	
	//plus+++++++++++++++++++++++++++++++++++++++++++
	public List<InnVO> findInnByCityAndAcceptableNo(SearchVO vo) {
		System.out.println("Service의 selectInnByCityAndDate");
		List<InnVO> list =  innDAO.selectInnByCityAndAcceptableNo(vo);
		System.out.println(list);
		return list;
	}
	public List<InnVO> findInnByCityAndDateAndAcceptableNo(SearchVO vo){
		System.out.println("Service의 selectInnByCityAndDateAndAcceptableNo");
		List<InnVO> list =  innDAO.selectInnByCityAndDateAndAcceptableNo(vo);
		System.out.println(list);
		return list;
	}

}
