<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>



<h3>Student list</h3>
<br>
<div class="mx-auto" style="width: 500px; text-align: center">
<table class="table table-sm  ">
    <thead class="thead-blue">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Grupa</th>
        <th>Mark</th>
        <th>Delete</th>
<#--        <th>Edit</th>-->
    </tr>
    <#list students as student>
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.grupa}</td>
            <td>${student.mark}</td>
            <td><a href="/student/delete/${student.id}">Delete</a></td>
<#--            <td><button type="button" class="btn btn-outline-primary">Delete</button></td>-->
        </tr>
    </#list>
</table>
    <a href="/student/add">Add new student</a>
<#--    <div>-->

<#--        <br>-->
<#--        <br>-->
<#--        <fieldset>-->
<#--            <legend>Add student</legend>-->
<#--            <form name="student" action="" method="POST">-->
<#--                <label>Name:</label>-->
<#--                <input type="text">-->
<#--                <br>-->
<#--                <label>Mark:</label>-->
<#--                <input type="text">-->
<#--                <br>-->
<#--                <input type="submit" value="Create"/>-->
<#--            </form>-->
<#--        </fieldset>-->
<#--    </div>-->
</div>
</body>
</html>