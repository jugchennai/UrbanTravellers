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
package in.jugchennai.urbantravellers.test;

import in.jugchennai.urbantravellers.jpa.entitie.UtUsers;
import in.jugchennai.urbantravellers.jpa.service.UserService;
import java.util.Date;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author rajmahendrahegde
 */
public class UserServiceTest {

    UserService userService;

    public UserServiceTest() {
    }

    @Before
    public void setUp() {
        userService = new UserService();
    }

    @After
    public void tearDown() {
        userService = null;
    }
    
    @Ignore
    @Test
    public void addNewUserSuccess() {
        UtUsers newUser = new UtUsers();

        newUser.setUsername("rajmahendra");
        newUser.setPassword("rajmahendra");
        newUser.setLastlogin(new Date());
        userService.addUser(newUser);
        assertTrue(newUser.getUserid().intValue() > 0);
    }
    
    public void validateLogin () {
      
    }
    
    
}
