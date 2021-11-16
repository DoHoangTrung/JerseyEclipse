<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap CRUD Data Table for Database with Modal Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<script src="js/script.js"></script>

</head>
<body>
	<div class="container-xl">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-6">
							<h2>
								<b>Quan ly sinh vien</b>
							</h2>
						</div>
						<div class="col-sm-6">
							<a href="#addEmployeeModal" class="btn btn-success"
								data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Thêm
									sinh viên</span></a>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>STT</th>
							<th>Tên</th>
							<th>Ngày sinh</th>
							<th>Lớp</th>
							<th>Điểm</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="num" value="1"></c:set>
						<c:forEach items="${listSinhVien }" var="sv" varStatus="loop">
							<tr>
								<td>${loop.count }</td>
								<td>${sv.ten }</td>
								<td>${sv.ngaySinh }</td>
								<td>${sv.lop }</td>
								<td>${sv.diem }</td>
								<td><a href="#editEmployeeModal" class="edit"
									data-toggle="modal"><i class="material-icons"
										data-toggle="tooltip" title="Edit">&#xE254;</i></a> <a
									href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i
										class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>

									<input type="hidden" id="id" value="${sv.id }">
									<input type="hidden" id="tenSv" value="${sv.ten }"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form method="post" action="sv">
					<div class="modal-header">
						<h4 class="modal-title">Thêm sinh viên</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Tên sinh viên</label> 
							<input name="ten" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Ngày sinh</label> 
							<input name="ngay" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Lớp</label> 
							<input name="lop" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Điểm</label> 
							<input name="diem" type="text"	class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> 
						<input type="submit" class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form method="post" action="updateSv">
					<div class="modal-header">
						<h4 class="modal-title">Sửa sinh viên</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Tên</label> <input id="ten" name="ten" type="text" class="form-control"
								required>
						</div>
						<div class="form-group">
							<label>Ngày sinh</label> <input id="ngay" name="ngay" type="text" class="form-control"
								required>
						</div>
						<div class="form-group">
							<label>Lớp</label><input id="lop" name="lop" type="text" class="form-control"
								required>
						</div>
						<div class="form-group">
							<label>Điểm</label> <input id="diem" name="diem" type="text" class="form-control"
								required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit" class="btn btn-info"
							value="Save">
						<input type="hidden" id="id" name="id" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Delete Modal HTML -->
	<div id="deleteEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form method="post" action="deleteSv">
					<div class="modal-header">
						<h4 class="modal-title">Delete Employee</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<p>Bạn chắc chắn muốn xoá sinh viên </p><p id="tenSv"></p>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-danger" value="Delete"> 
						<input type="hidden" id="id" name="id" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>