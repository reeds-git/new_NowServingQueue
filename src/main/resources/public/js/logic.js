$(document).ready(function(){

    var times = [7];

	// refresh the times
	var x = setInterval(function() {
	  updateTimes();
	},
//	60); // 1 min in milliseconds
	60000); // 1 min in milliseconds

    function updateTimes() {

        for (i = 0; i < times.length; i++) {
            times[i] += 1;
            var temp = "td" + i;
            console.log(temp);
            document.getElementById(temp).innerHTML = times[i];
        }
    }
    $("#name").change(function(){
        if ($("#name").value === "") {
            $("#addBtn").prop("disabled", true)
        } else {
            $("#addBtn").prop("disabled", false)
        }
    });

    var $queue = $('#queueTable');
    var $errorMessage = $('#errorMessage');

    function getAllStudents() {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/students',
            success: function(students) {
                $.each(students, function(index, student) {
                    addStudentToQueue(student);
                });
            }
        });
    }

    function getFormData(formID) {

        var currentForm = '#'+ formID;
        var formData = $(currentForm).serialize();
        var data = JSON.parse('{"' + decodeURI(formData.replace(/&/g, "\",\"").replace(/=/g,"\":\"")) + '"}')

        return JSON.stringify(data);
    }

    // call API to add new student
    function addStudentToQueue(student) {
        $queue.append('<tr id="tr' + student.id + '"><td>' + student.name + '</td><td>' + student.course + '</td><td id="td'
        + student.id + '">' + times[student.id] + '</td><td></td></tr>')
    }

    function updateStudentInQueue(student) {
        $('<tr + #' + student.id).replace('<tr id="' + student.id + '"><td>' + student.name + '</td><td>'
         + student.course + '</td><td>' + times[student.id] + '</td><td></td></tr>')
    }

    $("#addBtn").on('click', function(e){

        e.stopPropagation() ;
        e.preventDefault();

        $.ajax({
            url: 'http://localhost:8080/student',
            type : "POST",
            contentType : 'application/json',
            dataType: "json",
            data : getFormData("addHelpRequest"),
            success : function(student) {

                if (times.length < student.id) {
                    times[student.id] = 1;
                } else {
                    times.push(1);
                }
                addStudentToQueue(student);
            },
            error: function(xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        });
    });
});

function resetTimes() {
    console.log("page reset ");
    var emptyJson = {};

    $.ajax({
        url: 'http://localhost:8080/reset',
        type : "DELETE",
        contentType : 'application/json',
        dataType: "json",
        data : emptyJson,
        success : function(response) {
            console.log("Student Queue reset");
        },
        error: function(xhr, resp, text) {
            console.log(xhr, resp, text);
        }
    });
}