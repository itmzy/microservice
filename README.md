# 微服务 Template

这是一个**微服务模板项目**，不使用数据库，提供了易于学习和扩展的基础架构，适合快速掌握微服务技术。通过该项目，开发者可以轻松上手，并根据业务需求进行进一步扩展和自定义。

> 作者：[mazeyuan](https://github.com/itmzy)

## 优势与特点：

1. **模块化设计**：该项目的微服务结构清晰，包含**Gateway Server**、**User Service**、**Order Service**三个服务，便于扩展。
2. **快速入门**：项目中并未引入数据库，简化了配置，可快速部署和测试各类微服务相关的功能。
3. **技术集成**：集成了热门的微服务技术栈，如Spring Cloud Gateway、Nacos、OpenFeign、Hystrix等，便于开发者快速了解这些技术的使用。
4. **可扩展性强**：项目框架灵活，开发者可以根据业务需求轻松集成其他模块或服务，如数据库、缓存、消息队列等。
5. **容错机制**：使用了Hystrix进行熔断处理，保证系统的容错性和健壮性。
6. **响应式架构**：Gateway Server使用Spring WebFlux，实现响应式编程，提升了系统的并发处理能力。
7. **服务注册与发现**：基于Spring Cloud Alibaba与Nacos实现服务注册与发现，保证服务之间的负载均衡和高可用性。

此项目适合希望在短时间内快速学习微服务相关技术的开发者，同时也适合团队在此基础上构建更复杂的微服务架构。

## 使用的技术

1. **Spring Cloud Gateway** - 作为API网关，用于将请求路由到不同的微服务。
2. **Spring Cloud Nacos** - 用于服务注册和发现，Nacos 作为配置中心和服务治理平台。
3. **Spring Cloud Alibaba** - 与 Nacos 集成，实现服务注册、配置管理以及负载均衡等功能。
4. **OpenFeign** - 作为声明式的HTTP客户端，用于服务之间的通信。
5. **Hystrix** - 作为熔断器，提供容错能力。
6. **WebFlux (Reactive)** - 网关服务使用 WebFlux 作为响应式 Web 应用类型。

## 项目结构

```
microservice/
├── gateway-server/       # API 网关服务
├── order-service/        # 订单服务
├── user-service/         # 用户服务
└── pom.xml               # 父项目配置文件
```

### 各服务的功能：

- **gateway-server**：充当API网关，负责路由到各个微服务，如 `user-service` 和 `order-service`。
- **order-service**：提供订单管理的相关API。
- **user-service**：提供用户管理的相关API。

## 前置条件

在运行此项目之前，请确保已完成以下步骤：

### 1. 安装 Nacos

Nacos 用于服务发现和注册。安装 Nacos（**必须安装2.2.0版本**）

[github下载地址](https://github.com/alibaba/nacos/releases/tag/2.2.0) 

通过 [Nacos 官方文档](https://nacos.io) 获取详细的安装步骤。

## 启动项目

1. **启动 Nacos**： 启动 Nacos 服务器，确保它运行在 `localhost:8848` 上。

2. **启动各个微服务**： 通过命令行分别进入 `gateway-server`, `order-service`, `user-service` 目录

    确保各服务成功注册到 Nacos 中。

## 特点

- **Spring Cloud Alibaba 集成**：使用 Spring Cloud Alibaba 实现 Nacos 服务发现、配置管理以及服务间通信。
- **服务发现与注册**：使用 Nacos 实现微服务的自动注册和发现。
- **负载均衡**：通过 Spring Cloud Gateway 实现基于 Nacos 的负载均衡。
- **熔断器**：通过 Feign 集成 Hystrix 实现服务的容错机制。
- **响应式编程**：网关服务使用 Spring WebFlux 实现高效的响应式应用。

## 测试服务

确保所有服务都已成功启动，并且已在 Nacos 上注册。您可以通过以下方式测试服务：

1. **获取用户信息**

    访问 `http://localhost:8080/user/1`
    您应该会看到类似以下的响应：

    ```json
    
    {
        "id": "1",
        "name": "User_1",
        "email": "user1@example.com"
    }
    ```

2. **获取订单信息并包含用户信息**

    访问 `http://localhost:8080/order/1`
    您应该会看到类似以下的响应：

    ```json
    
    {
        "orderId": "1",
        "product": "Product_1",
        "price": 101,
        "userInfo": {
            "id": "1",
            "name": "User_1",
            "email": "user1@example.com"
        }
    }
    ```

