$(
  function(){
    
    $('#usuario').click(
      function(){
        if($(this).val() == 'Email'){
        $(this).val('');
        }
      }
    );
    
    $('#senha').click(
      function(){
        if($(this).val() == 'Senha'){
        $(this).val('');
        }
      }
    );
    
    $('#botao').click(
      function(){
        $('#mensagem').slideUp('fast');
        if($('#usuario').val() == '' || $('#usuario').val()=='Email' || $('#senha').val() == '' || $('#senha').val()=='Senha'){
          $('#mensagem').html('Login ou Senha Inválido').slideDown('fast');
        }else{
        	$('#form_login').submit();
        }
      }
    );
    
    $('#mensagem').click(
      function(){
        $(this).slideUp();
      }
    );
    
  }
);