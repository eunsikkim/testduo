package org.kosta.dashduowork.model.dao;

import java.util.List;

import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.InnVO;

public interface InnDAO {
	public abstract List<InnVO> selectInnByCityAndAcceptableNo(InnVO vo);
	public abstract List<InnVO> selectInnByCheckedAmenity(AmenityVO vo);

}