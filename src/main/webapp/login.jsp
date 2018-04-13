<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>代理商管理系统</title>
  <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"  type="text/javascript"></script>
  <script src="${pageContext.request.contextPath }/js/jquery-form.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath }/js/login.js" type="text/javascript"></script>
  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

  <link href="${pageContext.request.contextPath }/js/login.css" rel='stylesheet' type='text/css' />
  <!--//webfonts-->

</head>
<body>
<script>


    $(document).ready(function(c) {
    $('.close').on('click', function(c){
        $('.myLogin').fadeToggle();
    });




});
</script>
<!--SIGN UP-->
<h1>欢迎来到代理商系统页面</h1>
<div class="login-form">
  <div class="close"> </div>
  <div class="head-info">
    <label class="lbl-1"> </label>
    <label class="lbl-2"> </label>
    <label class="lbl-3"> </label>
  </div>
  <div class="clear"> </div>
  <div class="avtar">
    <img src="${pageContext.request.contextPath }/images/login/avtar.png" />
  </div>

  <form method="post" action="" id="myLogin">
    <input type="hidden" id="path" value="${pageContext.request.contextPath }" name="path"/>
      <input type="text" class="text" name="userAccount" value="${userInfo.userAccount}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'username';}" >
      <div class="key">
        <input type="password" name="userPassword"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'user_password';}">
      </div>
    <div class="signin">
      <input type="button"  id="login" value="登录" >
    </div>
  </form>

</div>
</body>
</html>


