<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

                    <div class="col-4">
                        <div class="card mb-4 shadow-sm">
                            <div class="card-body">
                                <p class="card-text">Calendar will be displayed here.</p>
                            </div>
                        </div>
                        <div class="text-center">
                            <li>
                                <c:forEach items="${latestArticleList}" var="article">
                                    <ul><a href="read?id=<c:out value="${article.id}"/>"><c:out value="${article.title}"/>(<c:out value="${article.uploadDate}"/>)</a></ul>
                                </c:forEach>
                            </li>
                        </div>
                    </div>