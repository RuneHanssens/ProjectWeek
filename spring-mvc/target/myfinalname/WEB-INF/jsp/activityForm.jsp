<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add new activity</title>
</head>
<%@include file="header.jspf"%>
<body>
<div class="container">
<form:form modelAttribute = "activity" action="${post_url}" method = "post">
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
            <td><form:errors path="name" /></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:input path="description" /></td>
            <td><form:errors path="description"  /></td>
        </tr>
        <tr>
            <td>Date:</td>
            <td><form:input path="date" /></td>
            <td><form:errors path="date"  /></td>
        </tr>
        <tr>
            <td>Start time:</td>
            <td><form:input path="startTime" /></td>
            <td><form:errors path="startTime"  /></td>
        </tr>
        <tr>
            <td>End time:</td>
            <td><form:input path="endTime" /></td>
            <td><form:errors path="endTime"  /></td>
        </tr>
        <tr>
            <td>Location:</td>
            <td><form:input path="location" /></td>
            <td><form:errors path="location"  /></td>
        </tr>
        <tr>
            <td colspan="3">
                <input id="submit" type="submit" value="Save" />
            </td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>
