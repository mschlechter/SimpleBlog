<%@include file="pageheader.jsp" %>

<sec:authorize access="hasRole('ROLE_ADMIN')">

    <div class="container">
        <a href="post/edit/-1">
            <button type="button" class="btn btn-default">New post</button>
        </a>
    </div>

</sec:authorize>

<c:choose>
    <c:when test="${not empty blogPosts}">

        <c:forEach var="blogPost" items="${blogPosts}">
            <div class="container">
                <div class="page-header">
                    <h2>${blogPost.title} <small class="hidden-xs">${blogPost.formattedDate}</small></h2>
                </div>
                <p>
                    ${blogPost.summaryHtml}
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
