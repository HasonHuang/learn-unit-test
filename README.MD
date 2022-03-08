# 单元测试示例

## 一、介绍

示例以整洁架构分层，对每层进行单元测试或集成测试。

- `start` 程序入口。
- `ohs` 北向网关（从基础设施层里提取出来），展示资源接口的单元测试用例。
- `app` 应用层，展示用户用例的单元测试用例。
- `domain` 领域层，展示核心业务的单元测试用例。
- `infrastructure` 基础设施层，主要是南向网关，展示 Repository 的集成测试用例。

## 二、运行程序

下载代码后，在根目录 `pom.xml` 执行命令：

```shell
mvn clean verify
```

## 三、查看测试报告

在每一个分层的 `tartget/` 目录可以查看报告：

- 覆盖率报告：`target/site/jacoco/index.html`
- 单元测试报告：`target/surefire-reports/`
- 集成测试报告： `target/failsafe-reports/`