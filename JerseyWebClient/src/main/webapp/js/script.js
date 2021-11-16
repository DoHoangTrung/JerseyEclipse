$(document).ready(function() {

	$('[data-toggle="tooltip"]').tooltip();

	$('.table .delete').on('click', function() {
		var id = $(this).parent().find('#id').val();
		var name = $(this).parent().find('#tenSv').val();
		$('#deleteEmployeeModal #id').val(id);
		$('#deleteEmployeeModal #tenSv').text(name);
	});

	$('.table .edit').on('click', function(){
		var id = $(this).parent().find('#id').val();

		//lay du lieu tu tr table		
		var currentRow = $(this).closest("tr");
		var ten = currentRow.find("td:eq(1)").text();
		var ngay = currentRow.find("td:eq(2)").text();
		var lop = currentRow.find("td:eq(3)").text();
		var diem = currentRow.find("td:eq(4)").text();
		
		//gan du lieu cho bootstrap modal
		$('#editEmployeeModal #id').val(id);
		$('#editEmployeeModal #ten').val(ten);
		$('#editEmployeeModal #lop').val(lop);
		$('#editEmployeeModal #diem').val(diem);
		$('#editEmployeeModal #ngay').val(ngay);
	})
});	

