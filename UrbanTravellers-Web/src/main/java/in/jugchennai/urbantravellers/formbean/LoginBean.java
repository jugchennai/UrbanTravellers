/*
 * Copyright 2013 JUGChennai.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package in.jugchennai.urbantravellers.formbean;

import in.jugchennai.urbantravellers.jpa.entitie.UtUsers;
import in.jugchennai.urbantravellers.jpa.service.UserService;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;

/**
 * Login form bean and controller method for login.xhtml page.
 *
 * @author Rajmahendra Hegde <rajmahendra@gmail.com>
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    
    Logger logger;
    
    private boolean logged=false;
    private Date lastLogin;
 
    @NotNull (message = "UserName must not be null")
    @Size(min=4, max=16, message = "Username must be atleast 4 characters and max of 16")
    private String userName;
    
    @NotNull(message = "Password must not be null")
    @Size(min=4, max=16, message = "Password must be atleast 4 characters and max of 16")
    private String password;

    public LoginBean(String userName, String password) {
       logger = Logger.getLogger(LoginBean.class);
        this.userName = userName;
        this.password = password;
        this.logged=false;
    }

    public LoginBean() {
        logger = Logger.getLogger(LoginBean.class);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setLogged(boolean value)
    {
        logged=true;
    }
    
    public boolean getLogged()
    {
        return logged;
    }
    
    public void setDate(Date date)
    {
        this.lastLogin=date;
    }
    
    public Date getDate()
    {
        return lastLogin;
    }
    
    public String whenLogin () {
  
        UserService service=new UserService();
        Collection<UtUsers> findByUsername = service.findByUsername(userName);
        Iterator itr=findByUsername.iterator();
        while(itr.hasNext())
        {
            UtUsers next = (UtUsers)itr.next();
            if(next.getPassword().equals(password))
            {
                setDate(next.getLastlogin());
                setLogged(true);
                addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Login Successful!!!", null));
                return "success";
            }
        }
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Incorrect Username/Password.", null));
        return "failure";
    }
    
    private void addMessage(FacesMessage message){
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void userLogged()
    {
        if(!logged)
        {
            doRedirect("login.xhtml");
        }
    }
    
    public void verifyUseLogin(){
        if(logged){
             doRedirect("member.xhtml");
        }
    }
    private void doRedirect(String url){
        try {
            FacesContext context=FacesContext.getCurrentInstance();
            context.getExternalContext().redirect(url);
        } catch (Exception e) {
        }
    } 
    
}
