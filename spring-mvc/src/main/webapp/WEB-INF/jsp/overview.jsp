<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Activity overview</title>
</head>
<%@include file="header.jspf"%>
<body>
<table>
    <tr>
        <th>Activity</th>
        <th>Description</th>
        <th>Location</th>
        <th>Date</th>
        <th>Start</th>
        <th>End</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${activities}" var="activity">
        <tr id="${activity.id}">
            <td>${activity.name}</td>
            <td>${activity.description}</td>
            <td>${activity.location}</td>
            <td>${activity.date}</td>
            <td>${activity.startTime}</td>
            <td>${activity.endTime}</td>
            <td><a id="delete${activity.id}" href="<c:url value="/activity/${activity.id}-delete.htm"/>">Delete</a></td>
            <td><a id="edit${activity.id}" href="<c:url value="/activity/${activity.id}-editForm.htm"/>">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/activity/new.htm"/>">New</a>
</body>
</html>
