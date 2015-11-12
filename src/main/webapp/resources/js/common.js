$j(function() {
    
//   alert("Hello! I am an alert box!!");
//    $j( "div > p" ).css( "border", "1px solid gray" );

	$j('#form_1\\:s_input').addClass("form-control");

    //check validation for userName
    var message = $j('#form_1\\:userNameMessage');
    
    if(message.hasClass('error-class')){
        //do this
    //	alert("Error!");
//    	message.parent().parent().css( "background-color", "red" );
    	message.parent().parent().addClass( "has-error" );
    }
    else{

    	//do this
    	//alert("OK!");
    }
    
    //check validation for password
    var message = $j('#form_1\\:passwordMessage');
 
    if(message.hasClass('error-class')){
        //do this
    //	alert("Error!");
//    	message.parent().parent().css( "background-color", "red" );
    	message.parent().parent().addClass( "has-error" );
    }
    else{

    	//do this
    	//alert("OK!");
    }
    
  //check validation for firstName
    var message = $j('#form_1\\:firstNameMessage');
 
    if(message.hasClass('error-class')){
        //do this
    //	alert("Error!");
//    	message.parent().parent().css( "background-color", "red" );
    	message.parent().parent().addClass( "has-error" );
    }
    else{

    	//do this
    	//alert("OK!");
    }
    
  //check validation for lastName
    var message = $j('#form_1\\:lastNameMessage');
 
    if(message.hasClass('error-class')){
        //do this
    //	alert("Error!");
//    	message.parent().parent().css( "background-color", "red" );
    	message.parent().parent().addClass( "has-error" );
    }
    else{

    	//do this
    	//alert("OK!");
    }
    
  //check validation for email
    var message = $j('#form_1\\:emailMessage');
 
    if(message.hasClass('error-class')){
        //do this
    //	alert("Error!");
//    	message.parent().parent().css( "background-color", "red" );
    	message.parent().parent().addClass( "has-error" );
    }
    else{

    	//do this
    	//alert("OK!");
    }
    
  //check validation for dateOfBirth
    var message = $j('#form_1\\:dateOfBirthMessage');
 
    if(message.hasClass('error-class')){
        //do this
    //	alert("Error!");
//    	message.parent().parent().css( "background-color", "red" );
    	message.parent().parent().addClass( "has-error" );
    }
    else{

    	//do this
    	//alert("OK!");
    }
    
    //check validation for confirmPassword
    var message = $j('#form_1\\:confirmPasswordMessage');
 
    if(message.hasClass('error-class')){
        //do this
    //	alert("Error!");
//    	message.parent().parent().css( "background-color", "red" );
    	message.parent().parent().addClass( "has-error" );
    }
    else{

    	//do this
    	//alert("OK!");
    }
    
//    $j('.datepicker').datepicker({
//    	dateFormat: 'dd-mm-yy',
//        startDate: '-3d'
//    })
    
    
    
});