package org.kosta.springmvctest1;

import java.util.List;

import org.kosta.dashduowork.model.dao.InnDAO;
import org.kosta.dashduowork.model.dao.MemberDAO;
import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.InnVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("test.xml");
		MemberDAO mdao=(MemberDAO)ctx.getBean("memberDAOImpl");
		InnDAO idao=(InnDAO)ctx.getBean("innDAOImpl");
//		InnVO ivo=new InnVO("성남","10000");
		InnVO vo=null;
//		MemberVO mvo=new MemberVO("oldtype","oldtype");
//		System.out.println(mvo);
//		MemberVO vo=mdao.login(mvo);
//		System.out.println(vo);
	}

}
