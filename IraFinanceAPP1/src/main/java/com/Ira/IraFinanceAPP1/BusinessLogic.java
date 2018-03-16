package com.Ira.IraFinanceAPP1;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
//import org.eclipse.persistence.queries.ReadQuery;
import org.json.JSONException;
import org.json.JSONObject;

public class BusinessLogic {
	
	
	 final static  Logger logger=Logger.getLogger(BusinessLogic.class);
/*1---------------------------OK----- FOR REGISTER NEW USER---------------------------------------------------------------- */
	
	public String create(String customerdetail)
	{
		
		RegisterUser userdetails=new RegisterUser();
		
		  try
		  {
			JSONObject obj=new JSONObject(customerdetail);
			
			userdetails.setPassword(obj.getString("pass"));
			userdetails.setShopname(obj.getString("shopname"));
			userdetails.setAddress(obj.getString("address"));
			userdetails.setMobilenumber(obj.getString("mobilenumber"));
			userdetails.setEmailid(obj.getString("emailid"));
			userdetails.setGstnumber(obj.getString("gstnumber"));
			userdetails.setAcctlocked(obj.getString("acctlocked"));
			userdetails.setSubstartdate(obj.getString("substartdate"));
			userdetails.setSubenddate(obj.getString("subenddate"));
			
			
			logger.info("User Details: Shopname: "+userdetails.getShopname()+", "+"Address: "+userdetails.getAddress()+ 
					 ", " + "MobileNo: "+userdetails.getMobilenumber()+ ", "+ "EmailId: "+userdetails.getEmailid()+
					 ", "+ "GstNo: "+userdetails.getGstnumber()+", "+  "AcctLocked: "+userdetails.getAcctlocked()+
					 ", "+ "StartDate: "+userdetails.getSubstartdate()+ ", "+ "EndDate: "+userdetails.getSubenddate());
			
			
		  }
		  catch(JSONException e)
		  {
			  logger.error("In registration service: error: "+e);
		  }
		
		
		
		if(userdetails.getPassword().isEmpty())
			return "You must enter password";
		if((userdetails.getPassword()).length()>40)
			return "password length can't be greater than 40 character";
		
		if(userdetails.getShopname().isEmpty())
			return "You must enter shopname";
		if(userdetails.getShopname().length()>100)
			return "Shopname length can't be greater than 100 character";
		
		if(userdetails.getAddress().isEmpty())
			return "You must enter address";
		if(userdetails.getAddress().length()>200)
			return "Address length can't be greater than 200 character";
		
		if(userdetails.getMobilenumber().isEmpty())
			return "You must Enter Mobile Number";
		if(userdetails.getMobilenumber().length()<10 || userdetails.getMobilenumber().length()>10)
			return "mobile number length must be 10 digits";
		
		if(userdetails.getEmailid().isEmpty())
			return "You must enter EmailId";
		if(userdetails.getEmailid().length()>40)
			return "EmailId length can't be greater than 40 character";
		
		if(userdetails.getGstnumber().isEmpty())
			return "You must enter GST Number";
		if(userdetails.getGstnumber().length()>15)
			return "GST Number can't be more than 15 character";
		
		if(userdetails.getAcctlocked().isEmpty())
			return "You must Enter AcctLocked";
		
		if(userdetails.getSubstartdate().isEmpty())
			return "You must Enter Subscription Start Date";
		
		if(userdetails.getSubenddate().isEmpty())
			return "You must Enter Subscription End Date";
		
		
		Implementation imp=new Implementation();
		
		return imp.create(userdetails);
		
	}
	
	
/*2-------------------------------------------FOR LOGIN USER----------------------------------------------------------------*/	

	
	public String getLoginUser(String logindetail)
	{
		String uname=null;
		String pass=null;
		
		try
		{
		 JSONObject obj=new JSONObject(logindetail);
		uname= obj.getString("uname");
		pass= obj.getString("pass");
		
		//logger.info("trying to login with user name: "+uname);
		if(uname.isEmpty())
			return "You must enter username";
		if(uname.length()>10)
			return "User name can't be greater than 10 character";
		
		 if(pass.isEmpty())
			 return "You must enter password";
		 if(pass.length()>40)
			return "Password can't be greater than 40 character"; 
		 
		 
		}
		catch(JSONException e)
		{
			logger.error("In login service: error: "+e);
		}
		catch(Exception e)
		{
			logger.error("In login service: error: "+e);
		}
		
		logger.info("In login service: trying to login with username is: "+" "+uname);
		
        Implementation imp=new Implementation();
		
		return imp.loginUser(uname,pass);
		
	}
	
/*3.------------ok---------------------FORGET USER NAME-------------------------------------------------------*/
	
	
	public String getForgetUser(String mobile)
	{
		if(mobile.isEmpty())
			return "You must enter mobile number";
		if(mobile.length()<10 || mobile.length()>10)
			return "Enter 10 digit mobile number";
		
		
		logger.info("In forget user service: Trying to access forget password using mobilenumber: "+" "+mobile);
		 
		Implementation imp=new Implementation();
		 
		 return imp.getForgetUser(mobile);
		
	}
	
/*4.-----------ok-----------------------FORGET PASSWORD--------------------------------------------------------*/	

