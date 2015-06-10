package org.kosta.dashduowork.model.dao;

import org.kosta.dashduowork.model.vo.InnVO;

public interface InnDAO {
	public abstract InnVO selectInnByCityAndAcceptableNo(InnVO vo);

}