package hastane;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hasangenc
 */
@ManagedBean(name = "home", eager = true)
@RequestScoped
public class home {

    String title = "Diş Hastanesi";

    public home () {
    }

    public String getTitle() {
        return this.title;
    }
    
    public void onload() { 
        HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        
        // Dont save admin panel visits
        boolean isFound = url.indexOf("adminpanel") !=-1? true: false;
        
        if (isFound) {
            return;
        }
        
        DAL.Visits.visited(url);
    }

}
