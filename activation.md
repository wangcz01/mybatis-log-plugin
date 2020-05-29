# 激活失败问题处理
## 关于激活失败
**声明：插件特殊版本针对的是社区版，教育版，破解版，正版，以及各种环境激活失败的情况。**  
因为JB家IDE的部分版本对收费插件的支持还在完善中，以及对破解版本的限制，导致仓库安装的插件可能无法直接激活。  
为了兼容这部分的IDE用户，这里提供特殊版本进行授权验证。  
特殊版本，安全机制很薄弱，希望各位破解大佬，手下留情。  
**在这里，还是恳请下用户，对于自己的激活信息，请不要共享或传播出去。**  

## 激活步骤
1. 下载特殊版本(如果下载失败，需要科学上网)  
[mybatis-log-special.jar](https://raw.githubusercontent.com/kookob/mybatis-log-plugin/master/dist/mybatis-log-special.jar)  

2. 卸载原先版本重新安装特殊版本(**直接把jar包拖放到IDE编辑窗口**或参照下图)
![](https://raw.githubusercontent.com/kookob/mybatis-log-plugin/master/snapshot/install.png)

3. IDE启动后，点击插件左边的`Rerun`按钮，弹出授权验证窗口。  
![](https://raw.githubusercontent.com/kookob/mybatis-log-plugin/master/snapshot/activate.png)  

4. 输入对应订单信息  
* **Email**: 购买插件时填写的邮箱地址;
* **Order ref**: 购买成功后JetBrains往你邮箱里面发送的订单号码，或在[官网账号](https://account.jetbrains.com/licenses)那边获取(**R开头+7位数字**)，示例：`R36*****`;
* **Activication code**: 插件的激活码。  
![](https://raw.githubusercontent.com/kookob/mybatis-log-plugin/master/snapshot/orderref.png)  
![](https://raw.githubusercontent.com/kookob/mybatis-log-plugin/master/snapshot/activicationcode.png)  
![](https://raw.githubusercontent.com/kookob/mybatis-log-plugin/master/snapshot/license.png)  

输入完成后点击`Activate`按钮，验证授权信息，成功或失败都会弹出对应提示。  
如果验证成功，再次点次左边的`Rerun`按钮，即可正常使用插件。

## 感谢理解
**安装特殊版本的用户请勿直接升级仓库的新版本！**  
特殊版本在功能更新和bug修复上面可能会存在一定的延迟，请大家理解。  
如果遇到JetBrains政策与本版本相冲突的，以JetBrains政策为准。  
最后，非常感谢大家的理解和支持！