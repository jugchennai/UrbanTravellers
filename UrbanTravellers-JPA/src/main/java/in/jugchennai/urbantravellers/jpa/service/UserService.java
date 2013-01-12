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
package in.jugchennai.urbantravellers.jpa.service;

import in.jugchennai.urbantravellers.jpa.entitie.UtUsers;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rajmahendrahegde
 */
public class UserService {

    private EntityManagerFactory emFactory;
    private EntityManager eManager;

    public UserService() {
        emFactory = Persistence.createEntityManagerFactory("urbanTravellersPU");
        eManager = emFactory.createEntityManager();
    }

    public Collection<UtUsers> findAll() {
        return (Collection<UtUsers>) eManager.createNamedQuery("UtUsers.findAll")
                .getResultList();
    }

    public Collection<UtUsers> findByUsername(String username) {
        return (Collection<UtUsers>) eManager.createNamedQuery("UtUsers.findByUsername")
                .setParameter("username", username)
                .getResultList();
    }

    public Collection<UtUsers> findByPassword(String password) {
        return (Collection<UtUsers>) eManager.createNamedQuery("UtUsers.findByPassword")
                .setParameter("password", password)
                .getResultList();
    }

    public Long addUser(UtUsers newUser) {
        eManager.getTransaction().begin();
        eManager.persist(newUser);
        eManager.getTransaction().commit();
        return newUser.getUserid();
    }

    public void validateUser(String username, String password) {
        
        Collection<UtUsers> list = findByUsername(username);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        eManager.close();
        emFactory.close();
    }
}
