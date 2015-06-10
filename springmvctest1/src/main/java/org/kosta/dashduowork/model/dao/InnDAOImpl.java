package org.kosta.dashduowork.model.dao;

import javax.annotation.Resource;

import org.kosta.dashduowork.model.vo.InnVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InnDAOImpl implements InnDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;	

	@Override
	public InnVO selectInnByCityAndAcceptableNo(InnVO vo) {
		return (InnVO) sqlSessionTemplate.selectOne("inn.selectInnByCityAndAcceptableNo", vo);
	}
	
}
