package business;

import forms.AdminSearchForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Michael
 * @since Jun 17, 2014
 */
public class AdminSearch {
    private ArrayList<AdminSearchForm> searchResults;
    private HttpServletRequest request;
    private AdminSearchForm searchForm;

    public AdminSearch(HttpServletRequest request, AdminSearchForm searchForm) {
        this.request = request;
        this.searchForm = searchForm;
    }
 
    public ArrayList listAll(HttpServletRequest request, AdminSearchForm searchForm){
    searchResults = new ArrayList();
    
    
        return searchResults;
    }
    
    public ArrayList searchById(){
    searchResults = new ArrayList();
        return searchResults;
    }
    
     public ArrayList searchByUsername(){
    searchResults = new ArrayList();
        return searchResults;
    }
     
      public ArrayList searchByLastName(){
    searchResults = new ArrayList();
        return searchResults;
    }
    
}
