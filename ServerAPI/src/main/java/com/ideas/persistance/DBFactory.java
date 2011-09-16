package com.ideas.persistance;

import com.mongodb.DB;
import com.mongodb.Mongo;
import org.springframework.beans.factory.FactoryBean;

/**
 *
 * http://jbaruch.wordpress.com/2010/05/30/integrating-mongodb-with-spring/
 */
public class DBFactory implements FactoryBean<DB> {

    private Mongo mongo;
    private String name;

    @Override
    public DB getObject() throws Exception {
        return mongo.getDB(name);
    }

    @Override
    public Class<?> getObjectType() {
        return DB.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setMongo(Mongo mongo) {
        this.mongo = mongo;
    }

    public void setName(String name) {
        this.name = name;
    }
}
