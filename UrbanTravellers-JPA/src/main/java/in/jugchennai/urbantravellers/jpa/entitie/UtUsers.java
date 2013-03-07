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
package in.jugchennai.urbantravellers.jpa.entitie;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rajmahendra Hegde
 */
@Entity
@Table(name = "UT_USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UtUsers.findAll", query = "SELECT u FROM UtUsers u"),
    @NamedQuery(name = "UtUsers.findByUserid", query = "SELECT u FROM UtUsers u WHERE u.userid = :userid"),
    @NamedQuery(name = "UtUsers.findByUsername", query = "SELECT u FROM UtUsers u WHERE u.username = :username"),
    @NamedQuery(name = "UtUsers.findByPassword", query = "SELECT u FROM UtUsers u WHERE u.password = :password"),
    @NamedQuery(name = "UtUsers.findByUserNameAndPassword", query = "SELECT u FROM UtUsers u WHERE u.username = :username AND u.password = :password"),
    @NamedQuery(name = "UtUsers.findByLastlogin", query = "SELECT u FROM UtUsers u WHERE u.lastlogin = :lastlogin")})
public class UtUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userid;
    private String username;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlogin;

    public UtUsers() {
    }

    public UtUsers(Long userid) {
        this.userid = userid;
    }

    public UtUsers(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UtUsers)) {
            return false;
        }
        UtUsers other = (UtUsers) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UtUsers { userid :" + userid + " username : " + username + " password : " + password + "}";
    }
}
