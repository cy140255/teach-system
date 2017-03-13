<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8" />
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
    <title>Login and Registration Form with HTML5 and CSS3</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
    <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
    <meta name="author" content="Codrops" />
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
</head>
<body>
<div class="container">
    <!-- Codrops top bar -->
    <div class="codrops-top">
        <a href="">
            <strong>&laquo; 教务系统: </strong>
        </a>

        <div class="clr"></div>
    </div><!--/ Codrops top bar -->
    <header>

        <nav class="codrops-demos">
            <a href="javascript:void(0)"></a>
            <a href="javascript:void(0)"></a>
            <a href="javascript:void(0)"></a>
        </nav>
    </header>
    <section>
        <div id="container_demo" >
            <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form  action="login.do" autocomplete="on">
                        <h1>教务系统</h1>
                        <p>
                            <label for="username" class="uname" data-icon="u" > 账号 </label>
                            <input id="username" name="userName" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> 密码 </label>
                            <input id="password" name="pwd" required="required" type="password" placeholder="eg. X8df!90EO" />
                        </p>

                        <p class="login button">
                            <input type="submit" value="登录" />
                        </p>
                        <p class="change_link">
                            <a href="#toregister" class="to_register">忘记密码?</a>
                        </p>
                    </form>
                </div>

                <div id="register" class="animate form">
                    <form  action="mysuperscript.php" autocomplete="on">
                        <h1> 找回密码 </h1>
                        <p>
                            <label for="usernamesignup" class="uname" data-icon="u"> 账号 </label>
                            <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="账号" />
                        </p>
                        <p>
                            <label for="emailsignup" class="youmail" data-icon="e" > 身份证后六位</label>
                            <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="身份证后六位"/>
                        </p>
                        <p>
                            <label for="passwordsignup" class="youpasswd" data-icon="p"> 密码 </label>
                            <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="密码"/>
                        </p>
                        <p>
                            <label for="passwordsignup_confirm" class="youpasswd" data-icon="p"> 确认密码 </label>
                            <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="确认密码"/>
                        </p>
                        <p class="signin button">
                            <input type="submit" value="确定"/>
                        </p>
                        <p class="change_link">
                            突然想起密码了？
                            <a href="#tologin" class="to_register"> 去登录 </a>
                        </p>
                    </form>
                </div>

            </div>
        </div>
    </section>
</div>
</body>
</html>