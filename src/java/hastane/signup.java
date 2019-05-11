package hastane;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author hasangenc
 */
@ManagedBean(name = "signup", eager = true)
@RequestScoped
public class signup {
    
    public String error = null;

    public User user = new User();

    public String title = "Üye Ol";
    
    public boolean submit() {
        if (DAL.User.saveUser(user)) {
            this.setError(null);
            return true;
        }
        
        this.setError(user.getEmail() + " mail hesabı ile kayıtlı üye mevcut.");
        
        return false;
    }

    public User getUser() {
        return this.user;
    }
    
    public String getError() {
        return this.error;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setError(String error) {
        this.error = error;
    }

}
