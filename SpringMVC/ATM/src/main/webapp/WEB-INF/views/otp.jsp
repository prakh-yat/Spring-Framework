<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>OTP Confirmation</title>
</head>
<body>
<h1>OTP Confirmation</h1>
<form action="verify-otp" method="POST">
    <label for="otp">Enter OTP:</label>
    <input type="text" id="otp" name="otp" required>
    <br>
    <input type="submit" value="Verify OTP">
</form>
</body>
</html>
