package org.kosta.dashduowork.controller;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.dashduowork.model.service.InnService;
import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.InnVO;
import org.kosta.dashduowork.model.vo.SearchVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InnController {
	@Resource(name="innServiceImpl")
	private InnService innService;
	
	
	/*@RequestMapping(value ="selectInnByCheckedAmenity.do")
	public String selectInnByCheckedAmenity(AmenityVO vo, Model model) {
//		System.out.println(vo);
		List<InnVO> list =innService.findInnByCheckedAmenity(vo);
//		System.out.println(list);
		model.addAttribute("list", list);
		return "inn_search_result";
	}*/
	@RequestMapping(value ="selectInnByCheckedAmenity.do", method=RequestMethod.POST )
	@ResponseBody
	public List<InnVO> selectInnByCheckedAmenity(AmenityVO vo, Model model) {
		System.out.println(vo+" 는 내가 전달한 값");
		List<InnVO> list =innService.findInnByCheckedAmenity(vo);
		//model.addAttribute("list", list);
		return list;
	}
	@RequestMapping(value="searchByCityDateNo.do")
	public String searchByCityDateNo(SearchVO vo, Model model){
		System.out.println("searchByCityDateNo.do 컨트롤러 : "+vo);
		List<InnVO> list=null;
		if(vo.getStartDate()==""){
			//날짜 안들어간경우		
			list=innService.findInnByCityAndAcceptableNo(vo);
		}else{//날짜 들어간경우
			list=innService.findInnByCityAndDateAndAcceptableNo(vo);
		}
		model.addAttribute("list", list);
		return "inn_search_result";
	}
	
}

