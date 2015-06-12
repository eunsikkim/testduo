package org.kosta.springmvctest1;

import java.util.List;

import org.kosta.dashduowork.model.dao.InnDAO;
import org.kosta.dashduowork.model.dao.MemberDAO;
import org.kosta.dashduowork.model.vo.InnVO;
import org.kosta.dashduowork.model.vo.SearchVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("test.xml");
		MemberDAO mdao=(MemberDAO)ctx.getBean("memberDAOImpl");
		InnDAO idao=(InnDAO)ctx.getBean("innDAOImpl");
		SearchVO svo=new SearchVO("수원","2015-05-15","2015-06-05","5");
		List<InnVO> list=idao.selectInnByCityAndDate(svo);
		System.out.println(list);
	}

}