	public String getForgetPassword(String username)
	{
		
		if(username.isEmpty())
		{
			return "You must enter username";
		}
		if(username.length()>10)
			return "user name length can't be greater than 10 character";
		
	
		logger.info("In forget password service: trying to access password using username is:"+" "+username);
		
		Implementation imp=new Implementation();
		 return imp.getForgetPassword(username);
	}
	
/*5.---------ok------------------------TEMP PASSWORD--------------------------------------------------------*/	
	
	
	public String getTempPassword(String temppass)
	{
		String user=null;
		String pass=null;
		try
		{
			JSONObject obj=new JSONObject(temppass);
			user=obj.getString("user");
			pass=obj.getString("pass");
			
			
		}
		catch(JSONException e)
		{
			logger.error("In temp password service: error :"+e);
		}
		
		if(user.isEmpty())
			return "You must enter username";
		if(user.length()>10)
			return "Username can't be greater than 10 character";
		
		if(pass.isEmpty())
			return "You must enter password";
		if(pass.length()>40)
			return "password can't be greater than 40 character";
		
		logger.info("In temp password service: you are trying to set temp password for user name: "+" "+user);
		
		Implementation imp=new Implementation();
		return imp.getTempPassword(user,pass);
		
	}
	
	
/*6.----------ok-----------------------RESET PASSWORD----------------------------------------------------*/	
	
	public String resetPassword(String resetpass)
	{
		
	    String user=null;
		String pass=null;
		
		try
		{
			JSONObject obj =new JSONObject(resetpass);
			user=obj.getString("user");
			pass=obj.getString("pass");
		}
		catch(JSONException e)
		{
			
			logger.error("In reset Password Service: error :"+e);
		}
		
		
		if(user.isEmpty())
			return "You must enter username";
		if(user.length()>10)
			return "Username can't be greater than 10 character";
		
		if(pass.isEmpty())
			return "You must enter password";
		if(pass.length()>40)
			return "password can't be greater than 40 character";
		
		logger.info("In reset password service: You are trying to reset password with username:"+" "+user);
		
		
		Implementation imp=new Implementation();
		return imp.getResetPassword(user,pass);
	}

	
/*7.----------ok---------------------SUB USER REGISTRATION--------------------------------------------*/	
	

