﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE>编辑联系人</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
          rel=stylesheet>


    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<FORM id=form1 name=form1
      action="LinkManAction_update"
      method=post>

    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
                              border=0></TD>
            <TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
                height=20></TD>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
                              border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
                    src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
            <TD vAlign=top width="100%" bgColor=#ffffff>
                <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
                    <TR>
                        <TD class=manageHead>当前位置：联系人管理 &gt; 修改联系人</TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>

                <s:iterator value="#list">
                    <input type="hidden" name="lkm_id" value="${lkm_id }"/>
                    <TABLE cellSpacing=0 cellPadding=5 border=0>

                        <TR>
                            <td>联系人名称：</td>
                            <td>
                                <INPUT class=textbox id=sChannel2
                                       style="WIDTH: 180px" maxLength=50 name="lkm_name" value="${lkm_name}">
                            </td>
                            <td>联系人性别：</td>
                            <td>
                                <input type="radio" value="1" name="lkm_gender"
                                       <c:if test="${lkm_gender=='1' }">checked</c:if>>男

                                <input type="radio" value="2" name="lkm_gender"
                                       <c:if test="${lkm_gender=='2' }">checked</c:if>>女
                            </td>
                        </TR>
                        <TR>
                            <td>联系人办公电话 ：</td>
                            <td>
                                <INPUT class=textbox id=sChannel2
                                       style="WIDTH: 180px" maxLength=50 name="lkm_phone" value="${lkm_phone}">
                            </td>
                            <td>联系人手机 ：</td>
                            <td>
                                <INPUT class=textbox id=sChannel2
                                       style="WIDTH: 180px" maxLength=50 name="lkm_mobile" value="${lkm_mobile}">
                            </td>
                        </TR>
                        <TR>
                            <td>联系人邮箱 ：</td>
                            <td>
                                <INPUT class=textbox id=sChannel2
                                       style="WIDTH: 180px" maxLength=50 name="lkm_phone" value="${lkm_email}">
                            </td>
                            <td>联系人QQ ：</td>
                            <td>
                                <INPUT class=textbox id=sChannel2
                                       style="WIDTH: 180px" maxLength=50 name="lkm_mobile" value="${lkm_qq}">
                            </td>
                        </TR>
                        <TR>
                            <td>联系人职位 ：</td>
                            <td>
                                <INPUT class=textbox id=sChannel2
                                       style="WIDTH: 180px" maxLength=50 name="lkm_phone" value="${lkm_position}">
                            </td>
                            <td>联系人备注 ：</td>
                            <td>
                                <INPUT class=textbox id=sChannel2
                                       style="WIDTH: 180px" maxLength=50 name="lkm_mobile" value="${lkm_memo}">
                            </td>
                        </TR>
                        <tr>
                            <td rowspan=2>
                                <INPUT class=button id=sButton2 type=submit
                                       value="保存 " name=sButton2>
                            </td>
                        </tr>
                    </TABLE>
                </s:iterator>

            </TD>
            <TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
                <IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
                              border=0></TD>
            <TD align=middle width="100%"
                background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
                              border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
</FORM>
</BODY>
</HTML>
