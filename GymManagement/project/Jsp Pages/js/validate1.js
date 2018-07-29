
   
       function trim(s) 
       {
           return s.replace( /^s*/, "" ).replace( /s*$/, "" );
       }
    function validate11()
    {
    	var letters = /^[a-zA-Z]+$/; 
    	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/; 
    	var mob = /^\d{10}$/;
    	
    	 var ht = /^\d{3}$/;
    	 var wt = /^\d{2,3}$/;
    	 
    	if(!document.registerform.Firstname.value.match(letters)){
    		
    		alert("Please Enter First Name(Letters Only).....");
            document.registerform.Firstname.focus();
            document.registerform.Firstname.value=="";
            return false;
    	}
    	 else if(!document.registerform.Lastname.value.match(letters))
         {
           alert("Please Enter Last Name(Letters Only).......");
           document.registerform.Lastname.focus();
           document.registerform.Lastname.value=="";
           return false;
         }
    	
    	 else if(!document.registerform.mobile.value.match(mob))
         {
           alert("Please Enter Contact Number.......");
           document.registerform.mobile.focus();
           document.registerform.mobile.value=="";
           return false;
         }
    	
    	 else if(!document.registerform.email.value.match(mailformat))
         {
           alert("Please Enter Email.......");
           document.registerform.email.focus();
           document.registerform.email.value=="";
           return false;
         }
    	
    	 else if(!document.registerform.height.value.match(ht))
         {
           alert("Please Enter Height.......");
           document.registerform.height.focus();
           document.registerform.height.value=="";
           return false;
         }
    	 else if(!document.registerform.weight.value.match(wt))
         {
           alert("Please Enter Weight.......");
           document.registerform.weight.focus();
           document.registerform.weight.value=="";
           return false;
         }
    	 
    	  
    }
    