	public String createSubUser(String subuser)
	{
		
		RegisterSubUser subuserdetail=new RegisterSubUser();
			
			try
			{
				JSONObject obj=new JSONObject(subuser);
				
				subuserdetail.setMainuser(obj.getString("user"));
				subuserdetail.setSubuser(obj.getString("cuname"));
				subuserdetail.setPass(obj.getString("cpass"));
				subuserdetail.setAccess(obj.getInt("access"));
				subuserdetail.setSubstsrtdate(obj.getString("sdate"));
				subuserdetail.setSubenddate(obj.getString("edate"));
			}
			catch(JSONException e)
			{
				logger.error("In sub user registration service: error :"+e);
			}
			catch(Exception e)
			{
				logger.error("In sub user registration service: error in JSON object at the time of receiving sub user details");
			}
		    
			if(subuserdetail.getMainuser().isEmpty())
				return "You must enter parent user name";
			if(subuserdetail.getMainuser().length()>10)
				return "Parent user name cant't be greater than 10 character";
			
			if(subuserdetail.getSubuser().isEmpty())
				return "You must enter sub user name";
			if(subuserdetail.getSubuser().length()>16)
				return "sub user name can't be greater than 16 character";
			
			if(subuserdetail.getPass().isEmpty())
				return "You must enter password";
			if(subuserdetail.getPass().length()>40)
				return "Password can't be greater than 40 character";
			
			if(Integer.toString(subuserdetail.getAccess()).isEmpty())
				return "You must enter access";
			if(Integer.toString(subuserdetail.getAccess()).length()>5)
				return "access length can't be greater than 5 digits";
			
			if(subuserdetail.getSubstsrtdate().isEmpty())
				return "You must enter start date";
			
			if(subuserdetail.getSubenddate().isEmpty())
				return "You must enter end date";
			
			
			
			logger.info("In sub user registration service:  You are trying to create sub user with these details: "+"main user: "+" "+
			subuserdetail.getMainuser()+" "+"sub user id: "+" "+subuserdetail.getSubuser()+" "+"access: "+
					subuserdetail.getAccess()+" "+"start date: "+subuserdetail.getSubstsrtdate()+" "+
			"end date: "+subuserdetail.getSubenddate());
		
		
			Implementation imp=new Implementation();
			return imp.createSubUser(subuserdetail);
	}
	
	
	
/*8.-------------------------OK----------GET ALL SUB USER NAME BY MAIN USER NAME------------------------------*/
	
	
	public String getAllSubUser(String username)
	{
		
		if(username.isEmpty())
			return "You must enter parent user name";
		if(username.length()>10)
			return "user name can't be greater than 10 character";
		
		
		
		logger.info("In all sub user name service: You are trying to access all sub user name using parent user name :"+username);
		
		
		Implementation imp=new Implementation();
		return imp.getAllSubUser(username);
		
	}

	
/*9.-------ok----------------------------GET SUB USER ACCESS by SUB USER NAME--------------------------------------------*/	
	
	public String getSubUserAccess(String username)
	{
		
		if(username.isEmpty())
			return "You must enter sub user name";
		if(username.length()>16)
			return "sub user name can't be greater than 16 character";
		
		logger.info("In get sub user access service: you are trying to see sub user access by sub user name "+username);
		
		
		Implementation imp=new Implementation();
		return imp.getSubUserAccess(username);
		
	}

	
/*10------------------OK-----------FOR EDIT SUB USER ACCESS----------------------------------------------------*/	
	
	public String editSubUserAccess(String editsubuser)
	{
		
		String subuser=null;
		String pass=null;
		int access=0;
			
		    try
		    {
			JSONObject obj= new JSONObject(editsubuser);/*---parsing json object--*/
			
			subuser=obj.getString("user");
			pass=obj.getString("pass");
			access=obj.getInt("access");
		    }
		    catch(JSONException e)
		    {
		    	logger.error("In edit sub user access service: error :"+e);
		    }
			catch(Exception e)
		    {
				logger.error("In edit sub user access service: error :"+e);
		    }
		
		
		   if(subuser.isEmpty())
			   return "You must enter sub user name";
		   if(subuser.length()>16)
			   return "sub user name can't be greater than 16 character";
		   
		   if(pass.isEmpty())
			   return "You must enter password";
		   if(pass.length()>40)
			   return "sub user password can't be greater than 40 character";
		   
		   if(Integer.toString(access).isEmpty())
			   return "You must enter access";
		   if(Integer.toString(access).length()>5)
			   return "access length can't be greater than 5 digit";
		   
		   logger.info("In edit sub user access service :You are trying to edit sub user access with details: "+subuser+", "
				   +"access "+access);
		    
		
		   Implementation imp=new Implementation();
			return imp.editSubUserAccess(subuser,pass,access);
	}
	
	
	
	
/*11.------------ok-------------------Synch Item----------------------------------------------------------------*/	

	public String addItem(String item)
	{
		String id=null;
		
		try
		{
		JSONObject obj=new JSONObject(item);
		
		 id=obj.getString("subid");
		}
		catch(Exception e)
		{
			logger.error("In shrink item service: error :"+e);
			
		}
		
		logger.info("In shrink item service: you are trying to synck item in main item table with subid: "+id);
		
		
		Implementation imp=new Implementation();
		return imp.addItem(item);
	}

	
/*12.----------ok----------------GET ITEM DETAIL BY SUB ID WHICH ITEM IS ACTIVE------------------------------------------*/	

