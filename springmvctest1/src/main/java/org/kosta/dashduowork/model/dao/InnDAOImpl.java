package org.kosta.dashduowork.model.dao;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.InnVO;
import org.kosta.dashduowork.model.vo.SearchVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InnDAOImpl implements InnDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<InnVO> selectInnByCityAndAcceptableNo(InnVO vo) {
		return sqlSessionTemplate.selectList("inn.selectInnByCityAndAcceptableNo", vo);
	}

	@Override
	public List<InnVO> selectInnByCheckedAmenity(AmenityVO vo) {
		return sqlSessionTemplate.selectList("inn.selectInnByCheckedAmenity", vo);
	}	
	//plus+++++++++++++++++++++++++++++++++++++++++++
	public List<InnVO> selectInnByCityAndAcceptableNo(SearchVO vo){
		return sqlSessionTemplate.selectList("inn.selectInnByCityAndAcceptableNo", vo);
	}
	public List<InnVO> selectInnByCityAndDateAndAcceptableNo(SearchVO vo){
		return sqlSessionTemplate.selectList("inn.selectInnByCityAndDateAndAcceptableNo", vo);
	}
}
