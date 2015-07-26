<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
  <title>${blogConfig.blogTitle}</title>

  <script src="<c:url value="/vendor/jquery/jquery-1.11.3.min.js" />"></script>

  <link rel="stylesheet" href='<c:url value="/vendor/bootstrap/css/bootstrap.min.css" />' />
  <link rel="stylesheet" href='<c:url value="/vendor/bootstrap/css/bootstrap-theme.min.css" />' />
  <script src="<c:url value="/vendor/bootstrap/js/bootstrap.min.js" />"></script>

  <link rel="stylesheet" href='<c:url value="/default.css" />' />

  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href='<c:url value="/vendor/google-code-prettify/prettify.css" />' />
  <script src="<c:url value="/vendor/google-code-prettify/prettify.js" />"></script>

</head>
<body onload="prettyPrint()">

<nav class="navbar navbar-default">
  <div class="container">

    <ul class="nav navbar-nav">
      <li><a href="<c:url value="/" />">Home</a></li>
      <li><a href="<c:url value="/about" />">About</a></li>
      <li><a href="<c:url value="/archive" />">Archive</a></li>
    </ul>

    <c:choose>
      <c:when test="${pageContext.request.userPrincipal.name != null}">

        <form id="logoutForm" action="<c:url value="/logout" />" method="post">

          <ul class="nav navbar-nav navbar-right">
            <li><a href="javascript:;" onclick="document.getElementById('logoutForm').submit();">Sign out (${pageContext.request.userPrincipal.principal.friendlyName})</a></li>
          </ul>

          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        </form>

      </c:when>
      <c:otherwise>

        <ul class="nav navbar-nav navbar-right">
          <li><a href="<c:url value="/login" />">Sign in</a></li>
        </ul>

      </c:otherwise>
    </c:choose>

  </div>
</nav>

<div class="jumbotron">
  <div class="container">
    <h1>${blogConfig.blogTitle}</h1>
    <p class="hidden-xs">
      ${blogConfig.blogSubTitle}
    </p>
  </div>
</div>