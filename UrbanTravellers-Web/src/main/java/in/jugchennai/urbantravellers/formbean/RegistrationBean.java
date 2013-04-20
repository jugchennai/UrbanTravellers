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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 * Registration form bean and controller method for registration.xhtml page.
 *
 * @author Rajmahendra Hegde <rajmahendra@gmail.com>
 */

@ManagedBean(name="regBean")
public class RegistrationBean {
    
    private UserService service;
    private UtUsers utusers;
    
    private Logger logger;
    
    private String fullName;
    private String userName;
    private String password;
    private String reenterPassword;
    private String displayName;
    private long updateValue=0;

    public RegistrationBean() {
         logger = Logger.getLogger(RegistrationBean.class);
    }
    
    
    public RegistrationBean(String fullName, String userName, String password, String displayName) {
        logger = Logger.getLogger(RegistrationBean.class);
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.displayName = displayName;
        utusers=new UtUsers();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    
    public String whenRegisteration() {
        
        //If Successfull, return success message.
        //if(service.validateUserName(userName)){}
        service=new UserService();
        utusers=new UtUsers();
        utusers.setUserid(updateValue);
        utusers.setUsername(userName);
        utusers.setPassword(password);
        utusers.setLastlogin(new java.util.GregorianCalendar().getTime());
        /*if(service.validateUserName(userName))
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username Already Exists. Please use another username.", null));
            return "failure";
        }*/
            if(service.addUser(this.utusers)){
                addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "User Registration Successful!!!", null));
                return "success";
            }

            //If Unsuccessful, return failure message
            addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, "User Registration Failed!!!", null));
            return "failure";
    }

    public String getReenterPassword() {
        return reenterPassword;
    }

    public void setReenterPassword(String reenterPassword) {
        this.reenterPassword = reenterPassword;
    }
    
    private void addMessage(FacesMessage message){
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
