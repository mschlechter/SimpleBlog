<%@include file="pageheader.jsp" %>

<div class="container">
  <div class="page-header">
    <h2>Archive</h2>
  </div>
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
