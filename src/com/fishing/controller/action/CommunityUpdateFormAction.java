package com.fishing.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fishing.dao.CommunityDAO;
import com.fishing.dto.CommunityVO;

public class CommunityUpdateFormAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//수정할때 조회수 증가하는 소스
		String communityNum = request.getParameter("communityNum");
		String url = "communityboard/communityboardUpdate.jsp";
		CommunityDAO bdao = CommunityDAO.getInstance();
		bdao.readCountUp(communityNum);
		CommunityVO cvo = bdao.selectOneBoard(communityNum);
		request.setAttribute("cboard1", cvo);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
