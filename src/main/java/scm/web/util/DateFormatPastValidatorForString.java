package scm.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@ManagedBean
@SessionScoped
@FacesValidator("dateFormatPastValidatorForString")
public class DateFormatPastValidatorForString implements Validator{
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {

		//String dateAndTime = (String) value;
		
		FacesMessage message = new FacesMessage("DateTime is not valid (dd-MM-yyyy)");
//		
//		FacesMessage message = new FacesMessage();
//		message.setSeverity(FacesMessage.SEVERITY_ERROR);
//		message.setSummary("DateTime is not valid (dd-MM-yyyy)");
//		message.setDetail("DateTime is not valid (dd-MM-yyyy)");
//		context.addMessage("DateTime", message);
		
		if ( value == null ) {
			throw new ValidatorException(message);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient( false );
		try {
			//Date date1 = sdf.parse(dateAndTime);
			Date date1 = (Date)value;
			
			Date date2 = new Date();
			if(date1.after(date2) || date1.equals(date2)){
//				message = new FacesMessage("Please select past date");
				message = new FacesMessage();
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("Please select past date");
				message.setDetail("Please select past date");
				context.addMessage("form_1:s_input", message);
				throw new ValidatorException(message);
            }
        } 
        catch (Exception e) {
        	throw new ValidatorException(message);
        }
		
	}
}