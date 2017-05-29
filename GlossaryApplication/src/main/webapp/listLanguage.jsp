<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Show All Languages</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Language Id</th>
                <th>Language</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${languages}" var="language">
                <tr>
                    <td><c:out value="${language.id}" /></td>
                    <td><c:out value="${language.name}" /></td>
                    <td><a href="LanguageController?action=edit&id=<c:out value="${language.id}"/>">Update</a></td>
                    <td><a href="LanguageController?action=delete&id=<c:out value="${language.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="LanguageController?action=insert">Add Language</a></p>
</body>
</html>
