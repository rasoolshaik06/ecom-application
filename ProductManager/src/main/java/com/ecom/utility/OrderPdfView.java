package com.ecom.utility;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.ecom.jpa.OrderListJpa;
import com.ecom.jpa.UsersRepository;
import com.ecom.model.Order;
import com.ecom.model.Users;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderPdfView extends AbstractPdfView {

	@Autowired
	UsersRepository userJpa;
	
	@Autowired
	private OrderListJpa orderListJpa;
	
	
	@Override
	protected void buildPdfDocument(Map model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		/*System.out.println(request.getUserPrincipal().getName());
		String user_id = request.getUserPrincipal().getName();
		Optional<Users> user=userJpa.findByUserName(user_id);
		int userId=user.get().getUserId();*/
		List<Order> orderList=orderListJpa.findAll();
	
	response.addHeader("Content-Disposition", "attachment;filename=order.pdf");
	Paragraph p=new Paragraph("welcome to Order List");
	document.add(p);


	//creating pdf table
	
	PdfPTable t=new PdfPTable(5);
	t.addCell("Order Id");
	t.addCell("product each price");
	t.addCell("product quantity");
	t.addCell("product total price");
	t.addCell("orderd date");
	
	for(Order order:orderList) {
		int id=order.getOrderItemId();
		String orderId=Integer.toString(id);
		double eachPrice=order.getPriceEach();
		String eprice=Double.toString(eachPrice);
		int qunat=order.getQuantity();
		String quantity=Integer.toString(qunat);
		double total=order.getPriceTotal();
		String totalPrice=Double.toString(total);
		LocalDate date=order.getApproveDate();
		
		
		t.addCell(orderId);
		t.addCell(eprice);
		t.addCell(quantity);
		t.addCell(totalPrice);
		t.addCell(date.toString());
	}
	//adding table data to document
	document.add(t);
	
	//adding time and data
	document.add(new Paragraph(new Date().toString()));
	System.out.println("docutment"+document);

	}

	
}
