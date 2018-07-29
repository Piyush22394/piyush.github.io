function validate12()
    {
    	var letters = /^[a-zA-Z]+$/; 
    	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/; 
    	    	
    	 
    	if(!document.enquiryform.firstname.value.match(letters)){
    		
    		alert("Please Enter First Name(Letters Only).....");
            document.enqform.Firstname.focus();
            document.enqform.Firstname.value=="";
            return false;
    	}
    	 else if(!document.enquiryform.lastname.value.match(letters))
         {
           alert("Please Enter Last Name(Letters Only).......");
           document.enqform.Lastname.focus();
           document.enqform.Lastname.value=="";
           return false;
         }
    	
    	     	
    	 else if(!document.enquiryform.Email.value.match(mailformat))
         {
           alert("Please Enter Email.......");
           document.enqform.email.focus();
           document.enqform.email.value=="";
           return false;
         }
    	
    	 else if(!document.enquiryform.messege.value.match(letters))
         {
           alert("Please Enter Messege.......");
           document.enqform.messege.focus();
           document.enqform.messege.value=="";
           return false;
         }
    }