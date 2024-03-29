package com.ideas.persistence;

import java.io.Serializable;

/**
 * Extend the GenericDAO interface and mark String as its generic type to be persisted
 *
 * http://www.tikalk.com/java/mongodb-spring-and-rest-–-trio-jee-dynamic-data-access
 */
@Deprecated
public interface DynamicModelDAO extends GenericDAO<String, Serializable>{
    /**
     * Get the next free unique ID.
     *
     * @return The next free unique ID.
     */
    public String getNextId ();
}
