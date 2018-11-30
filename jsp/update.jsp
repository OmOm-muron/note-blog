<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <jsp:include page="/jsp/header.jsp"/>
        <title>オムラの備忘録：投稿完了</title>
    </head>
  
    <body>
        <header>
            <jsp:include page="/jsp/nav.jsp"/>
        </header>

        <main role="main">

            <div class="container">
                <h1 class="jumbotron-heading">私の備忘に酔いしれなさい！！</h1>
                <p class="lead text-muted">オムラの備忘録と銘打っているがただの開発演習である</p>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-8">
                        <div class="row">
                            <div class="col-6">
                                <strong>記事の更新が完了しました！</strong>
                            </div>
                            <div class="col-6">
                                <div class="btn-group d-flex justify-content-end" role="group">
                                    <form id="read" action="read" method="GET">
                                        <input type="hidden" id="id" name="id" value="${dto.id}"/>
                                        <input type="submit" class="btn btn-secondary" value="Back"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="text-center">
                            <p>記事の更新が正常に完了しました。</p>
                            <div class="btn-group d-flex justify-content-center" role="group">
                                <form id="read" action="read" method="GET">
                                    <input type="hidden" id="id" name="id" value="${dto.id}"/>
                                    <input type="submit" class="btn btn-secondary" value="Back"/>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card mb-4 shadow-sm">
                            <div class="card-body">
                                <p class="card-text">カレンダーをここに表示したい</p>
                            </div>
                        </div>
                        <div class="text-left">
                            <c:forEach items="${latestArticleList}" var="article">
                                    <li><a href="read?id=<c:out value="${article.id}"/>"><c:out value="${article.title}"/>(<c:out value="${article.uploadDate}"/>)</a></li>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <footer class="text-muted">
            <div class="container">
                <p class="float-right">
                    <a href="#">画面一番上へ</a>
                </p>
            </div>
        </footer>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
