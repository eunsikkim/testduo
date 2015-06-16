package org.kosta.dashduowork.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.dashduowork.model.dao.InnDAO;
import org.kosta.dashduowork.model.dao.InnPicCompDAO;
import org.kosta.dashduowork.model.vo.AmenityVO;
import org.kosta.dashduowork.model.vo.FilterVO;
import org.kosta.dashduowork.model.vo.InnListVO;
import org.kosta.dashduowork.model.vo.InnPicCompVO;
import org.kosta.dashduowork.model.vo.InnVO;
import org.kosta.dashduowork.model.vo.SearchVO;
import org.springframework.stereotype.Service;

@Service
public class InnServiceImpl implements InnService {
	@Resource(name = "innDAOImpl")
	private InnDAO innDAO;
	@Resource(name="innPicCompDAOImpl")
	private InnPicCompDAO innPicCompDAO;
	
	@Override
	public List<InnVO> findInnByCheckedAmenity(AmenityVO vo) {
		System.out.println("Service의 findInnByCheckedAmenity");
		List<InnVO> list =  innDAO.selectInnByCheckedAmenity(vo);
		System.out.println(list);
		return list;
	}
	
	//plus+++++++++++++++++++++++++++++++++++++++++++
//	public List<InnVO> findInnByCityAndAcceptableNo(SearchVO vo) {
//		System.out.println("Service의 selectInnByCityAndDate");
//		List<InnVO> list =  innDAO.selectInnByCityAndAcceptableNo(vo);
//		System.out.println(list);
//		return list;
//	}
//	public List<InnVO> findInnByCityAndDateAndAcceptableNo(SearchVO vo){
//		System.out.println("Service의 selectInnByCityAndDateAndAcceptableNo");
//		List<InnVO> list =  innDAO.selectInnByCityAndDateAndAcceptableNo(vo);
//		System.out.println(list);
//		return list;
//	}
	public InnListVO findInnByCityAndAcceptableNo(SearchVO vo) {
		InnListVO innListVO=new InnListVO();
		List<InnVO> innList =  innDAO.selectInnByCityAndAcceptableNo(vo);
		System.out.println("서비스에서 메서드 확인");
		for (int i=0;i<innList.size();i++) {
			int innNo=innList.get(i).getInnNo();
			System.out.println("list.getInnNo 확인 : "+innNo);
			innList.get(i).setInnMainPic(innPicCompDAO.getMyPicList(innNo));
		}
		innListVO.setInnList(innList);
		System.out.println("숙소리스트 : "+innList);

		return innListVO;
	}
	public InnListVO findInnByCityAndDateAndAcceptableNo(SearchVO vo){
		InnListVO innListVO=new InnListVO();
		List<InnVO> innList =  innDAO.selectInnByCityAndDateAndAcceptableNo(vo);
		for (int i=0;i<innList.size();i++) {
			int innNo=innList.get(i).getInnNo();
			innList.get(i).setInnMainPic(innPicCompDAO.getMyPicList(innNo));
		}
		innListVO.setInnList(innList);
		return innListVO;
	}
	
	
//	//6/15일 추가내용
//	public List<InnVO> findInnByCityAndDateAndAcceptableNoWithFilter(FilterVO vo){ //지역&날짜&인원+필터
//		List<InnVO> list =  innDAO.selectInnByCityAndDateAndAcceptableNoWithFilter(vo);
//		return list;
//	}
//	public List<InnVO> findInnByCityAndAcceptableNoWithFilter(FilterVO vo){ //지역&날짜&인원+필터
//		List<InnVO> list =  innDAO.selectInnByCityAndAcceptableNoWithFilter(vo);
//		return list;
//	}
	
	//6/16일 추가(위의 기존 메서드의 반환타입을 InnListVO로 만들어서 InnList와 PicComp 같이 전달
	public InnListVO findInnByCityAndDateAndAcceptableNoWithFilter(FilterVO vo){ //지역&날짜&인원+필터
		InnListVO innListVO=new InnListVO();
		List<InnVO> innList =  innDAO.selectInnByCityAndDateAndAcceptableNoWithFilter(vo);
		for (int i=0;i<innList.size();i++) {
			int innNo=innList.get(i).getInnNo();
			innList.get(i).setInnMainPic(innPicCompDAO.getMyPicList(innNo));
		}
		innListVO.setInnList(innList);
		return innListVO;
	}
	public InnListVO findInnByCityAndAcceptableNoWithFilter(FilterVO vo){ //지역&날짜&인원+필터
		InnListVO innListVO=new InnListVO();
		List<InnVO> innList =  innDAO.selectInnByCityAndAcceptableNoWithFilter(vo);
		for (int i=0;i<innList.size();i++) {
			int innNo=innList.get(i).getInnNo();
			innList.get(i).setInnMainPic(innPicCompDAO.getMyPicList(innNo));
		}
		innListVO.setInnList(innList);
		return innListVO;
	}
	
}
