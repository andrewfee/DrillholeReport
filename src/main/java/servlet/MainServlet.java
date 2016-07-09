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

//
//Summary: This servlet handles the POST request by querying the database
//and forwarding the retrieved data to results.jsp
//
@WebServlet("/servlet")
public class MainServlet extends HttpServlet {

	//
	//This method is called when user submits HTTP POST request from index.jsp
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		//get user inputs
		String startDateParam = req.getParameter("start");
		String endDateParam = req.getParameter("end");
			
		Date startDate;
		Date endDate;
			
		//convert to Date objects
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
			
		//list will store the retrieved DrillholeRecords
		ArrayList<DrillholeRecord> records = new ArrayList<DrillholeRecord>();
		
		//fetch database records
		try{
			records = DbHelper.SelectDrillholes(startDate, endDate);
		}
		catch (Exception e)
		{
			req.setAttribute("errormsg", e.getMessage());
			RequestDispatcher view = req.getRequestDispatcher("error.jsp");  
			view.forward(req, resp);
			return;
		}

		//forward retrieved records to results page
		req.setAttribute("numRecords", records.size());
		req.setAttribute("results", records);
		RequestDispatcher view = req.getRequestDispatcher("results.jsp");  
        view.forward(req, resp);
    }
}