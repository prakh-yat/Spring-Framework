<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List" %>
<%@ page isELIgnored="false" %>
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
    <h2>Account Number:${acc}</h2>
    <h2>Balance:${bal}</h2>

    <form action="transfer" method="POST">

            <input type="hidden" name="userAcc" value="${acc}">
        <input type="hidden" name="username" value="${use}">

        <div class="form-group">
            <label for="type">Transaction Type</label>
                <select class="form-control" id="dropdown" name="type">
                    <option>Fund Transfer</option>
                    <option>Deposit</option>
                    <option>Withdraw</option>
                </select>
        </div>

        <div class="form-group">
            <label for="accountNo">Account Number</label>
            <input type="text" class="form-control" id="accountNo" name="accountNo" placeholder="Enter account number" required>
        </div>

        <div class="form-group">
            <label for="amount">Amount</label>
            <input type="number" class="form-control" id="amount" name="amount" placeholder="Enter amount" required>
        </div>

        <div class="form-group">
            <label for="remarks">Remarks</label>
            <input type="text" class="form-control" id="remarks"  name="remarks" placeholder="Enter email">
        </div>

        <div class="container text-center">
            <button type="submit" class="btn btn-success">Proceed</button>
        </div>
    </form>

</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>
