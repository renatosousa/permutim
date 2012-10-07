<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC and Hibernate Template</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet">
    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!--
      IMPORTANT:
      This is Heroku specific styling. Remove to customize.
    -->
    <link href="http://heroku.github.com/template-app-bootstrap/heroku.css" rel="stylesheet">
    <!-- /// -->

</head>

<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a href="/" class="brand">Quiz MundoJ</a>
            <a href="/" class="brand" id="heroku">by <strong>heroku</strong></a>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <div class="page-header">
                <h1>Quiz MundoJ</h1>
            </div>
            <form method="post" action="responder">
                <c:if  test="${!empty perguntas}">
	                <h3>Perguntas</h3>
	                <c:forEach items="${perguntas}" var="pergunta" varStatus="status">
	                	<p>
	                		${pergunta.enunciado}<br />
                			<c:forEach items="${pergunta.respostas}" var="resposta">
		                		<input type="radio" name="pergunta_${status.index}" value="${resposta}" /> ${resposta}<br />
                			</c:forEach>
	                	</p>
                    </c:forEach>
	            </c:if>
            
                <input type="submit" value="Enviar Respostas" class="btn"/>
            </form>
        </div>
    </div>
</div>

</body>
</html>
