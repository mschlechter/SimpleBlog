<%@include file="pageheader.jsp" %>

<div class="container">
  <div class="page-header">
    <h2>Edit: ${blogPost.title} <small class="hidden-xs">${blogPost.formattedDate}</small></h2>
  </div>

  <form>


    <textarea>
      ${blogPost.content}
    </textarea>


  </form>

</div>

<%@include file="pagefooter.jsp" %>
