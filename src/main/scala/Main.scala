import org.infinispan.client.hotrod.RemoteCacheManager
import org.infinispan.commons.api.BasicCache
import org.infinispan.commons.api.BasicCacheContainer

@main def hello() = 
            println("Hello, World!")
            val cb = new org.infinispan.client.hotrod.configuration.ConfigurationBuilder();
            cb.tcpNoDelay(true)
                .connectionPool()
                .security().authentication().username("admin").password("changeme")
                .addServer()
                .host("192.168.86.28")
                .port(11222)
            val cacheContainer = new RemoteCacheManager(cb.build())
            val cache : BasicCache[String,String] = cacheContainer.getCache("default")
            cache.put("car1", "ferrari1")
            println(cb);    
