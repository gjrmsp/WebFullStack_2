package com.google.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.s1.util.ActionForward;

public class BankBookService {

	private BankBookDAO bankbookDAO;

	public void setBankbookDAO(BankBookDAO bankbookDAO) {
		this.bankbookDAO = bankbookDAO;
	}

	public ActionForward setWrite(HttpServletRequest request) throws Exception{
		ActionForward ActionForward = new ActionForward();
		System.out.println("setWrite");
		//GET
		ActionForward.setPath("../WEB-INF/bankbook/bankbookWrite.jsp");
		ActionForward.setCheck(true);

		if(request.getMethod().toUpperCase().equals("POST")) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookname(request.getParameter("bookName"));
			bankBookDTO.setBookrate(Double.parseDouble(request.getParameter("bookRate")));
			bankBookDTO.setBooksale(request.getParameter("bookSale"));
			//DAO 작업
			int result = bankbookDAO.setWrite(bankBookDTO);
			ActionForward.setPath("./bankbookList.do");
			ActionForward.setCheck(false);
		}
		return ActionForward;
	}

	public ActionForward getSelect(HttpServletRequest request)throws Exception{
		ActionForward ActionForward = new ActionForward();

		long bookNumber = Long.parseLong(request.getParameter("bookNumber"));

		BankBookDTO bankBookDTO = bankbookDAO.getSelect(bookNumber);

		ActionForward.setCheck(true);
		ActionForward.setPath("../WEB-INF/bankbook/bankbookSelect.jsp");
		request.setAttribute("dto", bankBookDTO);

		return ActionForward;
	}

	//BankList DAO의 getList 호출
	public ActionForward getList(HttpServletRequest request) throws Exception {
		ActionForward actionForward = new ActionForward();
		List<BankBookDTO> ar = bankbookDAO.getList();

		request.setAttribute("list", ar);
		actionForward.setPath("../WEB-INF/bankbook/bankbookList.jsp");
		actionForward.setCheck(true);

		return actionForward;
	}

}