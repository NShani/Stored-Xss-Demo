<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stored XSS Demo - Sample Web Application Login</title>
</head>
<body>
<h1>Please Login</h1>
<form action="login" method="get">
    Username: <input type="text" name="username" value="" /><br />
    <input type="submit" value="Login" />
</form>
</body>
</html>