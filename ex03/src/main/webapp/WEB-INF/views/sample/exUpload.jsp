<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 25. 6. 10.
  Time: 오후 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sample/exUploadPost" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
  <div>
    <input type="file" name="files"/>
  </div>
  <div>
    <input type="file" name="files"/>
  </div>
  <div>
    <input type="file" name="files"/>
  </div>
  <div>
    <input type="file" name="files"/>
  </div>
  <div>
    <input type="file" name="files"/>
  </div>
  <div>
    <input type="submit"/>
  </div>
</form>
</body>
</html>
