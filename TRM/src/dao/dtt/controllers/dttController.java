package dao.dtt.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.dtt.DDTProject.DTTNewRequestCard;
import dao.dtt.DDTProject.DTTProcessingCard;
import dao.dtt.DDTProject.DTTdaoServices;
import bl.SecurityCheck;

@Controller
public class dttController {
	
//	@RequestMapping(value="/")
//	public String login_view()
//	{
//		System.out.println("login_view");
//		return "TRM_DTT_Homepage";
//	}
	
	@RequestMapping(value="/")
	public String showall_view(ModelMap map)
	{
		List<DTTProcessingCard> cards;
		List<DTTNewRequestCard> newReqCards;
		
		cards = new DTTdaoServices().getRequestsProcessing();
		newReqCards = new DTTdaoServices().getNewRequests();
		
		map.addAttribute("TRM_DTT_Homepage", cards);
		map.addAttribute("TRM_DTT_Homepage1", newReqCards);
		
//		List<String> names = new ArrayList<String>();
//		names.add("Name1");
//		names.add("Name2");
//		names.add("Name3");
//		names.add("Name4");
//
//		map.addAttribute("TRM_DTT_Homepage", names);
		return "TRM_DTT_Homepage";
	}
	
	@RequestMapping(value="/login")
	public String login_service(HttpServletRequest request, ModelMap model)
	{
		boolean result = SecurityCheck.isUserValid(request.getParameter("un"), request.getParameter("pw"));
		
		if(result)
		{
			model.addAttribute("result", result);
			return "TRM_DTT_Homepage";
		}
		else
			model.addAttribute("result", false);
			return "login";
	}

}
