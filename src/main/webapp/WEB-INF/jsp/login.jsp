<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=StyleSheet href="resources/css/login.css" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script src="resources/js/login.js"></script>
<title>Login</title>
</head>
<body>
  <div id="mensagem">
    Mensagens
  </div>
  <form id="form_login" action="logar" method="post">  
  <div id="caixa-login">
    <div id="caixa-login-interna">
      <div id="caixa-login-label">Login</div>
      <div class="input-div" id="input-usuario">
        <input type="text" value="Email" id="usuario" name="email">
      </div>
      <div class="input-div" id="input-senha">
        <input type="password" value="Senha" id="senha" name="senha">
      </div>
      <div id="botoes">
	   
	        	<div id="botao" >
		           Login
		        </div>
	      
      <div id="lembrar-senha">
          <input type="checkbox" /> Lembrar minha senha</div>
      </div>
    </div>
  </div>
  </form>
</body>
</html>