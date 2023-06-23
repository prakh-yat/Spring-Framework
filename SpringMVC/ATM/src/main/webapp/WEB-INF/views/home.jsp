<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>Home</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="profile">Profile</a>
            </li>
        </ul>
    </div>
</nav>
<h2>Welcome, ${ud.username}</h2>
<h3>Account Number: ${ad[0].accountNo}</h3>
<h3>Balance: ${ad[0].balance}</h3>
<%--<h3>Account Type: ${ad[0].accountType}</h3>--%>

<div class="container">
    <div class="container mt-5">
        <div class="form-control w-25 p-3">
            <form action="transaction" method="post">
                <input type="hidden" class="form-control" name="username" value="${ud.username}">
                    <input type="hidden" class="form-control" name="accountNo" value="${ad[0].accountNo}">
                    <input type="hidden" class="form-control" name="balance" value="${ad[0].balance}">
                <div class="container text-center">
                    <button type="submit" class="btn btn-success">Transaction</button>
                </div>
            </form>
<%--            <a  href="transaction?accountNo=${ad.accountNo}&&balance=${ad.balance}">Transaction</a>--%>
        </div>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
