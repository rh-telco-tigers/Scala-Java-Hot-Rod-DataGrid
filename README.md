## sbt project compiled with Scala 3

### Usage

This is a normal sbt project. You can compile code with `sbt compile`, run it with `sbt run`, and `sbt console` will start a Scala 3 REPL.

For more information on the sbt-dotty plugin, see the
[scala3-example-project](https://github.com/scala/scala3-example-project/blob/main/README.md).


This article shows the client code config to access a DataGrid cluster using Scala. Scala uses Java Hot Rod client provided Out of the box as part of DataGrid product.

- Setup sbt (Scala Build Tool). Here are the instructions : https://docs.scala-lang.org/getting-started/sbt-track/getting-started-with-scala-and-sbt-on-the-command-line.html

- Add Java Hot Rod client POM Maven dependencies in [build.sbt](build.sbt)

libraryDependencies += "org.infinispan" % "infinispan-commons" % "14.0.6.Final",
libraryDependencies += "org.infinispan" % "infinispan-client-hotrod" % "14.0.6.Final"   

- Open the .scala file in project created as per steps in above link to add client code

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

- Open promt at project level and exec "sbt run".

- Open your Cache in DataGrid console and you should see cache entries in the list.

