# Student_records
-- Student_records is a application form for students to input their information.<br>
-- This Application is built on Spring framework. 
<h3>Add the following dependencies to Maven first</h3>
--Spring-beans<br>
--Spring-core<br>
--Spring-context<br>
--Spring-web<br>
--Spring-webmvc<br>

<h3>Student class</h3>
```Java
public class Student {
	private int id;
	private String name;
	
	public Student() {
		//super();
	}
	public Student(int id, String name) {
		//super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
```
<h3>Controller servlet maps student class to jsp</h3>
```Java
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ca.sheridancollege.beans.Student;

@Controller
public class HomeController {

	@RequestMapping("/")
	//model is a one size fits all container. We don't need to worry about session and request
	public String showHome(Model model){
		//this addAttribute methos will ask for name and value and value is an object which in this case a date
		model.addAttribute("rightnow", new Date());
		return "home2";
	}
	
	@RequestMapping("/input")
	//this will run the input and grab information there
	public String showInput(){
		return "input";
	}
	//get the input jsp's value from action processForm and get it as a post method
	@RequestMapping(value = "/processForm", method = RequestMethod.POST)
	//add the model and two parameter of type @RequestParam
	public String processForm(Model model, @RequestParam int id, @RequestParam String name){
		Student s = new Student(id, name);   //this should match with the names in jsp file
		//store the student object as a new attribute. Object is student and value is s
		model.addAttribute("student", s);
		return "display";
	}
}
```
<h3>Spring servlet</h3>
-- A xml file to tell what to map.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">

	<context:component-scan
		base-package="ca.sheridancollege.controllers">
	</context:component-scan>
	<mvc:annotation-driven></mvc:annotation-driven>
	<bean id="jspViewResolver"
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="prefix" value="/WEB-INF/jsps/"></property>
	<property name="suffix" value=".jsp"></property>
	</bean>
</beans>
```
<h3>Input JSP is a form for students to input their information</h3>
```JSP
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input Information</title>
</head>
<body>
	<h1>Please enter student information</h1>
	<form action="processForm" method="post">
		ID:<input type ="text" name = "id"/><br>
		Name:<input type = "text" name = "name"/><br><br>
		<input type = "submit" value = "Add Student"/>
		
	</form>
</body>
</html>
```
<h3>Display JSP to display the information in another web page</h3>
```JSP
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Students</title>
</head>
<body>
	<h1>View Students</h1>
	<!-- getting id and name of that student attribute -->
	ID: ${student.id}
	Name: ${student.name}

</body>
</html>
```
<h3>Web xml to use DispatcherServlet</h3>
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
  <display-name>Student_records</display-name>

  <servlet>
    <description></description>
    <display-name>Student_records</display-name>
    <servlet-name>Student_records</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  	<load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>Student_records</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
</web-app>
```




