<%@include file="pageheader.jsp" %>

<div class="container">
  <div class="page-header">
    <h2>${blogPost.title} <small class="hidden-xs">${blogPost.formattedDate}</small></h2>
  </div>
  <p>
    ${blogPost.contentHtml}
  </p>
</div>

<%@include file="pagefooter.jsp" %>
