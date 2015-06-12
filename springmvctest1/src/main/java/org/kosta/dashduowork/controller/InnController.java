package org.kosta.dashduowork.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.kosta.dashduowork.model.service.InnService;
import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.InnVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InnController {
	@Resource(name="innServiceImpl")
	private InnService innService;
	
	
	@RequestMapping(value ="selectInnByCheckedAmenity.do")
	public ModelAndView selectInnByCheckedAmenity(AmenityVO vo, HttpServletRequest request,ModelAndView mv) {
		System.out.println(vo);
		List<InnVO> list =innService.findInnByCheckedAmenity(vo);
		System.out.println(list);
		mv.addObject("list", list);
		mv.setViewName("inn_search_result");
		return mv;
	}
}

