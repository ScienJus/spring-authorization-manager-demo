<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Authorization Manager Demo</title>
    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
</head>
<body>

令牌：<input type="text" id="token"><br />
用户名：<input type="text" id="username"><br />
<input type="button" value="登录" id="login" />
<input type="button" value="查看登录用户名" id="show" />
<input type="button" value="退出登录" id="logout" /><br />

结果：
<p id="result" style="color:red;"></p>

演示方式：<br />
<ol>
  <li>点击[查看登录用户名]按钮，提示"未登录"。</li>
  <li>在[用户名]输入框中填入用户名，点击[登录]按钮（用户名可随意填写），得到令牌。</li>
  <li>在[令牌]输入框中填入刚才获得的令牌，点击[查看登录用户名]按钮，会出现刚才输入的用户名。</li>
  <li>在[令牌]输入框中填入刚才获得的令牌，点击[退出登录]按钮，提示"退出登录成功"。</li>
  <li>在[令牌]输入框中填入刚才获得的令牌，点击[查看登录用户名]按钮，提示"未登录"。</li>
</ol>

</body>
<script>
  $(document).ready(function(){
    $("#show").click(function() {
      var token = $("#token").val();
      $.ajax({
        type: 'GET',
        url: 'tokens' ,
        success: function(data) {
          $("#result").text(data.content);
          $("#username").val('');
          $("#token").val('');
        },
        error: function() {
          $("#result").text("未登录");
          $("#username").val('');
          $("#token").val('');
        },
        headers: {
          "authorization" : token
        }
      });
    });
    $("#logout").click(function() {
      var token = $("#token").val();
      $.ajax({
        type: 'DELETE',
        url: 'tokens' ,
        success: function() {
          $("#result").text("退出登录成功");
          $("#username").val('');
          $("#token").val('');
        },
        error: function() {
          $("#result").text("未登录");
          $("#username").val('');
          $("#token").val('');
        },
        headers: {
          "authorization" : token
        }
      });
    });
    $("#login").click(function() {
      var username = $("#username").val();
      if (!username) {
        alert("请输入用户名");
        return;
      }
      $.ajax({
        type: 'POST',
        url: 'tokens' ,
        data: "username=" + username,
        success: function(data) {
          $("#result").text(data.content);
          $("#username").val('');
          $("#token").val('');
        }
      });
    });
  });
</script>
</html>
