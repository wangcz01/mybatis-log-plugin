![mybatis-log-plugin](https://img.shields.io/jetbrains/plugin/v/10065-mybatis-log-plugin?label=version&style=flat-square)
[![mybatis-log-plugin](https://img.shields.io/jetbrains/plugin/d/10065-mybatis-log-plugin?style=flat-square)](https://plugins.jetbrains.com/plugin/10065-mybatis-log-plugin/versions)

# MyBatis Log Plugin
## Introduction
- Restore mybatis sql log to original whole sql.
- It will generate executable sql statements with replace ? to the really param value.
- Selected the "Filter" button to filter contents that don't wanna display.
- Selected the "Format Sql" button to format the generate sql statements.
- Select the console sql log and right-click "Restore Sql" menu to restore sql.

## Button Features
- Sql Text: Restore sql from text
- Filter: Filter setting
- Format Sql: Output beautiful formatted sql statements
- Rerun: Rerun this plugin
- Stop: Stop filter the sql log

## Example
```sql
MyBatis Log Test: DEBUG sql1 -  ==>  Preparing: select * from t_table where name = ?
MyBatis Log Test: DEBUG sql1 -  ==> Parameters: hello(String)
MyBatis Log Test: INFO sql2 -  ==>  Preparing: update t_table set name = ? where id = ?
MyBatis Log Test: INFO sql2 -  ==> Parameters: world(String), 123(Integer)
MyBatis Log Test: WARN sql3 -  ==>  Preparing: delete from t_table where id = ?
MyBatis Log Test: WARN sql3 -  ==> Parameters: 123(Integer)
```
MyBatis Log Plugin output executable sql statements:
```sql
--  1  MyBatis Log Test: DEBUG sql1 -  ==>
 select *
 FROM t_table
 WHERE name = 'hello';
------------------------------------------------------------
--  2  MyBatis Log Test: INFO sql2 -  ==>
 update t_table set name = 'world'
 WHERE id = 123;
------------------------------------------------------------
--  3  MyBatis Log Test: WARN sql3 -  ==>
 delete
 FROM t_table
 WHERE id = 123;
------------------------------------------------------------
--  4  MyBatis Log Test: ERROR sql4 - ==>
 select *
 FROM t_table order by id asc;
```

## Manual
https://github.com/kookob/mybatis-log-plugin/wiki/Plugin-Manual

## Download
[mybatis-log-plugin.jar](https://plugins.jetbrains.com/plugin/13905-mybatis-log-plugin "Download Plugin")  

## 关于插件
因为插件之前实现的机制并不好，导致经常出现一些版本兼容、注册失败以及性能的问题。  
所以此插件旧版本(2.*)后续不再维护，将来有可能会被移除。  
如果该插件旧版本在你机器上运行良好，并且你选择继续使用旧版本，也是完全可以的。  
另外我花了一些精力用更好的方式重新实现了一个插件，在性能、样式、体验上面都做了优化。  
新插件运行起来会比较舒服，而且更加稳定，应该不会有什么问题。  
然后看到官方marketplace启动不久，把新插件发布上去体验下流程并试下效果。  
所以新插件是收费状态，目前暂时给它设定了一个最低的价格($1/year)。  
如果你愿意体验并支持新的插件，请访问地址：  
[mybatis-log-plugin](https://plugins.jetbrains.com/plugin/13905-mybatis-log-plugin)  
后续可能会开发一些新的插件，希望各位能够理解并支持。  
谢谢！