<%@page import="com.exam.DAO.studentDAO"%>
<<<<<<< HEAD
=======
<%@page import="com.exam.model.Student"%>
>>>>>>> abae294 (added code for rquest sent)
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	ServletContext sc1=request.getServletContext();
	Student s1=(Student)sc1.getAttribute("student-obj");
	if(s1==null){
		session.setAttribute("pls-login", "Please Login Here...");
		response.sendRedirect("Login.jsp");
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile | ThinkExam</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/profile.css">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
	<%
	int studId = Integer.parseInt(request.getParameter("stud_id"));
	studentDAO sd = new studentDAO();
	Student s = sd.getDataById(studId);
	%>

	<div class="wrapper">

		<%@ include file="all_component/student-navbar.jsp"%>

		<div class="container">
			<div class="main-body">

				<!-- Breadcrumb -->
				<nav aria-label="breadcrumb" class="main-breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="StudentDashboard.jsp">Dashboard</a></li>
						<li class="breadcrumb-item"><a href="StudentProfile.jsp">My Profile</a></li>

						<li class="breadcrumb-item active" aria-current="page">Edit
							Profile</li>
					</ol>
				</nav>
				<!-- /Breadcrumb -->

				<div class="row gutters-sm">
					<div class="col-md-4 mb-3">
						<div class="card">
							<div class="card-body">
								<div class="d-flex flex-column align-items-center text-center">
									<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
										alt="Admin" class="rounded-circle" width="150">
									<div class="mt-3">
										<h4><%=s.getfName()%>&nbsp<%=s.getlName()%></h4>
										<button class="btn btn-outline-primary">
											Id :
											<%=s.getStudId()%></button>
									</div>
								</div>
							</div>
						</div>

					</div>

					<input type="hidden" value="<%=studId%>" name="studid">
					<div class="col-md-12">

						<div class="card mb-3">
							<form action="EditStudentProfileServlet" method="post">
								<div class="card-body">

									<div class="row">
										<div class="col-sm-4">
											<h6 class="mb-0">Student Id</h6>
										</div>
										<div class="col-sm-8 ">
											<input type="text" class="form-control"
												value="<%=s.getStudId()%>" name="sid" readonly="readonly">
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-4">
											<h6 class="mb-0">Full Name</h6>
										</div>
										<div class="col-sm-8 text-secondary">
											<input type="text" class="form-control"
												value="<%=s.getfName()%> <%=s.getlName()%>"
												readonly="readonly">
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-4">
											<h6 class="mb-0">Email</h6>
										</div>
										<div class="col-sm-8 text-secondary">
											<input type="text" class="form-control"
												value="<%=s.getEmail()%>" name="email" required="required">
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-4">
											<h6 class="mb-0">Mobile</h6>
										</div>
										<div class="col-sm-8 text-secondary">
											<input type="text" class="form-control"
												value="<%=s.getMobNo()%>" name="mob" required="required">
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-4">
											<h6 class="mb-0">Date Of Birth</h6>
										</div>
										<div class="col-sm-8 text-secondary">
											<input type="date" class="form-control"
												value="<%=s.getDob()%>" name="dob" required="required">
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-4">
											<h6 class="mb-0">Gender</h6>
										</div>
										<div class="col-sm-8 text-secondary">
											<input type="text" class="form-control"
												value="<%=s.getGender()%>" name="gender" readonly="readonly">
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-4">
											<h6 class="mb-0">City</h6>
										</div>
										<div class="col-sm-8 text-secondary">
											<input type="text" class="form-control"
												value="<%=s.getCity()%>" name="city" required="required">
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-4">
											<h6 class="mb-0">State</h6>
										</div>
										<div class="col-sm-8 text-secondary">
											<input type="text" class="form-control"
												value="<%=s.getState()%>" name="state" required="required">
										</div>
									</div>
									<hr>
									<hr>
									<div class="row">
										<div class="col-sm-12">
											<button class="btn btn-success" >Save
												Changes</button>
										</div>
									</div>
								</div>

							</form>
						</div>

					</div>
				</div>



			</div>
		</div>

	</div>


	<script src="plugins/jquery/jquery.min.js"></script>
	<script src="plugins/jquery-ui/jquery-ui.min.js"></script>

	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
</body>
</html>