	public String getAllItem(String id,String date)
	{
		
		if(id.isEmpty())
			return "You must enter sub id";
		if(id.length()>10)
			return "Subid can't be graeter than 10 digits";
		if(date.isEmpty())
			return "date can't be empty";
		if(date.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})"))
		{
			
		}
		else
			return "date format not correct";
		
		
		logger.info("In Item Detail Service: you are trying to see all item detail by subid: "+id);
		
		Implementation imp=new Implementation();
		return imp.getAllItem(id,date);
		
	}
	
/*13.----------ok--------------LOGin DETAIL BY USER NAME------------------------------------------------------------------*/	

	public String getLoginDetail(String username)
	{
		
		
		if(username.isEmpty())
			return "You must enter username";
		//if(username.length()>10)
			//return "username can't be greater than 10 character";
		
		logger.info("In Login Detail Service: you are trying to see user detail of :"+username);
		
		Implementation imp=new Implementation();
		return imp.getLoginDetail(username);
	}


	
/*14.------ok------------------DETAILS OF REPORT by Date-------------------------------------------------------------------*/	
	
	public String getReportHDR(String parent,String date1,String date2)
	{
		
		if(date1.isEmpty() && date2.isEmpty())
			return "You must enter dates";
		
		logger.info("In Details of Report Service by Date: You are trying to see invoice_hdr detail within :user: "+parent+" and "+date1+" and " + date2);
		
		Implementation imp=new Implementation();
		
		return imp.getReportHDR(parent,date1,date2);
		
	}

/*15.------ok--------------DETAILS OF REPORT By INVOICE_ID----------------------------------------------------------------*/

	public String getInvoiceDetail(String invoiceid)
	{
		
		
		if(invoiceid.isEmpty())
			return "You must enter invoice id";
		if(invoiceid.length()>12)
			return "Invoice id can't be greater than 12 character";
		
		logger.info("In Detail of Invoice id Service by Invoice id: you are trying to see invoice_hdr detail by invoice id");
		
		Implementation imp=new Implementation();
		return imp.getInvoiceDetail(invoiceid);
	}
	

/*16.--------ok-----------------GETING CUSTOMER DETAIL from Invoice_hdr BY MOBILE NUMBER--------------------------------*/	
	
	
	public String getCustomerDetails(String mobile)
	{
		if(mobile.isEmpty())
			return "You must enter mobile number";
		if(mobile.length()>10)
			return "mobile number can't be greater than 10 digit";
		
		
		logger.info("In Geting customer invoice_hdr service by mobile: you are trying to see customer invoice_hdr detail by mobile number");
		Implementation imp=new Implementation();
		return imp.getCustomerDetails(mobile);
	}
	

	
/*17.----------ok---------------SYNCH INVOICE----------------------------------------------------------------------------*/	
	
	public String setInvoice_hdr(String item)
	{
		
		
		logger.info("In Synch Invoice Service: you are trying to synch invoice detail in invoice_hdr");
		
		Implementation imp=new Implementation();
		
		System.out.println(item);
		return imp.setInvoice_hdr(item);
		
		
	}
	
/*----------------------------------------GST DETAILS--------------------------------------------------------*/
	
	/*18.-------------------------Set GST DEtails------------------------------------------------------------*/
	
	public void setGstDetails()
	{
		
		Implementation imp=new Implementation();
		imp.setGstDetails();
		
	}
	

	
/*19.-------------------------------Show GST-------------------------------------------*/
	
	
	public String getGstDetails()
	{
		
		Implementation imp=new Implementation();
		logger.info("In Show Gst Service: You are trying to see Gst Detail");
		return imp.getGstDetails();
		
	}
	
	
	
