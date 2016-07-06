package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/servlet")
public class MyServlet extends HttpServlet {

	//private DbHelper db;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		String startDate = req.getParameter("start");
		String endDate = req.getParameter("end");
			
		//DO SOMETHING WITH startDate and endDate
		//ArrayList<DataRow> results = db.fetchRecords(startDate, endDate);
		
		
		ArrayList<DrillholeRecord> results = new ArrayList<DrillholeRecord>();
		results.add(new DrillholeRecord("51-57", 49.90, 2972.40, 5404.30, 2661.70, "South East", "AF", 15.0, "1/1/1951"));
		results.add(new DrillholeRecord("81-02", 213.00, 2625.20, 4793.50, 2668.50, "South East", "Beaver", 15.0, "1/1/1981"));
		

		req.setAttribute("results", results);  //Will be available as ${results} in JSP
		
		RequestDispatcher view = req.getRequestDispatcher("results.jsp");  
        view.forward(req, resp);
    }
}