### 完成度：
__Details:__
- \- StudentController.java:37 返回的数据结构中缺少组名，或者是放在前端做的？
- \- StudentController.java:31 缺少查看分组的api

### 测试：
* 进行了简单的controller测试

### 知识点：
* 了解下Lombok
* 了解下三层架构
* 了解下Spring Ioc Container
* 了解下restful最佳实践

__Details:__
- \- StudentController.java:17 推荐构造器注入
- \- StudentController.java:23 如果不是有自定义返回的需求，ResponseEntity一般可省略
- \- StudentController.java:34 资源名应该是复数形式
- \- StudentController.java:38 POST请求的状态码应该是201
- \- StudentController.java:39 POST的返回结果，应该是成功创建的对象或是id
- \- StudentController.java:40 了解下@ResponseStatus
- \- Students.java:27 数据相关的操作，不应该是domain的职责

### 工程实践：
__Details:__

- \- StudentController.java:21 方法名应该驼峰形式
- \- StudentController.java:28 对group资源的操作，应该放在单独的controller中进行

### 综合：
__Details:__
- \- 由于将数据初始化放到了Students中，导致这里的调用很奇怪。可以思考下，如果职责单一一些，是否会更好一些。
- \- Students.java:7 这个类看起来做了group事情，但是确叫students，不是很表意