/*20.-----------------------Insert new Gst-------------------------------------------------------------*/
	
	public String insertGST(String gst)
	{
		
		
		

		   Gst gi=new Gst();
		   
		 
		   
		   try
		   {
			   
			   JSONObject obj=new JSONObject(gst);
		   
		   gi.setGstid(obj.getString("gstid"));
		   gi.setGstdesc(obj.getString("gstdesc"));
		   gi.setGstper(obj.getDouble("getper"));
		  
		   gi.setGststartdate(obj.getString("sdate"));
		   gi.setGstenddate(obj.getString("edate"));
		   gi.setIgst(obj.getDouble("igst"));
		   gi.setSgst(obj.getDouble("sgst"));
		   gi.setCgst(obj.getDouble("cgst"));
		   
		   }
		   catch(JSONException e)
		   {
			   logger.error("In GST Insert service: error :"+e);
		   }
		   
		   
		   logger.info("In GST Insert service: You are trying to insert with vauues: Gst_id:"+gi.getGstid()+", Gst_desc:"+gi.getGstdesc()+", Gst_persent:"+
				   gi.getGstper()+", start_date:"+gi.getGststartdate()+", end_date:"+gi.getGstenddate()+", igst:"+gi.getIgst()+
				   ", sgst:"+gi.getSgst()+", cgst:"+gi.getCgst());
		   Implementation imp=new Implementation();
		
		   return imp.insertGST(gi);
		
	}

	
/*21.---------------------------Update Gst Table---------------------------------------------------------*/		
	
	public String updateGST(String gst)
	{
		
		

		   Gst gi=new Gst();
		   
		 
		   
		   try
		   {
			   
			   JSONObject obj=new JSONObject(gst);
		   
		   gi.setGstid(obj.getString("gstid"));
		   gi.setGstdesc(obj.getString("gstdesc"));
		   gi.setGstper(obj.getDouble("getper"));
		  
		   gi.setGststartdate(obj.getString("sdate"));
		   gi.setGstenddate(obj.getString("edate"));
		   gi.setIgst(obj.getDouble("igst"));
		   gi.setSgst(obj.getDouble("sgst"));
		   gi.setCgst(obj.getDouble("cgst"));
		   
		   }
		   catch(JSONException e)
		   {
			   logger.error("In GST UPDATE service: error :"+e);
		   }
		   
		   
		   logger.info("In GST update service: You are trying to update with vauues: Gst_id:"+gi.getGstid()+", Gst_desc:"+gi.getGstdesc()+", Gst_persent:"+
				   gi.getGstper()+", start_date:"+gi.getGststartdate()+", end_date:"+gi.getGstenddate()+", igst:"+gi.getIgst()+
				   ", sgst:"+gi.getSgst()+", cgst:"+gi.getCgst());
		   Implementation imp=new Implementation();
		
		   return imp.updateGST(gi);
		
		
		
		
	}

/*22.============================================Max Invoice Id from invoice_hdr for a userid==========================*/

	public String getInvoiceId(String user)
	{
		logger.info("In Max InvoiceId Service: You are trying to find max invoice for a user");
		
		
		   Implementation imp=new Implementation();
			
		   return imp.getMaxInvoiceId(user);
		
		
	}
	
/*23.==================================Daily Selling Report======================================================*/	
	
	public String getDaillySellReport(String userid, String date1, String date2)
	{
		logger.info("In Dailly Selling Report Service: You are trying to find dailly Selling");
		Implementation imp=new Implementation();
		
		   return imp.getDaillySellReport(userid,date1,date2);
	}


	
	
	
/*==================================inventory management=======================================================*/
	   
	/*24=========================insert  in inventory main table======================================*/
	
	
	public String insertInventoryMain(String inventorydetail)
	{
		logger.info("In inventroy service 24 you are trying to insert in inventory main table");
		
		Implementation imp=new Implementation();
		
		return imp.insertInventoryMain(inventorydetail);
		
	}
	
	/*25=========================update  in inventory main table======================================*/
	public String updateInventoryMain(String inventoryupdate)
	{
		logger.info("In inventroy service 25 you are trying to update inventory main table");
		
		Implementation imp=new Implementation();
		
		return imp.insertInventoryMain(inventoryupdate);    // its calling same service 25 which is doing both insert and update
		
	}


	
	/*26=========================get report from inventory main table by userid======================================*/
	
	public String inventoryReportbyUserid(String userid)
	{
		logger.info("In inventroy service 26 you are trying to get report by user id from inventory main table");
		
		Implementation imp=new Implementation();
		
		return imp.inventoryReportbyUserid(userid);
	
	}


	
