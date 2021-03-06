/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openjpa.persistence.delimited.identifiers.xml;

import java.util.Collection;
import java.util.HashSet;

public class EntityI {
    private int id;
    private String name;
    private Collection<EntityH> eHs = new HashSet<>();

    public EntityI() {}

    public EntityI(int id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the entityHs
     */
    public Collection<EntityH> getEntityHs() {
        return eHs;
    }

    /**
     * @param entityHs the entityHs to set
     */
    public void setEntityHs(Collection<EntityH> entityHs) {
        this.eHs = entityHs;
    }

    public void addEntityH(EntityH entityH) {
        eHs.add(entityH);
    }
}
