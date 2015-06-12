package org.kosta.dashduowork.model.service;

import java.util.List;

import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.InnVO;

public interface InnService {
	public List<InnVO> findInnByCheckedAmenity(AmenityVO vo);
}
