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
@EnableWebMvc
public class PetsController {

    private PetData petData;

    @Autowired
    public PetsController(PetData data) {
        petData = data;
    }

    @RequestMapping(path = "/pets", method = RequestMethod.POST)
    public Pet createPet(@RequestBody Pet newPet) {
        if (newPet.getName() == null || newPet.getBreed() == null) {
            return null;
        }

        Pet dbPet = newPet;
        dbPet.setId(UUID.randomUUID().toString());
        return dbPet;
    }

    @RequestMapping(path = "/pets", method = RequestMethod.GET)
    public Pet[] listPets(@RequestParam("limit") Optional<Integer> limit, @Nullable Principal principal) {
        int queryLimit = 10;
        if (limit.isPresent()) {
            queryLimit = limit.get();
        }

        Pet[] outputPets = new Pet[queryLimit];

        for (int i = 0; i < queryLimit; i++) {
            Pet newPet = new Pet();
            newPet.setId(UUID.randomUUID().toString());
            newPet.setName(petData.getRandomName());
            newPet.setBreed(petData.getRandomBreed());
            newPet.setDateOfBirth(petData.getRandomDoB());
            outputPets[i] = newPet;
        }

        return outputPets;
    }

    @RequestMapping(path = "/pets/{petId}", method = RequestMethod.GET)
    public Pet getPet(@RequestParam("petId") String petId) {
        Pet newPet = new Pet();
        newPet.setId(UUID.randomUUID().toString());
        newPet.setBreed(petData.getRandomBreed());
        newPet.setDateOfBirth(petData.getRandomDoB());
        newPet.setName(petData.getRandomName());
        return newPet;
    }

}
