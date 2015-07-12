<nav class="navbar navbar-default">
  <div class="container">

    <ul class="nav navbar-nav">
      <li><a href="<c:url value="/" />">Home</a></li>
      <li><a href="<c:url value="/about" />">About</a></li>
    </ul>

    <ul class="nav navbar-nav navbar-right">
      <li><a href="<c:url value="/signin" />">Sign in</a></li>
    </ul>

    <!-- <p class="navbar-text navbar-right">Signed in as Mark Otto</p> -->

  </div>
</nav>

<div class="jumbotron">
  <div class="container">
    <h1>${blogConfig.blogTitle}</h1>
    <p class="hidden-xs">
      ${blogConfig.blogSubTitle}
    </p>
  </div>
</div>