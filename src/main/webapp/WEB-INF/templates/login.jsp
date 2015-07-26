<%@include file="pageheader.jsp" %>

<div class="container">

  <div class="page-header">
    <h2>Sign in</h2>
  </div>

  <c:if test="${not empty error}">
    <div class="alert alert-warning" role="alert">${error}</div>
  </c:if>
  <c:if test="${not empty msg}">
    <div class="alert alert-info" role="alert">${msg}</div>
  </c:if>

  <form name='loginForm'
        action="<c:url value='/login' />" method='POST'>

    <div class="form-group">
      <label for="username">User:</label>
      <input type="text" name="username" id="username" placeholder="username" class="form-control" />
    </div>

    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" name="password" id="password" placeholder="password" class="form-control" />
    </div>

<input name="submit" type="submit"
                               value="Login" class="btn btn-default" />

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

  </form>
</div>

<%@include file="pagefooter.jsp" %>
