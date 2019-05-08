package hastane;

import javax.faces.context.ExternalContext;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author hasangenc
 */

@ManagedBean(name = "signup", eager = true)
@SessionScoped
public class signup {

  public User user = new User();

  public String title = "Üye Ol";

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
    DAL.User.saveUser(user);

    return true;
  }

}
