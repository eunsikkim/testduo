package org.kosta.dashduowork.controller;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.dashduowork.model.service.InnService;
import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.FilterVO;
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
	
	
	//테스트중인 메서드
	@RequestMapping(value ="selectInnByCheckedAmenity.do", method=RequestMethod.POST )
	@ResponseBody
	public List<InnVO> selectInnByCheckedAmenity(FilterVO vo, Model model) {
		/*String searchCity = request.getParameter("firstSearchCity");
		String searchStartDate = request.getParameter("firstSearchStartDate");
		String searchEndDate = request.getParameter("firstSearchEndDate");
		String searchPeopleNo = request.getParameter("firstSearchPeopleNo");
		System.out.println("검색폼에서 1차 searchVO 넘어오는지 확인 : "+searchCity+" "+searchStartDate+" "+searchEndDate+" "+searchPeopleNo);*/
		System.out.println("FilterVO내용확인 : "+vo);
		System.out.println(vo+" 는 내가 전달한 값");
//		if(searchStartDate==""){//날짜 없는경우
//			//서브쿼리 이용해서 도시+인원검색 후 결과를 filter처리 parameterType으로 새로운 VO를 만들거나 기존 VO에 변수 추가해야할듯
//		}else{//날짜 들어간경우
//			//서브쿼리 이용해서 도시+날짜+인원검색 후 결과를 filter처리
//		}
		AmenityVO avo=new AmenityVO();
		List<InnVO> list =innService.findInnByCheckedAmenity(avo);
		//model.addAttribute("list", list);
		return list;
	}
	
	//잘 되는 메서드
//	@RequestMapping(value ="selectInnByCheckedAmenity.do", method=RequestMethod.POST )
//	@ResponseBody
//	public List<InnVO> selectInnByCheckedAmenity(HttpServletRequest request, AmenityVO vo, Model model) {
//		String searchVO = request.getParameter("searchVO");
//		System.out.println("검색폼에서 1차 searchVO 넘어오는지 확인 : "+searchVO);
//		System.out.println(vo+" 는 내가 전달한 값");
//		List<InnVO> list =innService.findInnByCheckedAmenity(vo);
//		//model.addAttribute("list", list);
//		return list;
//	}
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
		model.addAttribute("searchVO", vo);
		return "inn_search_result";
	}
	
}

