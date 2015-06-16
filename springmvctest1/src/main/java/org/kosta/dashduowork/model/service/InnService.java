package org.kosta.dashduowork.model.service;

import java.util.List;

import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.FilterVO;
import org.kosta.dashduowork.model.vo.InnListVO;
import org.kosta.dashduowork.model.vo.InnVO;
import org.kosta.dashduowork.model.vo.SearchVO;

public interface InnService {
	public List<InnVO> findInnByCheckedAmenity(AmenityVO vo);
//	public List<InnVO> findInnByCityAndAcceptableNo(SearchVO vo);
//	public List<InnVO> findInnByCityAndDateAndAcceptableNo(SearchVO vo);
	public InnListVO findInnByCityAndAcceptableNo(SearchVO vo);
	public InnListVO findInnByCityAndDateAndAcceptableNo(SearchVO vo);
	//6/15일 추가
//	public List<InnVO> findInnByCityAndDateAndAcceptableNoWithFilter(FilterVO vo);
//	public List<InnVO> findInnByCityAndAcceptableNoWithFilter(FilterVO vo);
	
	public InnListVO findInnByCityAndDateAndAcceptableNoWithFilter(FilterVO vo);
	public InnListVO findInnByCityAndAcceptableNoWithFilter(FilterVO vo);
}
