# CEvent
分布式事件管理

#描述：
使用观察者模式,注册各类事件，把常用的spring组件，job组件，apollo组件，以及部署的所有事件。
集中注册在一个管理器中,开发者可以在事件触发的时候回调自己的方法。

#问题：
来自我在公司开发配置导出的时候，做的组件是需要每次服务器发布的时候触发一次文件更新。
如果使用spring启动的时候的钩子函数去触发一次这个更新，方式集群的多个服务会触发多次，不合理。
最后使用了xxljob轮询去访问文件是否有更新，然后就做更新操作。前期这样做是浪费性能的，但是后面迭代
的功能肯定是需要实时更新的，这样也无可厚非。但是我想在自己需要这个事件的时候，而没有
所以想自己思考一下实现一下类似js中事件机制，可以指定某些事件然后回调方法。

#遐想：
1.我觉得文件缓存很适合做分布式的操作，集群中的服务通过文本文件去交流彼此的缓存配置。 整个过程都是全异步的。