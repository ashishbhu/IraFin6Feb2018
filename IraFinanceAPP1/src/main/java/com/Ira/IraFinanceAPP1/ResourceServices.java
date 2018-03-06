package com.Ira.IraFinanceAPP1;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

@Path("register")
public class ResourceServices {
	
	

/*1------------OK--------------------- FOR REGISTER NEW USER---------------------------------------- */
	
	@POST
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createUser(String customerdetail) 
    {
		
    	
    	BusinessLogic bl=new BusinessLogic();   	
    	
    		return bl.create(customerdetail);
    
	}
	
	
/*2---------------ok---------------FOR LOGIN USER--------------------------------------------------------*/	
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	public String loginUser(String logindetail)
	{
		
		BusinessLogic bl=new BusinessLogic();  
		return bl.getLoginUser(logindetail);
		
		
	}
	
	
/*3.------------ok---------------------FORGET USER NAME-------------------------------------------------------*/
	
	 
	   @GET
	   @Path("forgetuser")
	   @Produces(MediaType.APPLICATION_JSON)
	   @Consumes(MediaType.APPLICATION_JSON)
	   public String forgetUser(@QueryParam("mobile") String mobile)
	   {
		   BusinessLogic bl=new BusinessLogic();  
		   return bl.getForgetUser(mobile);
	   }
	
/*4.-----------ok-----------------------FORGET PASSWORD--------------------------------------------------------*/	
		
	   @GET
	   @Path("forgetpassword")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
	   public String forgetPassword(@QueryParam("user") String username)
	   {
		   BusinessLogic bl=new BusinessLogic();
		   return bl.getForgetPassword(username);
	
	   }
	   
	   
	   
/*5.---------ok------------------------TEMP PASSWORD--------------------------------------------------------*/
	   
	   @POST
	   @Path("temppass")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public String tempPassword(String temppass)
	   {
		   BusinessLogic bl=new BusinessLogic();
		   return bl.getTempPassword(temppass);
	   }	   
	   
	
/*6.----------ok-----------------------RESET PASSWORD----------------------------------------------------*/
	   
	   @POST
	   @Path("resetpass")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public String resetPassword(String resetpass)
	   {
		   BusinessLogic bl=new BusinessLogic();
		   return bl.resetPassword(resetpass);
	   }
	   	   
	
	   
/*7.----------ok---------------------SUB USER REGISTRATION--------------------------------------------*/
	   
	   @POST
	   @Path("csuser")
	  
	   @Consumes(MediaType.APPLICATION_JSON)
	   public String createSubUser(String subuser)
	   {
		   BusinessLogic bl=new BusinessLogic();
		   return bl.createSubUser(subuser);
	   }	   
	   

	   
/*8.-------------------------OK----------GET ALL SUB USER NAME BY MAIN USER NAME-----------------------------*/
	  
	   @GET
	   @Path("allsubuser")
	   @Produces(MediaType.APPLICATION_JSON)
	   public String getAllSubUser(@QueryParam("user") String username)
	   {
		   BusinessLogic bl=new BusinessLogic();
		   return bl.getAllSubUser(username);
	   }
	  	   

/*9.-------ok----------------------------GET SUB USER ACCESS by SUB USER NAME--------------------------------------------*/	   
	   
		
	   @GET
	   @Path("getsubuseraccess")
	   //@Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
	   public String getSubUserAccess(@QueryParam("user") String username)
	   {
		   BusinessLogic bl=new BusinessLogic();
		   return bl.getSubUserAccess(username);
	   }

	   
/*10------------------OK-----------FOR EDIT SUB USER ACCESS----------------------------------------------------*/
	   
	   @POST
	   @Path("editsubuseraccess")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
	   public String editSubUserAccess(String editsubuser)
	   {
		   BusinessLogic bl=new BusinessLogic();
		   return bl.editSubUserAccess(editsubuser);
	   }	   
  
/*11.------------ok-------------------Synch Item----------------------------------------------------------------*/ 
	   
	   @POST
	   @Path("additem")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
	   public String  addItem(String item)
	   {
		  
		   BusinessLogic bl=new BusinessLogic();
		   return bl.addItem(item);
		   
	   }	   
	   
	   
/*12.----------ok----------------GET ITEM DETAIL BY SUB ID WHICH ITEM IS ACTIVE------------------------------------------*/
		   
		  @GET
		  @Path("getitem")
		  @Produces(MediaType.APPLICATION_JSON)
		  public String getAllItem(@QueryParam("subid") String id,@QueryParam("date") String date)
		  {
			  BusinessLogic bl=new BusinessLogic();
			  return bl.getAllItem(id,date);
		  }	
	
		   
/*13.----------ok--------------Login DETAIL BY USER NAME------------------------------------------------------------------*/
			  
