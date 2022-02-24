package com.integra.employeeManagementSystem.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.integra.employeeManagementSystem.model.Address;
import com.integra.employeeManagementSystem.model.Employee;
import com.integra.employeeManagementSystem.util.HibernateUtil;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;

public class EmployeeDao {
	
	public static TreeMap<String, String> fetchDepartment(){  
		 Session session = HibernateUtil.getSessionFactory().openSession(); 
		 List<Object[]>departmentcodes = (List<Object[]>)session.createQuery("select d.departmentCode,d.departmentName from Department d").list();
	     Iterator<Object[]> it = departmentcodes.iterator();
	     TreeMap<String,String> map=new TreeMap<String,String>();
	   while(it.hasNext())
	     {
		   Object[] o=(Object[])it.next();
		   map.put(o[0].toString(),o[1].toString());
	     }
	     session.close();       
	     return map;  
			}  
	public static TreeMap<String, String> fetchCountry(){  
        
		Session session = HibernateUtil.getSessionFactory().openSession();  
	    List <Object[]>countrycodes = (List<Object[]>)session.createQuery("select c.countryCode,c.countryName from Country c").list();
	    Iterator<Object[]>it = countrycodes.iterator();
	    TreeMap<String,String> map=new TreeMap<String,String>();
	    
	   while(it.hasNext())
	     {
		   Object[] o=(Object[])it.next();
		   map.put(o[0].toString(),o[1].toString());
	     }
	     session.close();       
	     return map;  
			}  

	public static void saveUser(Employee employee,Address address){  
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		session.beginTransaction();    
	    session.saveOrUpdate(address);
	    employee.setAddress(address);
	    session.saveOrUpdate(employee);
	    session.getTransaction().commit();
		session.close();
		}
	
	public static void updateUser(Employee employee,Address address){  
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
		session.beginTransaction();    
		Employee updatedemployee = (Employee) session.get(Employee.class, employee.getEmployeeId());
		updatedemployee.setName(employee.getName());
		updatedemployee.setAge(employee.getAge());
		updatedemployee.setGender(employee.getGender());
		updatedemployee.setDepartment(employee.getDepartment());
		updatedemployee.setSkills(employee.getSkills());
		Address updatedaddress = (Address) session.get(Address.class, updatedemployee.getAddress().getAddressId());
		updatedaddress.setPermanentaddress1(address.getPermanentaddress1());
		updatedaddress.setPermanentaddress2(address.getPermanentaddress2());
		updatedaddress.setPermanentCountry(address.getPermanentCountry());
		updatedaddress.setTemporaryaddress1(address.getTemporaryaddress1());
		updatedaddress.setTemporaryaddress2(address.getTemporaryaddress2());
		updatedaddress.setTemporaryCountry(address.getTemporaryCountry());
		session.update(updatedaddress);
		session.update(updatedemployee);
        session.getTransaction().commit();
		session.close();
		}
		catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
		}
	
	public static void deleteUser(int id){  
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		try
		{
		session.beginTransaction();    
		Employee employee = (Employee) session.get(Employee.class, id);
		session.delete(employee);
        session.getTransaction().commit();
		session.close();
		}
		catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
		} 

	public static ArrayList<Employee> fetchAllUsers(){  
	    
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory = cfg.buildSessionFactory();
	    Session session = factory.openSession();
	    Query query = session.createQuery("FROM Employee e inner join e.address ");
	    List employeedetails = query.list();
	    Iterator it = employeedetails.iterator();
	    ArrayList<Employee> employees = new ArrayList<Employee>(); 
	    while(it.hasNext())
	    {
	    	Object[] o=(Object[])it.next();
	 	    Employee employee = (Employee)o[0];
	 	    employees.add(employee);
	 	    
	    }
	    session.close();       
	    return employees;
		  
		}
	
	public static void writeData(WritableSheet sheet,int row, int column,ArrayList<Employee> employees)
	{
		try
		{
		WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
        cellFont.setBoldStyle(WritableFont.BOLD);
        WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
        WritableCellFormat newFormat = new WritableCellFormat(cellFont);
        newFormat.setAlignment(Alignment.CENTRE);
        sheet.mergeCells(column, row, column+5, row);
        sheet.addCell(new Label(column, row, "All employees",newFormat));
        row+=1;
        sheet.mergeCells(column, row, column+5, row);
        row+=1;
        sheet.addCell(new Label(column, row, "Id",cellFormat));
        column++;
        sheet.addCell(new Label(column, row, "Name",cellFormat));
        column++;
        sheet.addCell(new Label(column, row, "Age",cellFormat));
        column++;
        sheet.addCell(new Label(column, row, "Gender",cellFormat));
        column++;
        sheet.addCell(new Label(column, row, "Skills",cellFormat));
        column++;
        sheet.addCell(new Label(column, row, "Department",cellFormat));
        column++;
        sheet.addCell(new Label(column, row, "Permanent Address 1",cellFormat));
        column++;
        sheet.addCell(new Label(column, row, "Permanent Address 2",cellFormat));
        column++;
        sheet.addCell(new Label(column, row, "Permanent Country",cellFormat));
        column++;
        sheet.addCell(new Label(column, row, "Temporary Address 1",cellFormat));
        column++;
        sheet.addCell(new Label(column, row, "Temporary Address 2",cellFormat));
        column++;
        sheet.addCell(new Label(column, row, "Temporary Country",cellFormat));
        
        for(Employee employee:employees) {
        	row++;
            column=0;
            sheet.addCell(new Number(column, row, employee.getEmployeeId()));
            column++; 
            sheet.addCell(new Label(column, row, employee.getName()));
            column++;
            sheet.addCell(new Number(column, row, employee.getAge()));
            column++;
            sheet.addCell(new Label(column, row, employee.getGender()));
            column++;
            sheet.addCell(new Label(column, row, employee.getSkills()));
            column++;
            sheet.addCell(new Label(column, row, employee.getDepartment()));
            column++;
            sheet.addCell(new Label(column, row, employee.getAddress().getPermanentaddress1()));
            column++;
            sheet.addCell(new Label(column, row, employee.getAddress().getPermanentaddress2()));
            column++;
            sheet.addCell(new Label(column, row, employee.getAddress().getPermanentCountry()));
            column++;
            sheet.addCell(new Label(column, row, employee.getAddress().getTemporaryaddress1()));
            column++;
            sheet.addCell(new Label(column, row, employee.getAddress().getTemporaryaddress2()));
            column++;
            sheet.addCell(new Label(column, row, employee.getAddress().getTemporaryCountry()));
          }
		}
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
	}
	
	public static void autoSizeColumns(WritableSheet sheet)
	{
		 CellView cf = new CellView();
         cf.setAutosize(true);
         sheet.setColumnView(1, cf);
         sheet.setColumnView(4, cf);
         sheet.setColumnView(5, cf);
         sheet.setColumnView(6, cf);
         sheet.setColumnView(7, cf);
         sheet.setColumnView(8, cf);
         sheet.setColumnView(9, cf);
         sheet.setColumnView(10, cf);	
	}
	
	public static void exportUsers(ArrayList<Employee> employees)
	{
		WritableWorkbook workbook;
		int row = 0;
		int column = 0;
	
        try {
            workbook = Workbook.createWorkbook(new File("C:\\Users\\IGS\\Downloads\\EmployeeList.xls"));
            WritableSheet sheet = workbook.createSheet("Employees", row);
            writeData(sheet,row,column,employees);
            autoSizeColumns(sheet);
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
	}
}
