# seata-demo
seata事务模式demo


## 项目运行步骤

###  1.运行script目录下的business.sql建立数据库和表

具体分别会建立三个数据库(seata_order、seata_storage、seata_account)，六张表(order、storage、account、3个undo_log)

###  2.修改application.yml中相应nacos、mysql等配置为自己的环境配置

seata的事务分组名我配置的是seata_tx_group

### 3.启动seata_order、seata_storage、seata_account三个微服务

### 4.访问接口测试seata是否正常运行

demo流程： order->storage->account  ，即创建订单，扣减库存，扣减余额。扣减余额这一步我做了失败回滚模拟，也就是说正常结果是扣减余额失败导致订单和库存都回滚。

order调用storage时，storage有同一逻辑两种接口的实现(其一使用spring的@RequestMapping实现接口映射，其二使用jboss的RestEasy实现接口映射)，实测发现访问RestEasy映射的接口时seata会失效，不会生成undolog，也不会向服务端注册分支事务，总之就是没有任何反应。而采用@RequestMapping的接口是可以正常实现seata分布式事务的。

####  ①使用spring的@RequestMapping的demo入口

接口：http://127.0.0.1:2001/order/create

参数：{"userId":1,"commodityCode":"10001","count":1, "money":1}

运行这个接口的时候需要注释掉storage服务的pom.xml中的RestEasy依赖和JbossController代码。



#### ②使用jboss的RestEasy的demo入口

接口：http://127.0.0.1:2001/order/create/jboss

参数:      {"userId":1,"commodityCode":"10001","count":1, "money":1}
