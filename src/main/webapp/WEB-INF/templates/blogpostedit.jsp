<%@include file="pageheader.jsp" %>

<div class="container">
  <div class="page-header">
    <h2>Edit: ${blogPost.title} <small class="hidden-xs">${blogPost.formattedDate}</small></h2>
  </div>

  <form action="<c:url value='/post/edit/' />${blogPost.id}" method="post">

    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Title" value="${blogPost.title}">
    </div>

    <div class="form-group">
      <label for="content">Content:</label>
      <textarea type="text" class="form-control" id="content" placeholder="Title" rows="20">
        ${blogPost.content}
      </textarea>
    </div>

    <button type="submit" class="btn btn-default">Save</button>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

  </form>

</div>

<%@include file="pagefooter.jsp" %>
