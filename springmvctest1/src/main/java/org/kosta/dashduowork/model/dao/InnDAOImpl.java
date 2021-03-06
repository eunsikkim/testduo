package org.kosta.dashduowork.model.dao;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.FilterVO;
import org.kosta.dashduowork.model.vo.InnPicCompVO;
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
	
	// 6/15일 추가내용******************
	public List<InnVO> selectInnByCityAndDateAndAcceptableNoWithFilter(FilterVO vo){ //지역&날짜&인원+필터
		return sqlSessionTemplate.selectList("inn.selectInnByCityAndDateAndAcceptableNoWithFilter", vo);
	}
	public List<InnVO> selectInnByCityAndAcceptableNoWithFilter(FilterVO vo){ //지역&인원+필터
		return sqlSessionTemplate.selectList("inn.selectInnByCityAndAcceptableNoWithFilter", vo);
	}
}
