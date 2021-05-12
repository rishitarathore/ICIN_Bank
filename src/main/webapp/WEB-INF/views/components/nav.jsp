<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <nav class="navbar navbar-expand-lg navbar-light">
    <a href="#" id="custom-navbar-brand" class="navbar-brand ">
     <img src="../images/logo-1.png" width="220px" alt="">
   
    </a>  		
    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
      <span class="navbar-toggler-icon"></span>
    </button>
    <ul class="navbar-nav  ml-auto" style="margin-left: auto;">
    
    	<c:if test ="${user_id == null && admin_id == null}"> 
				
			<li class="nav-item "><a href="/register" class="nav-link pr-4 ">User Register</a></li>	

			<li class="nav-item dropdown"><a class="nav-link " href=""
				id="navbarDropdown" role="button" data-mdb-toggle="dropdown"
				aria-expanded="false"> Login <i id="custom-icon-dropdown"
					class="mx-2 fas fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="/user">User</a></li>
					<li><a class="dropdown-item" href="/admin">Admin</a></li>

				</ul></li>
		</c:if>
		
		<c:if test="${user_id != null }">

			<li class="nav-item "><a href="/user/dashboard" class="nav-link pr-4 ">Dashboard</a></li>
			<li class="nav-item dropdown"><a class="nav-link" href="#"
				id="navbarDropdown" role="button" data-mdb-toggle="dropdown"
				aria-expanded="false"> Hello, ${user_username} <i
					id="custom-icon-dropdown" class="mx-1 fas fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				<li><a class="dropdown-item" href="/user/editprofile">Edit Profile </a></li>
				<li><a class="dropdown-item" href="/user/changePassword">Change Password</a></li> 
					<li><a class="dropdown-item" href="/logout">Logout</a></li>
				</ul></li>
			 
		</c:if>
		
		<c:if test="${admin_id != null }">

			<li class="nav-item "><a href="/admin/dashboard"
				class="nav-link pr-4 ">Dashboard</a></li>

			<li class="nav-item dropdown"><a class="nav-link" href="#" id="navbarDropdown" role="button" data-mdb-toggle="dropdown"
				aria-expanded="false"> Hello, ${admin_username} <i
					id="custom-icon-dropdown" class="mx-1 fas fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			<!-- 		<li><a class="dropdown-item" href="/admin/changePassword">Change Password</a></li> -->
					<li><a class="dropdown-item" href="/logout">Logout</a></li>
				</ul></li>

		</c:if>
    </ul>
  </nav>
  

