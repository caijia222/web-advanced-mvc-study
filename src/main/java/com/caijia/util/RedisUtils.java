package com.caijia.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class RedisUtils {

	public static void main(String[] args) {
		Jedis jedis = new Jedis();
		System.out.println(jedis.ping());
		jedis.set("name", "caijia222");
		jedis.set("sex", "M", SetParams.setParams().nx().ex(100l));
		System.out.println(jedis.get("name"));
		System.out.println(jedis.get("sex"));
		jedis.close();
	}
}
