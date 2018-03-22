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
			   public String getDailySellingReport(@QueryParam("userid") String userid, @QueryParam("date1") String date1,@QueryParam("date2") String date2)
			   {
				   System.out.println("in service 23");
				   BusinessLogic bl=new BusinessLogic();
				   return bl.getDaillySellReport(userid,date1,date2);
				   
			   }
			  

/*==================================inventory management=======================================================*/
			   
	/*24=========================insert in inventory main table======================================*/
			   @POST
			   @Path("inventorymaininsert")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   public String insertInventoryMain(String inventorydetail)
			   {
				   System.out.println("24");
				   BusinessLogic bl=new BusinessLogic();
				   return bl.insertInventoryMain(inventorydetail);
				   
			   }
			   
	/*25=========================update inventory main table======================================*/
			   
			   @POST
			   @Path("inventorymainupdate")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   public String updateInventoryMain(String inventoryupdate)
			   {
				   System.out.println("25");
				   BusinessLogic bl=new BusinessLogic();
				   return bl.updateInventoryMain(inventoryupdate);
				   
			   }
			   
			   
	/*26=========================get report from inventory main table by userid======================================*/
			   @GET
			   @Path("inventoryreportbyuserid")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   public String inventoryReportbyUserd(@QueryParam("userid") String userid)
			   {
				   BusinessLogic bl=new BusinessLogic();
				   return bl.inventoryReportbyUserid(userid);
				   
			   }
			   
	/*27=========================get report from inventory main table by userid and itemid======================================*/	
			   
			   @GET
			   @Path("inventoryreportbyitemiduserid")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   public String inventoryReportbyUserItem(@QueryParam("userid") String userid, @QueryParam("itemid") String itemid)
			   {
				   BusinessLogic bl=new BusinessLogic();
				   return bl.inventoryReportbyUserItem(userid, itemid);
			   }
			   
	/*28=========================Add action manual in inventory transaction table======================================*/	
			   
			   @POST
			   @Path("actionmanualadd")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   public String actionManualAdd(String transactiondetail)
			   {
				  
				   BusinessLogic bl=new BusinessLogic();
				   return bl.actionManualAdd(transactiondetail);
			   }
		
	
   /*29=========================reduce action manual in inventory transaction table======================================*/	
			   
			   
			   @POST
			   @Path("actionmanualreduce")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   public String actionManualReduce(String reducedetail)
			   {
				  
				   BusinessLogic bl=new BusinessLogic();
				   return bl.actionManualReduce(reducedetail);
			   }
			   
	/*30=========================inventory transaction report by userid ,itemid, startdate,enddate=========================*/
			   
			   @GET
			   @Path("transactionreportbyuseritemid")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   //@Produces(MediaType.APPLICATION_XML)
			   public String tranDetailbyUserItem(@QueryParam("userid") String userid,@QueryParam("itemid") String itemid,@QueryParam("startdate") String startdate,@QueryParam("enddate") String enddate)
			   {
				   BusinessLogic bl=new BusinessLogic();
				   return bl.tranDetailbyUserItem(userid,itemid,startdate,enddate);
				   
			   }
			   

   /*31=========================inventory transaction report by userid , startdate,enddate=========================*/
			   
			   
			   @GET
			   @Path("transactionreportbyuser")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   //@Produces(MediaType.APPLICATION_XML)
			   public String tranDetailbyUser(@QueryParam("userid") String userid,@QueryParam("startdate") String startdate,@QueryParam("enddate") String enddate)
			   {
				   BusinessLogic bl=new BusinessLogic();
				   return bl.tranDetailbyUser(userid,startdate,enddate);
				   
			   } 
			   
	/*32=========================Find Shopname by UserId=========================*/	
			   @GET
			   @Path("findshopname")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   public String findShopName(@QueryParam("userid") String userid)
			   {
				   BusinessLogic bl=new BusinessLogic();
				   return bl.findShopName(userid);
			   }
	
   /*33=========================Add action Automated In Inventory_main and Inventory_transaction================*/	
			   
			   @POST
			   @Path("addautomated")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   public String addAutomated(String adddetail)
			   {
				  
				   BusinessLogic bl=new BusinessLogic();
				   return bl.actionAddAutomated(adddetail);
			   }		
	
    /*34========================Reduce Action Automated In Inventory_main and Inventory_transaction============*/
		
			   @GET
			   @Path("reduceautomated")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   public String reduceAutomated(@QueryParam("userid") String userid, @QueryParam("itemid") String itemid, @QueryParam("qty") double qty)
			   {
				   BusinessLogic bl=new BusinessLogic();
				   return bl.reduceAutomated(userid, itemid, qty);
			   }
			   
	//============================Heirarchical user management===================================================
			   
	/*35.========================Create Tree with root user======================================================*/
			
			   @GET
			   @Path("createtree")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   public String createTree(@QueryParam("rootuser") String rootuser)
			   {
				   
				   BusinessLogic bl=new BusinessLogic();
				   return bl.createTree(rootuser);
			   }
			   
	/*36.========================create Child with root user ,parent and child==================================*/
	
			   @GET
			   @Path("createchild")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces(MediaType.APPLICATION_JSON)
			   public String createChild(@QueryParam("parent") String parent,@QueryParam("child") String child )
			   {
				   //System.out.println("36");
				   BusinessLogic bl=new BusinessLogic();
				   return bl.createChild(parent,child);
			   }
	
			   
   /*37.========================Delete Child with Parent and Child User========================================*/
			   
			   @GET
			   @Path("deletechild")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
			   public String deleteChild(@QueryParam("parent") String parent,@QueryParam("child") String child )
			   {
				   //System.out.println("37");
				   BusinessLogic bl=new BusinessLogic();
				   return bl.deleteChild(parent,child);
			   }
			   
	
   /*38.========================Move Child with With parent user ,child user and new parent======================*/	
			   
			   @GET
			   @Path("movechild")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
			   public String moveChild(@QueryParam("parent") String parent,@QueryParam("child") String child ,@QueryParam("newparent") String newparent )
			   {
				   //System.out.println("38");
				   BusinessLogic bl=new BusinessLogic();
				   return bl.moveChild(parent,child,newparent);
			   } 

			   
  /*39.========================Add Dealer Ship Code ============================================================*/				   
			
			   @GET
			   @Path("adddealershipcode")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
			   public String addDealerCode(@QueryParam("username") String user,@QueryParam("dealercode") String dealercode )
			   {
				   //System.out.println("39");
				   BusinessLogic bl=new BusinessLogic();
				   return bl.addDealerCode(user,dealercode);
			   } 
			   
 /*40.========================Delete Dealer Ship Code ============================================================*/
			   
			   @GET
			   @Path("deletedealershipcode")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
			   public String deleteDealerCode(@QueryParam("username") String user,@QueryParam("dealercode") String dealercode )
			   {
				   //System.out.println("40");
				   BusinessLogic bl=new BusinessLogic();
				   return bl.deleteDealerCode(user,dealercode);
			   } 
			   
			   
  /*41.========================Update Dealer Ship Code ============================================================*/
			   
			   @GET
			   @Path("updatedealershipcode")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
			   public String updateDealerCode(@QueryParam("username") String user,@QueryParam("olddealercode") String olddealercode, @QueryParam("newdealercode") String newdealercode )
			   {
				   //System.out.println("41");
				   BusinessLogic bl=new BusinessLogic();
				   return bl.updateDealerCode(user,olddealercode,newdealercode);
			   } 
			   
  /*42.========================Find Dealer Code by UserId ============================================================*/
			   
			   @GET
			   @Path("finddealercode")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
			   public String findDealerCode(@QueryParam("username") String user)
			   {
				   //System.out.println("42");
				   BusinessLogic bl=new BusinessLogic();
				   return bl.findDealerCode(user);
			   } 
			   
 /*43.========================Find All Child Data ============================================================*/
			   
			   @GET
			   @Path("findallchild")
			   @Consumes(MediaType.APPLICATION_JSON)
	           @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
			   public String findAllChild(@QueryParam("username") String user)
			   {
				   //System.out.println("43");
				   BusinessLogic bl=new BusinessLogic();
				   return bl.findAllChildCode(user);
			   } 
}   
