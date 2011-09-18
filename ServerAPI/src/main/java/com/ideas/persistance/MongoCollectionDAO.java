package com.ideas.persistance;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/**
 * http://www.tikalk.com/java/mongodb-spring-and-rest-–-trio-jee-dynamic-data-access
 */
@Deprecated
public class MongoCollectionDAO implements DynamicModelDAO
{
    private DB db;
    private String collectionName;
    private DBCollection dbCollection;

    public String getCollectionName()
    {
        return collectionName;
    }

    public void setDb(DB db)
    {
        this.db = db;
    }

    public void setCollectionName(String collectionName)
    {
        this.collectionName = collectionName;
    }

    @PostConstruct
    public void init()
    {
        dbCollection = db.getCollection(collectionName);
    }

    public void create(String entity)
    {
        DBObject dbObject = getDbObject(entity);
        dbCollection.insert(dbObject);
    }

    private DBObject getDbObject(String entity)
    {
        DBObject dbObject = (DBObject) JSON.parse(entity);
        return dbObject;
    }

    public void create(String entity, Serializable id)
    {
        DBObject dbObject = getDbObject(entity);
        dbObject.put("_id", id);
        dbCollection.insert(dbObject);
    }

    public void update(String entity)
    {
        DBObject dbObject = getDbObject(entity);
        dbCollection.save(dbObject);
    }

    public String findById(Serializable id)
    {
        DBObject dbObject = dbCollection.findOne(id);
        return JSON.serialize(dbObject);
    }

    public void delete(String entity)
    {
        DBObject dbObject = getDbObject(entity);
        dbCollection.remove(dbObject);
    }

    public ResultPage findByFilter(String q, String orders, int pageNumber, int pageSize)
    {
        List<String> results = new LinkedList<String>();
        long count;
        DBCursor cursor;
        if (q == null)
        {
            count = dbCollection.getCount();
            cursor = dbCollection.find();
        }
        else
        {
            DBObject queryDBObject = getDbObject(q);
            count = dbCollection.getCount(queryDBObject);
            cursor = dbCollection.find(queryDBObject);
        }
        if (orders != null)
        {
            cursor.sort(getDbObject(orders));
        }
        cursor.skip(pageSize * (pageNumber - 1));
        cursor.limit(pageSize);
        while (cursor.hasNext())
            results.add(cursor.next().toString());
        return new ResultPage(results, count);
    }


    /**
     * Get the next free unique ID.
     *
     * @return The next free unique ID.
     */
    public String getNextId()
    {
        return "null";
    }
}