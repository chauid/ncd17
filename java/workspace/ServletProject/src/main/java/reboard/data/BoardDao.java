package reboard.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.db.ConnectionManager;

public class BoardDao {
ConnectionManager connectionManager=ConnectionManager.getInstance();
	
	SqlSession session;
	String nameSpace="reboard.data.BoardDao.";
	
	private SqlSession getSession()
	{
		session=connectionManager.openSession();
		return session;
	}
	
	public int getMaxNum()
	{
		session=getSession();
		int n=session.selectOne(nameSpace+"getMaxNum");
		session.close();
		return n;
	}
	
	public int getTotalCount()
	{
		session=getSession();
		int n=session.selectOne(nameSpace+"totalCount");
		session.close();
		return n;
	}
	
	public List<BoardDto> getPagingList(int start,int perpage)
	{
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);		
		
		session=getSession();
		List<BoardDto> list=session.selectList(nameSpace+"selectPagingList", map);
		session.close();
		return list;
	}
	
	public void updateRestep(int regroup,int restep)
	{
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("regroup", regroup);
		map.put("restep", restep);	
		session=getSession();
		session.update(nameSpace+"updateRestep",map);
		session.close();
	}
	
	public void insertBoard(BoardDto dto)
	{
		int num=dto.getNum();
		int regroup=dto.getRegroup();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		if(num==0)//새글이라는 의미(null 일때 0으로 변경후 보낼것임)
		{
			regroup=this.getMaxNum()+1;
			restep=0;
			relevel=0;
		}else//답글일경우			
		{
			//같은 그룹중 전달받은 restep 보다 큰데이타는 모두 +1을 해준다
			this.updateRestep(regroup, restep);
			//그후에 전달받은 레벨과 스텝을 1 증가한다
			restep++;
			relevel++;
		}
		
		//변경된 데이타들을 다시 dto 에 넣는다
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		session=getSession();
		session.insert(nameSpace+"insertBoard",dto);
		session.close();
	}
	
	public void updateReadCount(int num)
	{
		session=getSession();
		session.update(nameSpace+"updateReadCount", num);
		session.close();
	}
	
	public BoardDto getData(int num)
	{
		session=getSession();		
		BoardDto dto=session.selectOne(nameSpace+"selectOneByNum", num);
		session.close();
		return dto;
	}
	
	public boolean isCheckPass(int num,String passwd)
	{
		boolean b;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", num);
		map.put("passwd", passwd);
		
		session=getSession();
		int n=session.selectOne(nameSpace+"checkPass", map);
		session.close();
		return n==1?true:false;		
	}	
	
	public void deleteBoard(int num)
	{
		session=getSession();
		session.delete(nameSpace+"deleteBoard", num);
		session.close();
	}
	
	public void updateBoard(BoardDto dto)
	{
		session=getSession();
		session.update(nameSpace+"updateBoard", dto);
		session.close();				
	}
}











