			  @POST
			  @Path("logindetail")
			  //@Consumes(MediaType.APPLICATION_JSON)
			  @Produces(MediaType.APPLICATION_JSON)
			  public String loginDetails(String username)
			  {
				  BusinessLogic bl=new BusinessLogic();
				  return bl.getLoginDetail(username);
			  }		  
			 
			  
/*14.------ok------------------DETAILS OF REPORT by Date-------------------------------------------------------------------*/
			  
			  @GET
			  @Path("reportdetail")
			  @Consumes(MediaType.APPLICATION_JSON)
			  @Produces(MediaType.APPLICATION_JSON)
			  public String reportHDR(@QueryParam("parent") String parent,@QueryParam("date1") String date1,@QueryParam("date2") String date2)
			  {
				  BusinessLogic bl=new BusinessLogic();
				  return bl.getReportHDR(parent,date1,date2);
			  }

/*15.------ok--------------DETAILS OF REPORT By INVOICE_ID----------------------------------------------------------------*/
			 
			  @GET
			  @Path("reportinvoice")
			  @Consumes(MediaType.APPLICATION_JSON)
			  @Produces(MediaType.APPLICATION_JSON)
			  public String reportInvoice(@QueryParam("invoiceid") String invoiceid)
			  {
				  BusinessLogic bl=new BusinessLogic();
				  return bl.getInvoiceDetail(invoiceid);
			  }
			 	
 /*16.--------ok-----------------GETING CUSTOMER DETAIL from Invoice_hdr BY MOBILE NUMBER--------------------------------*/
			  
			  @GET
			  @Path("cusdetail")
			  @Consumes(MediaType.APPLICATION_JSON)
			  @Produces(MediaType.APPLICATION_JSON)
			  public String customerDetails(@QueryParam("mobile") String mobile)
			  {
				  BusinessLogic bl=new BusinessLogic();
				  return bl.getCustomerDetails(mobile);
			  }			  
			  

/*17.----------ok---------------SYNCH INVOICE----------------------------------------------------------------------------*/
			  
			  
			  
			  @POST
			  @Path("invoice")
			  @Consumes(MediaType.APPLICATION_JSON)
			  @Produces(MediaType.APPLICATION_JSON)
			  public String invoiceHDR_Line(String item)
			  {
				  BusinessLogic bl=new BusinessLogic();
				  return bl.setInvoice_hdr(item);
	 		  }	
			  
			  
			  
/*-----------------------------------GST SERVICES-----------------------------------------------------------------*/
			  
			  
	/*18.----------ok------------------------Set GST Details----------------------------------*/
			  
			   @GET
			   @Path("gstentry")
			   @Consumes(MediaType.APPLICATION_JSON)
			   public void  setGstDetails()
			   {
				   BusinessLogic bl=new BusinessLogic();
				      bl.setGstDetails();
				     
			   }
		  
			  
	/*19.-------------------------------Show GST-------------------------------------------*/
			   
			   
			   @GET
			   @Path("gstshow")
			  
			  @Produces(MediaType.APPLICATION_JSON)
			   
			   public String getGSTdetails()
			   {
				  
				   System.out.println("in gst service");
				   BusinessLogic bl=new BusinessLogic();
				  				  
				   return bl.getGstDetails();
				  
				   
			   }
			  
			  
/*20.------------------------Insert New Gst ------------------------------------------------------------*/
			   
			   @POST
			   @Path("insertgst")
			   @Consumes(MediaType.APPLICATION_JSON)
			   @Produces(MediaType.APPLICATION_JSON)
			   public String insertGST(String insert)
			   {
				   
				   BusinessLogic bl=new BusinessLogic();
				   return bl.insertGST(insert);
			   }
			  
			  
/*21.---------------------------Update Gst Table---------------------------------------------------------*/			  
			  
			   @PUT
			   @Path("gstupdate")
			   @Consumes(MediaType.APPLICATION_JSON)
			   @Produces(MediaType.APPLICATION_JSON)
			   public String updateGST(String gstupdate) 
			   {
				   BusinessLogic bl=new BusinessLogic();
				   return bl.updateGST(gstupdate);
			   }
		   		  
			  
/*22.============================================Max Invoice Id from invoice_hdr for a userid==========================*/
			   
			   
			   
			   @POST
			   @Path("maxinvoiceid")
			   @Consumes(MediaType.APPLICATION_JSON)
			   @Produces(MediaType.APPLICATION_JSON)
			   public String getInvoiceId(String user)
			   {
				   BusinessLogic bl=new BusinessLogic();
				   return bl.getInvoiceId(user);
				   
			   }

/*23.============================Daily Selling Report======================================================*/
			   @GET
			   @Path("dailysellingreport")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   public String getDailySellingReport(@QueryParam("date1") String date1,@QueryParam("date2") String date2)
			   {
				   System.out.println("in service 23");
				   BusinessLogic bl=new BusinessLogic();
				   return bl.getDaillySellReport(date1,date2);
				   
			   }
			  
			  
		 
}   
