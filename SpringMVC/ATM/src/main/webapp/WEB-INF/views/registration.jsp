<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        .courses {
            height: 150px;
            overflow-y: scroll;
        }
    </style>

</head>

<body>
<div class="container mt-5">
    <form action="register" method="POST">
        <div class="form-group">
            <label for="customerName">Customer Name:</label>
            <input type="text" class="form-control" id="customerName" name="customerName" placeholder="Enter full name" required>
        </div>

        <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Enter username" required>
        </div>

        <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
        </div>

        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email" placeholder="Enter email">
        </div>

        <div class="container text-center">
            <button type="submit" class="btn btn-success">Sign Up</button>
        </div>
    </form>

</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>
