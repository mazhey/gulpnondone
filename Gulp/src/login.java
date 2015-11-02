

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.DDIV;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private PreparedStatement preStatement;
	 HttpSession globalsession;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("login")){
		processRequest(request,response);}
		else if (action.equals("register")){
			processNewcustomer(request,response);
		}else if(action.equals("gulpUser")){
			processRegister(request,response);
		}else if (action.equals("search")){
			processSearch(request,response);
		}else if (action.equals("view")){
			processSearchView(request, response);
		}else if (action.equals("rate")){
			processRate(request,response);
		}else if (action.equals("review")){
			processReview(request,response);
		}else if (action.equals("list")){
			processList(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	gulpUser temp = new gulpUser();
	String message="starting message";
	String username = request.getParameter("username");
	String password = request.getParameter("password");	
		try
		{
			Connection conn = UtilitiesDB.getConnection();
			String sql = "select * from GULPUSER where GULPUSER_USERNAME=? and GULPUSER_PASSWORD=?";
			 PreparedStatement preStatement=conn.prepareStatement(sql);
			 preStatement.setString(1,username);
		       preStatement.setString(2,password);
	
			ResultSet rs = preStatement.executeQuery();
	      
	      if (rs.next())
	      {
	    	  temp.setgulpUserName(rs.getString("GULPUSER_NAME"));
	    	  temp.setgulpUserId(rs.getInt("GULPUSER_ID"));
	    	  temp.setgulpUserZipcode(rs.getString("GULPUSER_ZIPCODE"));
	    	  temp.setgulpUserUsername(rs.getString("GULPUSER_USERNAME"));
	    	  temp.setgulpUserPassword((rs.getString("GULPUSER_PASSWORD")));
	    	  temp.setgulpUserEmail(rs.getString("GULPUSER_EMAIL"));
	    	  
	    	  
	      }else{
	    	  message = "Err"
	    	  		+ "or in Finding User.";
	      }
	    	  
		} catch (Exception e){
			message = e.toString();
		} 
		
		
		//add the record count to a session
		HttpSession session = request.getSession();
		session.setAttribute("gulpuser", temp);
		globalsession = session;
		
		 request.setAttribute("message",message);
	     getServletContext()
	     	.getRequestDispatcher("/Homepage.jsp")
	     		.forward(request, response);
	}
	
	protected void processNewcustomer(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	     getServletContext()
	     	.getRequestDispatcher("/NewUser.jsp")
	     		.forward(request, response);
	     
	}
	
	protected void processRegister(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	gulpUser temp = new gulpUser();

	String username = request.getParameter("username");
	String password = request.getParameter("password");	
	String name = request.getParameter("name");	
	String zipcode = request.getParameter("zipcode");	
	String email = request.getParameter("email");	
		try
		{
			Connection conn = UtilitiesDB.getConnection();
			String sql ="insert into GULPUSER (GULPUSER_ID,GULPUSER_NAME,GULPUSER_EMAIL,GULPUSER_USERNAME, GULPUSER_PASSWORD, GULPUSER_ZIPCODE) VALUES (SEQ_GULPUSER.NEXTVAL, ?, ?, ?,?,?)";
			 PreparedStatement preStatement=conn.prepareStatement(sql);
			 preStatement.setString(1,name);
			 preStatement.setString(2,email);
			 preStatement.setString(3,username);
			 preStatement.setString(4,password);
             preStatement.setString(5,zipcode);
		      
	
			ResultSet rs = preStatement.executeQuery();
	      
	  
	    	  temp.setgulpUserName(name);
	    	 
	    	  temp.setgulpUserZipcode(zipcode);
	    	  temp.setgulpUserUsername(username);
	    	  
	    	  temp.setgulpUserEmail(email);
	    	  
	    	  System.err.println(temp.getGulpUserEmail());
	     
	    	  
		} catch (Exception e){
			
		} 
		
		
		//add the record count to a session
		HttpSession session = request.getSession();
		session.setAttribute("gulpuser", temp);
		
		
	     getServletContext()
	     	.getRequestDispatcher("/Homepage.jsp")
	     		.forward(request, response);
	}
	
	protected void processSearch(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		gulpRestaurants temp = new gulpRestaurants();
	
		
	String restname = request.getParameter("restname").toLowerCase();
	
		try
		{
			Connection conn = UtilitiesDB.getConnection();
			String sql ="select * from GULPRESTAURANTS where GULPRESTAURANTS_NAME=?";
			 PreparedStatement preStatement=conn.prepareStatement(sql);
			 preStatement.setString(1,restname);
			 
		      
	
			ResultSet rs = preStatement.executeQuery();
	      if(rs.next()){
	  
	    	  temp.setGulpRestaurantsid(rs.getInt("GULPRESTAURANTS_ID"));
	    	  temp.setGulpRestaurantsName(rs.getString("GULPRESTAURANTS_NAME"));
	    	  temp.setGulpRestaurantsDescription(rs.getString("GULPRESTAURANTS_DESCRIPTION"));
	    	
	      }
	  
	    	  
		} catch (Exception e){
			
		} 
		
		
		//add the record count to a session
		HttpSession session = request.getSession();
	
	
		
		
	     getServletContext()
	     	.getRequestDispatcher("/RateAndReview.jsp")
	     		.forward(request, response);
	}
	
	protected void processSearchView(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		gulpRestaurants temp = new gulpRestaurants();
		ArrayList<Review> tempReview = new ArrayList<Review>();
		RateReview tempRate = new RateReview();
		
	String restname = request.getParameter("restname").toLowerCase();
	
		try
		{
			Connection conn = UtilitiesDB.getConnection();
			String sql ="select * from GULPRESTAURANTS where GULPRESTAURANTS_NAME=?";
			 PreparedStatement preStatement=conn.prepareStatement(sql);
			 preStatement.setString(1,restname);
			 
		      
	
			ResultSet rs = preStatement.executeQuery();
	      if(rs.next()){
	  
	    	  temp.setGulpRestaurantsid(rs.getInt("GULPRESTAURANTS_ID"));
	    	  temp.setGulpRestaurantsName(rs.getString("GULPRESTAURANTS_NAME"));
	    	  temp.setGulpRestaurantsDescription(rs.getString("GULPRESTAURANTS_DESCRIPTION"));
	    	
	      }
	     sql="select * from gulpreviews where gulprestaurants_id = ?";
	   preStatement=conn.prepareStatement(sql);
		 preStatement.setInt(1,temp.getGulpRestaurantsid());
		 rs = preStatement.executeQuery();
		 while (rs.next()){

			 Review r = new Review();
			 r.setReview(rs.getString("GULPREVIEWS_REVIEW"));
			 r.setReviewDate(rs.getString("GULPREVIEWS_DATE"));
			 tempReview.add(r);
			 
		 }
		 tempRate.setReviews(tempReview);

		 sql="select avg(gulprates_rate) from gulprates where gulprestaurants_id = ?";
		   preStatement=conn.prepareStatement(sql);
			 preStatement.setInt(1,temp.getGulpRestaurantsid());
			 rs = preStatement.executeQuery();
		if (rs.next()){
			tempRate.setAvgRate(rs.getString(1));
		}
	    	  
		} catch (Exception e){
			
		} 
		
		
		//add the record count to a session
		HttpSession session = request.getSession();
		session.setAttribute("gulprestaurants", temp);
		session.setAttribute("restaurantReview", tempRate);
		
		
	     getServletContext()
	     	.getRequestDispatcher("/ReviewRateOutcome.jsp")
	     		.forward(request, response);
	}
	
	protected void processList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ListRestaurants temp = new ListRestaurants();

		
	
	
		try
		{
			Connection conn = UtilitiesDB.getConnection();
			String sql ="select gulrprestaurants_id,gulrestaurants_name, avg(gulprates_rate) as avgRate from GULPRESTAURANTS inner join gulprates on GULPRESTAURANTS.gulrestaurants_id = gulprates.gulrestaurants_id group by gulrestaurants_id, gulrestaurants_name";
			 PreparedStatement preStatement=conn.prepareStatement(sql);
			
			 
		      
	
			ResultSet rs = preStatement.executeQuery();
	      if(rs.next()){
	  
	    	
	    	  temp.setName(rs.getString("GULPRESTAURANTS_NAME"));
	    	  temp.setDescription(rs.getString("GULPRESTAURANTS_DESCRIPTION"));
	    	  temp.setAvgRate(rs.getString("avgRate"));
	    	
	      }
	   
	    	  
		} catch (Exception e){
			
		} 
		
		
		//add the record count to a session
		HttpSession session = request.getSession();
		session.setAttribute("gulprestaurants", temp);
		
		
		
	     getServletContext()
	     	.getRequestDispatcher("/list.jsp")
	     		.forward(request, response);
	}
	
	protected void processRate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	String rate = request.getParameter("rate");
	String restaurantID = request.getParameter("restID");
	gulpUser temp = (gulpUser) globalsession.getAttribute("gulpuser");
	
		try
		{
			Connection conn = UtilitiesDB.getConnection();
			String sql ="insert into GULPRATES(GULPRATES_ID,GULPRATES_RATE,GULPUSER_ID,GULPRESTAURANTS_ID) VALUES (SEQ_GULPRATE.NEXTVAL, ?, ?, ?)";
			 PreparedStatement preStatement=conn.prepareStatement(sql);
			 preStatement.setString(1,rate);
			 preStatement.setInt(2,temp.getGulpUserId());
			 System.err.println(temp.getGulpUserId());
			 preStatement.setString(3,restaurantID);
		      
	
			ResultSet rs = preStatement.executeQuery();
	
	     
	    	  
		} catch (Exception e){
			
		} 
		
		
		//add the record count to a session
		HttpSession session = request.getSession();
	
		session.setAttribute("gulpuser", temp);
		
		
	     getServletContext()
	     	.getRequestDispatcher("/Homepage.jsp")
	     		.forward(request, response);
	}
	
	protected void processReview(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	String review = request.getParameter("review");
	String restaurantID = request.getParameter("restID");
	gulpUser temp = (gulpUser) globalsession.getAttribute("gulpuser");
	Date d= new Date();
	 
	
		try
		{
			Connection conn = UtilitiesDB.getConnection();
			String sql ="insert into GULPREVIEWS(GULPREVIEWS_ID,GULPREVIEWS_REVIEW,GULPUSER_ID,GULPRESTAURANTS_ID, GULPREVIEWS_DATE) VALUES (SEQ_GULPREVIEWS.NEXTVAL, ?, ?, ?,?)";
			 PreparedStatement preStatement=conn.prepareStatement(sql);
			 preStatement.setString(1,review);
			 preStatement.setInt(2,temp.getGulpUserId());
			 preStatement.setString(3,restaurantID);
			 preStatement.setString(4, d.toString());
	
			ResultSet rs = preStatement.executeQuery();
	
	     
	    	  
		} catch (Exception e){
			
		} 
		
		
		//add the record count to a session
		HttpSession session = request.getSession();
		session.setAttribute("gulpuser", temp);
		
		
	     getServletContext()
	     	.getRequestDispatcher("/Homepage.jsp")
	     		.forward(request, response);
	}
	
	}

