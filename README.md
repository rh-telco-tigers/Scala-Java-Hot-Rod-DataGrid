
### This article shows the client code config to access a DataGrid cluster using Scala. Scala uses Java Hot Rod client provided as part of DataGrid product.

- Setup sbt (Scala Build Tool). [Instructions](https://docs.scala-lang.org/getting-started/sbt-track/getting-started-with-scala-and-sbt-on-the-command-line.html)

- Create Scala Project. [Instructions](https://docs.scala-lang.org/getting-started/sbt-track/getting-started-with-scala-and-sbt-on-the-command-line.html)

- Add Java Hot Rod client POM Maven dependencies in [build.sbt](build.sbt)
```
libraryDependencies += "org.infinispan" % "infinispan-commons" % "14.0.6.Final",
libraryDependencies += "org.infinispan" % "infinispan-client-hotrod" % "14.0.6.Final"   
```

- Open the .scala file in project created to add client code
```
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
```
- Open promt at project level and exec "sbt run".

- Open your Cache in DataGrid console and you should see cache entries in the list. [img]()

