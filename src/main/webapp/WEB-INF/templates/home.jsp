<%@include file="pageheader.jsp" %>

<c:choose>
    <c:when test="${not empty blogPosts}">

        <c:forEach var="blogPost" items="${blogPosts}">
            <div class="container">
                <div class="page-header">
                    <h2>${blogPost.title} <small class="hidden-xs">${blogPost.formattedDate}</small></h2>
                </div>
                <p>
                    ${blogPost.summary}
                </p>
                <p>
                    <a href="post/${blogPost.id}">
                        <button type="button" class="btn btn-default">Read more</button>
                    </a>
                </p>
            </div>
        </c:forEach>

    </c:when>
    <c:otherwise>

        <div class="container">
            This blog is empty.
        </div>


    </c:otherwise>
</c:choose>

<%@include file="pagefooter.jsp" %>
