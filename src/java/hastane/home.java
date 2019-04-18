package hastane;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author hasangenc
 */
@ManagedBean(name = "home", eager = true)
public class home {
    
    String title = "Diş Hastanesi";
    
    public home () {
    }
    
    public String getTitle() {
        return this.title;
    }
    
}
