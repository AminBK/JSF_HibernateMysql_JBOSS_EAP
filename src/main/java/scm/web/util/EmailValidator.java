package scm.web.util;

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
@FacesValidator("emailValidator")
public class EmailValidator implements Validator{
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		String email = (String) value;
		
		if(!email.contains("@")) {
			//FacesMessage message = new FacesMessage("Email is not valid");
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Email is not valid.");
			message.setDetail("Email is not valid.");
			//context.addMessage("userForm:Email", message);
			context.addMessage(null, message);
			throw new ValidatorException(message);
		}
	}
}