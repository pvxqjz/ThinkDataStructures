package com.allendowney.thinkdast;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import redis.clients.jedis.Jedis;


public class WikiCrawler {
	// keeps track of where we started
	@SuppressWarnings("unused")
	private final String source;

	// the index where the results go
	private JedisIndex index;

	// queue of URLs to be indexed
	private Queue<String> queue = new LinkedList<String>();

	// fetcher used to get pages from Wikipedia
	final static WikiFetcher wf = new WikiFetcher();

	/**
	 * Constructor.
	 *
	 * @param source
	 * @param index
	 */
	public WikiCrawler(String source, JedisIndex index) {
		this.source = source;
		this.index = index;
		queue.offer(source);
	}

	/**
	 * Returns the number of URLs in the queue.
	 *
	 * @return
	 */
	public int queueSize() {
		return queue.size();
	}

	/**
	 * Gets a URL from the queue and indexes it.
	 * @param testing
	 *
	 * @return URL of page indexed.
	 * @throws IOException
	 */
	public String crawl(boolean testing) throws IOException {
		// TODO: FILL THIS IN!
        return null;
	}

	public static void main(String[] args) throws IOException {
		// make a WikiCrawler
		Jedis jedis = JedisMaker.make();
		JedisIndex index = new JedisIndex(jedis);
		String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		WikiCrawler wc = new WikiCrawler(source, index);
	}
}
