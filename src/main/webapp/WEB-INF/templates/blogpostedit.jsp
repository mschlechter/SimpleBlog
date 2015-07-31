<%@include file="pageheader.jsp" %>

<div class="container">
  <div class="page-header">
    <h2>Edit: ${blogPost.title}</h2>
  </div>

  <spring:url value="/post/save" var="saveActionUrl" />

  <form:form modelAttribute="blogPost" action="${saveActionUrl}" method="post">

    <form:input path="id" type="hidden" id="id" />

    <div class="form-group">
      <label for="title">Title:</label>
      <form:input path="title" type="text" class="form-control" id="title" placeholder="Title" />
    </div>

    <div class="form-group">
      <label for="summary">Summary:</label>
      <form:textarea path="summary" type="text" class="form-control" id="summary" placeholder="Summary" rows="5" />
    </div>

    <div class="form-group">
      <label for="content">Content:</label>
      <form:textarea path="content" type="text" class="form-control" id="content" placeholder="Title" rows="20" />
    </div>

    <button type="submit" class="btn btn-default">Save</button>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

  </form:form>

</div>

<%@include file="pagefooter.jsp" %>
