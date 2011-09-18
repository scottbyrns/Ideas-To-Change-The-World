package com.ideas.persistance;

import java.io.Serializable;

/**
 * GenericDAO interface to persist and fetch the data of the application with JPA and MongoDB implementations.
 *
 * http://www.tikalk.com/java/mongodb-spring-and-rest-–-trio-jee-dynamic-data-access
 */
@Deprecated
public interface GenericDAO  <T, ID extends Serializable> {
	public void create(T entity);
	public void create(T entity,ID id);

	public T findById(ID id);
	public void update(T entity);
	public void delete(T entity);

    /**
     * enables the client to filter results by a query string, defines the order , page number and size.
     * It return a page of the results using the ResultPage.
     *
     * @param q
     * @param orders
     * @param pageNumber
     * @param pageSize
     * @return
     */
	public ResultPage<T> findByFilter(String q,String orders, int pageNumber,int pageSize);

}