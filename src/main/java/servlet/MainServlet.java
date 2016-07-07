package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/servlet")
public class MainServlet extends HttpServlet {

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		//get user input
		String startDateParam = req.getParameter("start");
		String endDateParam = req.getParameter("end");
			
		Date startDate;
		Date endDate;
			
		//convert to dates
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try{
			startDate = df.parse(startDateParam);
			endDate = df.parse(endDateParam);
		}
		catch (Exception e) 
		{
			req.setAttribute("errormsg", e.getMessage());
			RequestDispatcher view = req.getRequestDispatcher("error.jsp");  
			view.forward(req, resp);
			return;
		}
			
		//fetch database records
		ArrayList<DrillholeRecord> results = new ArrayList<DrillholeRecord>();
		
		try{
			results = DbHelper.SelectDrillholes(startDate, endDate);
		}
		catch (Exception e)
		{
			req.setAttribute("errormsg", e.getMessage());
			RequestDispatcher view = req.getRequestDispatcher("error.jsp");  
			view.forward(req, resp);
			return;
		}

		req.setAttribute("numRecords", results.size());
		req.setAttribute("results", results);
		RequestDispatcher view = req.getRequestDispatcher("results.jsp");  
        view.forward(req, resp);
    }
}