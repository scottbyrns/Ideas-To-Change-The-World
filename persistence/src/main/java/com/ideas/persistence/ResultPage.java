package com.ideas.persistence;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * ResultPage DTO which holds both the results and count of total results
 *
 * http://www.tikalk.com/java/mongodb-spring-and-rest-–-trio-jee-dynamic-data-access
 */
@XmlRootElement
public class ResultPage<T> {

	private List<T> results = new LinkedList<T>();

	private long count;

	public ResultPage() {
	}

	public ResultPage(List<T> results, long count) {
		this.results = results;
		this.count = count;
	}

	@XmlElement
	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	@XmlElement
	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ResultPage [results=" + results + ", count=" + count + "]";
	}
}