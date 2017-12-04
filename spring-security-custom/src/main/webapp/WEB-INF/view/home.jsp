<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head></head>

<body>
    <h1>This is the body of the sample view</h1>

    <security:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')">
        This text is only visible to a user or an admin
        <br/>
        <a id="user" href="<c:url value="/user/user.html" />">User Page</a>
        <br/> <br/>
    </security:authorize>

    <security:authorize access="hasRole('ROLE_ADMIN')">
        This text is only visible to an admin
        <br/>
        <a id="admin" href="<c:url value="/admin/admin.html" />">Admin Page</a>
        <br/>
    </security:authorize>

    <br/>
    <a id="logout"" href="<c:url value="/logout" />">Logout</a>

</body>
</html>