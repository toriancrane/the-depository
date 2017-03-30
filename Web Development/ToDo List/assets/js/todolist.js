$(document).ready(function(){
  var todoItem;
  $('#addTask').click(function(){
    todoItem = $('#todoItem').val()
  $('<li class="list-group-item"><input type="checkbox"> '+todoItem+'<br></li>').prependTo('#todoList');
   $('#todoItem').val('');
	});
  //when enter is clicked run addTask function
  $("#todoItem").keypress(function(e){
      if(e.which == 13){
        $("#addTask").click();
      }
    });
      $('#todoList').on('click','input',function() {
        $(this).fadeOut(300, function(){  
          $(this).parent().remove();
       });
        
    });
});

  
  	
               