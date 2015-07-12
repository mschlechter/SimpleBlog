<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
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
    </ul>

    <ul class="nav navbar-nav navbar-right">
      <li><a href="<c:url value="/signin" />">Sign in</a></li>
    </ul>

    <!-- <p class="navbar-text navbar-right">Signed in as Mark Otto</p> -->

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