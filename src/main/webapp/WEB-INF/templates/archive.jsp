<%@include file="pageheader.jsp" %>

<div class="container">
  <div class="page-header">
    <h2>Archive</h2>
  </div>
</div>

<spring:url value="/archive" var="searchActionUrl" />

<div class="container">

<form:form modelAttribute="searchModel" action="${searchActionUrl}" method="post">

  <div class="form-group">
    <label for="search">Search:</label>
    <form:input path="searchText" type="text" class="form-control" id="search" placeholder="search" />
  </div>

  <button type="submit" class="btn btn-default">Search</button>

  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</form:form>

  </div>

<c:choose>
  <c:when test="${not empty blogPosts}">

    <div class="container">

    <table class="table table-striped">
    <thead>
    <tr>
      <th>Title</th>
      <th>Date</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="blogPost" items="${blogPosts}">

      <tr>
        <td><a href="post/${blogPost.id}">${blogPost.title}</a></td>
        <td>${blogPost.formattedDate}</td>
      </tr>

    </c:forEach>

    </tbody>
    </table>

    </div>

  </c:when>
  <c:otherwise>

    <div class="container">
      This blog is empty.
    </div>


  </c:otherwise>
</c:choose>


<%@include file="pagefooter.jsp" %>
