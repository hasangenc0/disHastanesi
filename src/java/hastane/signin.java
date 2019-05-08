package hastane;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hasangenc
 */
@ManagedBean(name = "signin", eager = true)
@SessionScoped
public class signin {

    public User user = new User();

    public String title = "Giriş Yap";

    public User getUser() {
        return this.user;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean submit() {
        this.user = DAL.User.getUser(user);
        
        System.out.println(this.user.getFirstname());
        
        if(user == null) {
            
        }

        return true;
    }

}
