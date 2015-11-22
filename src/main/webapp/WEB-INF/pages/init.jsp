<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<style type="text/css">
body {
	color: #fff;
	font-family: Microsoft YaHei, Segoe UI, Tahoma, Arial, Verdana,
		sans-serif;
	text-align: center;
}

input {
	background: none repeat scroll 0 0 rgba(45, 45, 45, 0.15);
	border: 1px solid rgba(255, 255, 255, 0.15);
	border-radius: 6px;
	box-shadow: 0 2px 3px 0 rgba(0, 0, 0, 0.1) inset;
	color: #fff;
	font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	font-size: 14px;
	height: 42px;
	margin-top: 25px;
	padding: 0 15px;
	text-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
	transition: all 0.2s ease 0s;
	width: 270px;
}
</style>
</head>
<body background="static/image/initBG.jpg">
	<div id="context">

		<form action="j_spring_security_check" method="post">
			<div id="loginDialog">
				<div>
					<input type="text" name="username" class="username"
						placeholder="请输入您的用户名！" />
				</div>
				<div>
					<input type="password" name="password" class="password"
						placeholder="请输入您的用户密码！" />
				</div>
				<div>
					<button type="submit" class="submit_button">登录</button>
				</div>


			</div>
		</form>

	</div>
</body>
</html>