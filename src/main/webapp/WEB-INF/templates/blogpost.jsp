<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>${blogTitle}</title>

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

<div class="jumbotron">
  <div class="container">
    <h1>${blogConfig.blogTitle}</h1>
    <p class="hidden-xs">
      ${blogConfig.blogSubTitle}
    </p>
  </div>
</div>
<ol class="breadcrumb">
  <li><a href="../">Home</a></li>
  <li class="active">${blogPost.title}</li>
</ol>

<div class="container">
  <div class="page-header">
    <h2>${blogPost.title} <small class="hidden-xs">geplaatst op ${blogPost.formattedDate}</small></h2>

  </div>

  <p>
    ${blogPost.contentHtml}
  </p>
</div>




</body>
</html>
