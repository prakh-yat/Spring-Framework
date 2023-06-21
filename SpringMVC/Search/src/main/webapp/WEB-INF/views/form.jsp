
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Bootstrap Form Example</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        .scrollable-area {
            height: 150px;
            overflow-y: scroll;
        }
    </style>
</head>

<body>
<div class="container mt-5">
    <form>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter your name">
        </div>

        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" id="id" placeholder="Enter your ID">
        </div>

        <div class="form-group">
            <label for="dob">Date of Birth:</label>
            <input type="date" class="form-control" id="dob">
        </div>

        <div class="form-group">
            <label for="gender">Gender:</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gender" id="male" value="male">
                <label class="form-check-label" for="male">
                    Male
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gender" id="female" value="female">
                <label class="form-check-label" for="female">
                    Female
                </label>
            </div>
        </div>

        <div class="form-group">
            <label for="dropdown">Dropdown:</label>
            <select class="form-control" id="dropdown">
                <option>Old</option>
                <option>New</option>
            </select>
        </div>

        <div class="form-group">
            <label>Subject</label>
            <div class="scrollable-area">
                <ul class="list-group">
                    <li class="list-group-item">Python</li>
                    <li class="list-group-item">Java</li>
                    <li class="list-group-item">C</li>
                    <li class="list-group-item">C#</li>
                    <li class="list-group-item">C++</li>
                </ul>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>
