/*
 * Copyright 2012 JUGChennai.
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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;


/**
 *
 * @author rajmahendra
 */
@ManagedBean
@RequestScoped
public class LoginBean {
    
    Logger log;
    
    
    @NotNull (message = "UserName must not be null")
    @Size(min=4, max=16, message = "Username must be atleast 4 characters and max of 16")
    private String userName;
    
    @NotNull(message = "Password must not be null")
    @Size(min=4, max=16, message = "Password must be atleast 4 characters and max of 16")
    private String password;

    public LoginBean(String userName, String password) {
        this.log = Logger.getLogger(LoginBean.class.getName());
        this.userName = userName;
        this.password = password;
    }

    public LoginBean() {
        this.log = Logger.getLogger(LoginBean.class);
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
    
      public String whenLogin () {

        return "";
    }
    
}
