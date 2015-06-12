package org.kosta.dashduowork.model.dao;

import java.util.List;

import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.InnVO;
import org.kosta.dashduowork.model.vo.SearchVO;

public interface InnDAO {
	public abstract List<InnVO> selectInnByCityAndAcceptableNo(InnVO vo);
	public abstract List<InnVO> selectInnByCheckedAmenity(AmenityVO vo);
	public abstract List<InnVO> selectInnByCityAndDate(SearchVO vo);
	public abstract List<InnVO> selectInnByCityAndDateAndAcceptableNo(SearchVO vo);

}