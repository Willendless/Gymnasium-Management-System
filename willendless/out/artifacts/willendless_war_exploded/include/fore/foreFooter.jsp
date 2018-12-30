<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>


<div class="modal " id="loginModal" tabindex="-1" role="dialog" >
    <div class="modal-dialog loginDivInProductPageModalDiv">
        <div class="modal-content">
            <div class="loginDivInProductPage">

                <div class="alert" style="padding: 5px">
                    <span class="errorMessage" style="color: red;"></span>
                </div>


                <div class="login_acount_text">账户登录</div>
                <div class="loginInput " >
                            <span class="loginInputIcon ">
                                <span class=" glyphicon glyphicon-user"></span>
                            </span>
                    <input id="name" name="name"  type="text" placeholder="用户名">
                </div>

                <div class="loginInput " >
                            <span class="loginInputIcon ">
                                <span class=" glyphicon glyphicon-lock"></span>
                            </span>
                    <input id="password" name="password"  type="password" placeholder="密码" type="text">
                </div>
                <div>
                    <a href="register.jsp" class="pull-right">免费注册</a>
                </div>
                <div style="margin-top:20px">
                    <button class="btn btn-block redButton loginSubmitButton" type="submit">登录</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="deleteConfirmModal" tabindex="-1" role="dialog" >
    <div class="modal-dialog deleteConfirmModalDiv">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">确认删除？</h4>
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button class="btn btn-primary deleteConfirmButton" id="submit" type="button">确认</button>
            </div>
        </div>
    </div>
</div>



<div id="footer" style="height: 50px;
    background-color: transparent;
	line-height: 50px;
	color: black;
	clear: both;">
    <p class="text-center">designed by WangYueying and LiJiarui</p>
</div>

</body>
</html>