/*27=========================get report from inventory main table by userid======================================*/	
	
	
	public String inventoryReportbyUserItem(String userid, String itemid)
	{
		
		logger.info("In inventroy service 27 you are trying to get report by user id and itemid from inventory main table");
		
		Implementation imp=new Implementation();
		
		return imp.inventoryReportbyUserItem(userid, itemid);
	}


	
/*28=========================Add action manual in inventory transaction table======================================*/	
	
	
	public String actionManualAdd(String transactiondetail)
	{
		
		logger.info("In inventroy transaction service 28 you are trying perform manual add action");
		
		Implementation imp=new Implementation();
	  	
		return imp.actionManualAdd(transactiondetail);
		
	}


	
	
/*29=========================reduce action manual in inventory transaction table======================================*/
	
	public String actionManualReduce(String reducedetail)
	{
		logger.info("In inventroy transaction service 29 you are trying to perform manual reduce action");
		
		Implementation imp=new Implementation();
	  	
		return imp.actionManualReduce(reducedetail);
	}



/*30=========================inventory transaction report by userid ,itemid, startdate,enddate=========================*/
	
	public String tranDetailbyUserItem(String userid, String itemid, String startdate, String enddate)
	{
		
		logger.info("In inventroy transaction service 30 you are trying to fetch transaction report by userid,itemid,startdate,enddate");
		
		Implementation imp=new Implementation();
	  	
		return imp.tranDetailbyUserItem(userid, itemid, startdate, enddate);
	}


	
	
	
 /*31=========================inventory transaction report by userid , startdate,enddate=========================*/
	
	public String tranDetailbyUser(String userid, String startdate, String enddate)
	{
		
		logger.info("In inventroy transaction service 31 you are trying to fetch transaction report by userid,startdate,enddate");
		
		Implementation imp=new Implementation();
	  	
		return imp.tranDetailbyUser(userid, startdate, enddate);
		
	}


	
	
 /*32=========================Find Shopname by UserId=========================*/
	
	public String findShopName(String userid)
	{
		logger.info("In Find Shopname Service 32 you are Trying to See shop name of user: "+userid);
		
		Implementation imp=new Implementation();
	  	
		return imp.findShopName(userid);
	}


 /*33=========================Add action Automated In Inventory_main and Inventory_transaction================*/	
	   
	   public String actionAddAutomated(String adddetail)
	   {
		  
		   Implementation imp=new Implementation();
		   return imp.actionManualAdd(adddetail);      // this is calling to service no 28
	   }		
	
	
 /*34========================Reduce Action Automated In Inventory_main and Inventory_transaction============*/	
	
	
	public String reduceAutomated(String userid, String itemid, double qty)
	{
		logger.info("In Reduce Action Automated Service 33 you are Trying to Reduce of Itemid from user: "+userid+" and itemid:"+itemid);
		
		Implementation imp=new Implementation();
	  	
		return imp.reduceAutomated(userid, itemid, qty);
	}



//============================Heirarchical user management===================================================	
	
/*35.========================Create Tree with root user======================================================*/
	

	public String createTree(String rootuser)
	{
		logger.info("In Create tree with rootuser service 34 you are trying to create root user name: "+rootuser );
		
		Implementation imp=new Implementation();
	  	
		return imp.createTree(rootuser);
	}


	
	
/*36.========================create Child with parent and child==================================*/	
	
	
	public String createChild(String parent, String child)
	{
		logger.info("In Create Child User service 36 you are trying to create child user with name : "+child );
	
		Implementation imp=new Implementation();
  	
		return imp.createChild(parent,child);
	}


		
/*37.========================Delete Child with Parent and Child User========================================*/	
	
	public String deleteChild(String parent, String child)
	{
		logger.info("In Delete Child Service 37 You are Trying to Delete Child User :" +child+" for Parent User : "+parent );
		
		Implementation imp=new Implementation();
  	
		return imp.deleteChild(parent,child);
	}


	
	
 /*38.========================Move Child with With parent user ,child user and new parent======================*/		

	public String moveChild(String parent, String child, String newparent)
	{
		logger.info("In Move Child Service 38 You are trying to move Child user: "+child+" to parent user: "+newparent+" from parent user: "+parent );
		
		Implementation imp=new Implementation();
  	
		return imp.moveChild(parent,child,newparent);
	}
}















