<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>仅供测试使用</title>
</head>
<body>
    <h1>空空如也</h1>
    <s:property value="#user_name"/>5<br><br>
    <s:property value="#user.user_name"/>6<br><br>
    <table border="1">
        <tr>
            <td>行业</td>
            <td>数量</td>
        </tr>
        <s:iterator value="#user" var="user">
            <s:property value="#user_name"/>1<br><br>
            <s:property value="#user.user_name"/>2<br><br>
            <s:property value="#user_code"/>3<br><br>
            <s:property value="#user.user_code"/>4
            <%--<tr>--%>
                <%--<td><s:property value="#user_code"/></td>--%>
                <%--<td><s:property value="#user.user_code"/></td>--%>
            <%--</tr>--%>
        </s:iterator>
    </table>
</body>
</html>