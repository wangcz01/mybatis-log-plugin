# 激活失败问题处理
## 关于激活失败
因为JetBrains公司对破解版本的限制，导致仓库下载的插件版本无法直接激活。  
为了兼容破解版的IDE用户，思考再三，决定发布本地授权验证的特殊版本。  
这个决定，存在一定的风险的，因为线上正常渠道的版本，JB公司会把所有相关的销售，激活，证书，验证通通搞定，定时触发验证，防破解机制做的非常好。    
目前发布的特殊版本，只是做了一些简单的授权验证，希望各位破解大佬，高抬贵手。  
**在这里，还是恳请下用户，对于自己的激活信息，请不要共享或传播出去。**  

## 激活步骤
1. 下载(如果下载失败，需要科学上网)  
[mybatis-log-special.jar](https://raw.githubusercontent.com/kookob/mybatis-log-plugin/master/dist/mybatis-log-special.jar)  

2. 安装(直接把jar包拖放到IDE窗口 或 参照下图)
![](https://raw.githubusercontent.com/kookob/mybatis-log-plugin/master/snapshot/install.png)

3. IDE启动后，点击插件左边的`Rerun`按钮，弹出授权验证窗口。  
![](https://raw.githubusercontent.com/kookob/mybatis-log-plugin/master/snapshot/activate.png)  

4. 输入对应订单信息  
* **Email**: 购买插件时填写的邮箱地址;
* **Order ref**: 购买成功后JetBrains往你邮箱里面发送的订单号码，在账号登录那边也可以查到，示例：`R1234567`;
* **Activication code**: 插件的激活码。  
![](https://raw.githubusercontent.com/kookob/mybatis-log-plugin/master/snapshot/license.png)  

输入完成后点击`Activate`按钮，验证授权信息，成功或失败都会弹出对应提示。  
如果验证成功，再次点次左边的`Rerun`按钮，即可正常使用插件。

## 感谢理解
特殊版本在功能更新和bug修复上面可能会存在一定的延迟，请大家理解。  
如果遇到JetBrains政策与本版本相冲突的，以JetBrains政策为准。  
最后，非常感谢大家的理解和支持！