<%@include file="pageheader.jsp" %>

<div class="container">
  <div class="page-header">
    <h2>${blogPost.title} <small class="hidden-xs">${blogPost.formattedDate}</small></h2>
  </div>
  <p>
    ${blogPost.contentHtml}
  </p>

  <sec:authorize access="hasRole('ROLE_ADMIN')">

  <p>
    <a href="edit/${blogPost.id}">
      <button type="button" class="btn btn-default">Edit content</button>
    </a>
  </p>

  </sec:authorize>

</div>

<%@include file="pagefooter.jsp" %>
