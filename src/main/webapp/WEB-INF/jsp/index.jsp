<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <meta charset="utf-8">
    <title>Quiz MundoJ</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet">
    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="http://twitter.github.com/bootstrap/assets/js/google-code-prettify/prettify.css">
    <link rel="stylesheet" href="<c:url value="/resources/css/custom.css" />">

    <!--
    IMPORTANT:
    This is Heroku specific styling. Remove to customize.
    -->
    <link href="http://heroku.github.com/template-app-bootstrap/heroku.css" rel="stylesheet">
    <style type="text/css">
      .instructions { display: none; }
      .instructions li { margin-bottom: 10px; }
      .instructions h2 { margin: 18px 0;}
      .instructions blockquote { margin-top: 10px; }
      .screenshot {
        margin-top: 10px;
        display:block;
      }
      .screenshot a {
        padding: 0;
        line-height: 1;
        display: inline-block;
        text-decoration: none;
      }
      .screenshot img, .tool-choice img {
        border: 1px solid #ddd;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        border-radius: 4px;
        -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075);
        -moz-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075);
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075);
      }
    </style>
    <!-- /// -->
    <script type="text/javascript">
      <!--
      function appname() {
          return location.hostname.substring(0,location.hostname.indexOf("."));
      }
      // -->
    </script>
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

    <div class="container" id="getting-started">
      <div class="row" align="center" style="margin-top: 20px;">
        <div>
        	<c:if  test="${!empty param.message}">
        		<h1>${param.message}</h1><br />
        	</c:if>
        	<a href="perguntas/"><button class="btn-custom sample btn custom large">Iniciar Quiz MundoJ</button></a>
        </div>
      </div>
    </div>
    <c:if test="${! empty appId}">
    	<script>
    	  var oauth_url = 'https://www.facebook.com/dialog/oauth/';
    	  oauth_url += '?client_id=<c:out value="${appId}"/>';
    	  oauth_url += '&redirect_uri=' + encodeURIComponent('<c:out value="${appUrl}"/>');
    	  oauth_url += '&scope=publish_stream';

    	  window.top.location = oauth_url;
		</script>
    </c:if>
    
    <script src="http://twitter.github.com/bootstrap/assets/js/jquery.js"></script>
    <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-modal.js"></script>
    <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-tab.js"></script>
  </body>
</html>
