<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Hello, World!!!</h1>
${key}
<ul>
    <c:forEach items="${list}" var="xwp">
        <li>${xwp.timestamp}</li>
    </c:forEach>
</ul>
