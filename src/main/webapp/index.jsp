<%@ page language="java" contentType="text/html; charset=utf-8" %>
<html>
<body>
<h2>Hello World!</h2>

<form action="/hts/admin/addStu.do" method="post" enctype="application/json">
    学号：<input name="stuNum" type="text">
    姓名：<input name="stuName" type="text">
    学院：<input name="stuInstitute" type="text">
    性别：<input name="stuSex" type="text">
    年级：<input name="stuGrade" type="text">
    专业：<input name="stuMajor" type="text">
    班级：<input name="stuClass" type="text">
    <input value="添加学生" type="submit">
</form>

<form action="/hts/admin/importStu.do" method="post" enctype="multipart/form-data">
    <input type="file" name="filename">
    <input value="导入学生名单" type="submit">
</form>
</body>
</html>
