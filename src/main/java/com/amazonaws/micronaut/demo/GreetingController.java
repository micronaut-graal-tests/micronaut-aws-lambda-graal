/*
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.micronaut.demo;

import com.amazonaws.micronaut.demo.model.Pet;
import com.amazonaws.micronaut.demo.model.PetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Nullable;
import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

@RestController
public class GreetingController {

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public String greet(@RequestParam("name") String name) {
        return "Hello, " + name + "!";
    }

}
