package org.kosta.springmvctest1;

import org.kosta.dashduowork.model.dao.InnPicCompDAO;
import org.kosta.dashduowork.model.dao.MemberDAO;
import org.kosta.dashduowork.model.service.InnService;
import org.kosta.dashduowork.model.vo.InnListVO;
import org.kosta.dashduowork.model.vo.SearchVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("test.xml");
		MemberDAO mdao=(MemberDAO)ctx.getBean("memberDAOImpl");
		InnService iService=(InnService)ctx.getBean("innServiceImpl");
		InnPicCompDAO ipCompDAO=(InnPicCompDAO)ctx.getBean("innPicCompDAOImpl");
		SearchVO svo=new SearchVO("수원","2");
//		System.out.println(ipCompDAO.getMyPicList(1));
		InnListVO innListVO=new InnListVO();
		innListVO=iService.findInnByCityAndAcceptableNo(svo);
		
	}

}
