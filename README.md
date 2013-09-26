FOA - OpenAAA
==========================

FOA是利用成都东软学院[OpenAAA API](http://aaa.nsu.edu.cn/OpenAAA.htm) 实现的开源的AAA客户端。FOA是JavaFX OpenAAA的缩写，它是用JavaFX技术实现的，正因如此，它也是跨平台的。


长期以来，官方AAA客户端只提供了Windows版本，FOA的跨平台性为使用非Windows操作系统的用户提供了相应的服务，填补了官方AAA客户端的空缺。

下载
--------------------------

### 下载源码

适用于开发者

FOA将代码托管在GitHub中，如果您的设备中安装有git,您可以在终端中输入以下命令就可以将整个项目下载到您的设备中
```bash
git clone git://github.com/fengyouchao/FOA.git
```
当然，如果您注册有GitHub帐号，您可以直接fork，将本项目添加到自己的仓库中

### 下载可运行的jar包

适用于普通用户

- [金山网盘](http://www.kuaipan.cn/file/id_55243948125325975.htm)
- [SkyDrive](http://sdrv.ms/191ZsKE)

运行:
```bash
java -jar foa*.jar
```

FOA的运行环境
--------------------------

所有安装有JDK1.7.0_21或更高版本的操作系统。

使用FOA前须知
--------------------------

### FOA的缺点

FOA是非官方的网络客户端，它是利用成都东软学院[OpenAAA API](http://aaa.nsu.edu.cn/OpenAAA.htm) 实现的。FOA的相关功能是依赖于[OpenAAA API](http://aaa.nsu.edu.cn/OpenAAA.htm)，
所以FOA不能保证其能够提供永久的服务。FOA的功能相对于官方客户端受到了一些限制。具体如下:

1. FOA登录需要输入验证码，参看[OpenAAA API](http://aaa.nsu.edu.cn/OpenAAA.htm)中的Function Login(...)方法。
2. FOA登录后后，需要每隔15分钟内再输入一次验证码以维持登陆状态，参看[OpenAAA API](http://aaa.nsu.edu.cn/OpenAAA.htm)中的Function KeepSession(...)方法。
3. 由上述两点，及[OpenAAA API](http://aaa.nsu.edu.cn/OpenAAA.htm)的其他潜在的未知问题，FOA的登录验证存在不稳定性

关于输入验证码的问题，并非FOA开发者的用意，这是由于[OpenAAA API](http://aaa.nsu.edu.cn/OpenAAA.htm)本身限制的。在FOA开发者看来[OpenAAA API](http://aaa.nsu.edu.cn/OpenAAA.htm)
对用户来说是不友好的。但是这是目前唯一的官方API。


### FOA的优势

1. FOA不仅仅是跨平台的，受益于JavaFX技术，FOA可以以三种不同方式运行，它们分别是传统的jar包运行，WebStart运行，在浏览器中运行。
2. 通过路由器连接网络也可以使用FOA登录验证。
3. 某些情况下可以共享网络。
4. 不会出现共享网络惩罚的情况。
5. 没有广告。

FOA并没有设计任何检测用户是否共享网络的相关代码，并且FOA的开发者一贯坚决反对这种不道德的行为。但是通过FOA开发者的测试发现，
为[OpenAAA API](http://aaa.nsu.edu.cn/OpenAAA.htm)提供服务的服务器端似乎仍通过某种技术手段检测用户是否共享网络，
因为在共享网络时，FOA常常收到来自服务器端的```无效会话```。

常见错误信息及解决办法
--------------------------

### 无效会话

1. 通过FOA登录后，在维护会话期间需要输入验证码时，长时间未操作。通过重新登录可以解决。
2. 可能由于服务器检测出用户共享网络，而被服务器拒绝服务。通过重新登录可以解决。

### 其他问题

1. 尝试重新启动FOA。

关于FOA项目
--------------------------

FOA使用maven构建，其中某些依赖在maven中央仓库中找不到，例如JavaFX的fxrt.jar，对于这种依赖，可以通过搭建maven私服解决。


反馈信息
--------------------------

如果您在使用中遇到任何问题或者您有什么好的建议，请发送邮件到fengyouchao@gmail.com

