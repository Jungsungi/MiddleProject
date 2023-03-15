package com.example.project2.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.project2.vo.AlarmVO;
import com.example.project2.vo.HouseVO;
import com.example.project2.vo.ImgVO;
import com.example.project2.vo.InsertHouseVO;
import com.example.project2.vo.InterestVO;
import com.example.project2.vo.MemberVO;
import com.example.project2.vo.MgrVO;
import com.example.project2.vo.OptVO;
import com.example.project2.vo.RecomentVO;
import com.example.project2.vo.RecommendVO;
import com.example.project2.vo.SecurityVO;

public class DBManager {
	static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "com/example/project2/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
	}
	
	//house_no로 매물의 정보 불러오는 메소드
	public static HouseVO detailHouse(int house_no) {
		SqlSession session = sqlSessionFactory.openSession();
		HouseVO houseVO = session.selectOne("house.findByHouseNo", house_no);
		session.close();
		return houseVO;
	}
	
	//house_no로 매물의 이미지 불러오는 메소드
	public static List<ImgVO> findImgByHouseNo(int house_no){
		SqlSession session = sqlSessionFactory.openSession();
		List<ImgVO> list = session.selectList("img.findByHouseNo",house_no);
		session.close();
		return list;
	}
	
	//house_no로 매물을 올린 회원 찾는 메소드
	public static String findId(int house_no) {
		SqlSession session = sqlSessionFactory.openSession();
		String id = session.selectOne("house.findId", house_no);
		session.close();
		return id;
	}
	
	//house_no로 해당 매물의 관리비 항목을 불러오는 메소드
	public static MgrVO findMgrByHouseNo(int house_no){
		SqlSession session = sqlSessionFactory.openSession();
		MgrVO mgrVO = session.selectOne("mgr.findByHouseNo", house_no);
		session.close();
		return mgrVO;
	}
	
	//house_no로 해당 매물의 옵션 항목을 불러오는 메소드
	public static OptVO findOptByHouseNo(int house_no){
		SqlSession session = sqlSessionFactory.openSession();
		OptVO optVO = session.selectOne("opt.findByHouseNo",house_no);
		session.close();
		return optVO;
	}
	
	//house_no로 해당 매물의 보안 항목을 불러오는 메소드
	public static SecurityVO findSeqByHouseNo(int house_no){
		SqlSession session = sqlSessionFactory.openSession();
		SecurityVO seqVO = session.selectOne("seq.findByHouseNo",house_no);
		session.close();
		return seqVO;
	}
	
	//house_no로 해당 매물에 달린 댓글을 불러오는 메소드
	public static List<RecomentVO> findRecomentByHouseNo(int house_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<RecomentVO> list = session.selectList("recoment.findByHouseNo", house_no);
		session.close();
		return list;
	}
	
	//매물에 새로운 댓글을 등록하는 메소드
	public static int insertRecoment(RecomentVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int re = session.insert("recoment.insertRecoment", vo);
		session.commit();
		session.close();
		return re;		
	}
	
	//댓글번호로 매물에 달린 댓글을 삭제하는 메소드
	public static int deleteRecoment(int reno) {
		SqlSession session = sqlSessionFactory.openSession();
		int re = session.delete("recoment.deleteRecoment",reno);
		session.commit();
		session.close();
		return re;
	}
	
	//조회수가 높은 매물을 추천해주는 메소드
	public static List<RecommendVO> recommendHouse(){
		SqlSession session = sqlSessionFactory.openSession();
		List<RecommendVO> list = session.selectList("recommend.findByHit");
		session.close();
		return list;
	}
	
	//id로 해당 회원의 전화번호를 찾는 메소드
	public static String getPhone(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		String phone = session.selectOne("member.phoneNumber", id);
		session.close();
		return phone;
	}
	
	//회원가입 하는 메소드
	public static int insertMember(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int re = session.insert("member.insertMember", vo);
		session.commit();
		session.close();
		return re;
	}
	
	//로그인 시 회원이 맞는지 확인하는 메소드
	public static MemberVO loginCheck(HashMap<String, String> map) {
		SqlSession session = sqlSessionFactory.openSession();
		MemberVO vo = session.selectOne("member.loginCheck",map);
		session.close();
		return vo;
	}
	
	//id로 회원이 존재하는지 확인하는 메소드
	public static MemberVO idCheck(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		MemberVO vo = session.selectOne("member.idCheck", id);
		session.close();
		return vo;
	}
	
	//회원이 매물을 관심목록에 등록하는 메소드
	public static int insertInter(InterestVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int re = session.insert("inter.insertInter", vo);
		session.commit();
		session.close();
		return re;
	}
	
	//회원이 올린 매물에 댓글이 등록되었을 때 알림이 생기는 메소드
	public static int insertAlarm_recoment(AlarmVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int re = session.insert("alarm.insertAlarm_recoment",vo);
		session.commit();
		session.close();
		return re;
	}
	
	//회원이 올린 매물이 관심목록에 등록되었을 때 알림이 생기는 메소드
	public static int insertAlarm_inter(AlarmVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int re = session.insert("alarm.insertAlarm_inter",vo);
		session.commit();
		session.close();
		return re;
	}
	
	//새로운 매물을 등록하는 메소드
	public static int insertHouse(InsertHouseVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int re = session.insert("house.insertHouse", vo);
		session.commit();
		session.close();
		return re;
	}
	
	//새로운 매물을 등록할 때 해당하는 관리비가 등록되는 메소드
	public static int insertMgr(MgrVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int re = session.insert("mgr.insertMgr", vo);
		session.commit();
		session.close();
		return re;
	}
	
	//새로운 매물을 등록할 때 해당하는 옵션이 등록되는 메소드
	public static int insertOpt(OptVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int re = session.insert("opt.insertOpt", vo);
		session.commit();
		session.close();
		return re;
	}
	
	//새로운 매물을 등록할 때 해당하는 보안항목이 등록되는 메소드
	public static int insertSeq(SecurityVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int re = session.insert("seq.insertSeq", vo);
		session.commit();
		session.close();
		return re;
	}
	
	//새로운 매물을 등록할 때 해당하는 이미지를 등록하는 메소드
	public static int insertImg(ImgVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int re = session.insert("img.insertImg", vo);
		session.commit();
		session.close();
		return re;
	}
	
	//새로운 매물을 등록할 때 db에 존재하는 매물번호의 다음 번호를 가져오는 메소드
	public static int getNextNo() {
		SqlSession session = sqlSessionFactory.openSession();
		int no = session.selectOne("house.getNextNo");
		session.close();
		return no;
	}
	
	//회원에게 온 모든 알림을 조회하는 메소드
	public static List<AlarmVO> findAlarmById(String id){
		SqlSession session = sqlSessionFactory.openSession();
		List<AlarmVO> list = session.selectList("alarm.findById", id);
		session.close();
		return list;
	}
	
	//회원에게 온 알림을 알림 유형에 따라 조회하는 메소드
	public static List<AlarmVO> findAlarmByIdAndType(Map<String, String> map){
		SqlSession session = sqlSessionFactory.openSession();
		List<AlarmVO> list = session.selectList("alarm.findByIdAndType", map);
		session.close();
		return list;
	}
	
	//회원이 등록한 관심목록을 조회하는 메소드
	public static List<InterestVO> findInterById(String id){
		SqlSession session = sqlSessionFactory.openSession();
		List<InterestVO> list = session.selectList("inter.findById", id);
		session.close();
		return list;
	}
	
}
