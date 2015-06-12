package org.kosta.dashduowork.model.service;

import java.util.List;

import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.InnVO;
import org.kosta.dashduowork.model.vo.SearchVO;

public interface InnService {
	public List<InnVO> findInnByCheckedAmenity(AmenityVO vo);
	public List<InnVO> findInnByCityAndAcceptableNo(SearchVO vo);
	public List<InnVO> findInnByCityAndDateAndAcceptableNo(SearchVO vo);
}
