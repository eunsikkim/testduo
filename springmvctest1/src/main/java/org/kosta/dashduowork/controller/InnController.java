package org.kosta.dashduowork.controller;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.dashduowork.model.service.InnService;
import org.kosta.dashduowork.model.vo.FilterVO;
import org.kosta.dashduowork.model.vo.InnListVO;
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
	public InnListVO selectInnByCheckedAmenity(FilterVO vo, Model model) {
		InnListVO innListVO=new InnListVO();
		if(vo.getAmenityBBQ().equals("N")&vo.getAmenityBed().equals("N")&vo.getAmenityKitchen().equals("N")&vo.getAmenityTV().equals("N")&vo.getAmenityWiFi().equals("N")){
			System.out.println("체크값 없어서 컨트롤러에서 다른곳으로 빠짐.");
			SearchVO svo=new SearchVO();
			svo.setAcceptableNo(vo.getFirstSearchPeopleNo());
			svo.setEndDate(vo.getFirstSearchEndDate());
			svo.setInnCity(vo.getFirstSearchCity());
			svo.setStartDate(vo.getFirstSearchStartDate());
			if(svo.getStartDate()==""){
				//날짜 안들어간경우		
				innListVO=innService.findInnByCityAndAcceptableNo(svo);
			}else{//날짜 들어간경우
				innListVO=innService.findInnByCityAndDateAndAcceptableNo(svo);
			}
			model.addAttribute("searchVO", svo);
		}else{
			if(vo.getFirstSearchStartDate()==""){//날짜 없는경우
				//서브쿼리 이용해서 도시+인원검색 후 결과를 filter처리 parameterType으로 새로운 VO를 만들거나 기존 VO에 변수 추가해야할듯
				innListVO=innService.findInnByCityAndAcceptableNoWithFilter(vo);
			}else{//날짜 들어간경우
				//서브쿼리 이용해서 도시+날짜+인원검색 후 결과를 filter처리
				innListVO=innService.findInnByCityAndDateAndAcceptableNoWithFilter(vo);
			}
		}
		//model.addAttribute("list", list);
		//System.out.println("결과 list 확인 : "+list);
		return innListVO;
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
	
//	@RequestMapping(value="searchByCityDateNo.do")
//	public String searchByCityDateNo(SearchVO vo, Model model){
//		System.out.println("searchByCityDateNo.do 컨트롤러 : "+vo);
//		List<InnVO> list=null;
//		if(vo.getStartDate()==""){
//			//날짜 안들어간경우		
//			list=innService.findInnByCityAndAcceptableNo(vo);
//		}else{//날짜 들어간경우
//			list=innService.findInnByCityAndDateAndAcceptableNo(vo);
//		}
//		model.addAttribute("list", list);
//		model.addAttribute("searchVO", vo);
//		return "inn_search_result";
//	}
	
	@RequestMapping(value="searchByCityDateNo.do")
	public String searchByCityDateNo(SearchVO vo, Model model){
		InnListVO innListVO=new InnListVO();
		if(vo.getStartDate()==""){
			//날짜 안들어간경우		
			System.out.println("날짜 안들어간 컨트롤러의 값 확인");
			innListVO=innService.findInnByCityAndAcceptableNo(vo);
			System.out.println(innListVO.getInnList());
		}else{//날짜 들어간경우
			innListVO=innService.findInnByCityAndDateAndAcceptableNo(vo);
		}
		model.addAttribute("innListVO", innListVO);
		model.addAttribute("searchVO", vo);
		return "inn_search_result";
	}
}

