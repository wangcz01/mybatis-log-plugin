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
------------------------------------------------------------------------------------------------------------------------
--  2  MyBatis Log Test: INFO sql2 -  ==>
 update t_table set name = 'world'
 WHERE id = 123;
------------------------------------------------------------------------------------------------------------------------
--  3  MyBatis Log Test: WARN sql3 -  ==>
 delete
 FROM t_table
 WHERE id = 123;
------------------------------------------------------------------------------------------------------------------------
--  4  MyBatis Log Test: ERROR sql4 - ==>
 select *
 FROM t_table order by id asc;
```

## Manual
https://github.com/kookob/mybatis-log-plugin/wiki/Plugin-Manual

## Download
[mybatis-log-plugin.jar](https://plugins.jetbrains.com/plugin/10065-mybatis-log-plugin "Download Plugin")<br/>

