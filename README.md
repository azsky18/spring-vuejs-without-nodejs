# Spring + Vuejs Without Webpack  


### 개요
Node.js나 Webpack등 javascript Server 도구 없이 Spring으로 수행되는 Vuejs 프로젝트입니다.

### 의존성
다음 프로젝트에 의존적입니다.
주요 프로젝트만 서술 했습니다.

* [Gradle](https://docs.gradle.org)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Vue.js](https://vuejs.org/)
* [http-vue-loader](https://github.com/FranckFreiburger/http-vue-loader)

### Features
* Server-Side Template Engine을 사용하지 않고 vue를 이용한 Client-Side Rendering을 수행합니다.  
vue 코드는 .js를 이용하지 않고 .vue를 이용합니다.
    
     
* Page에 접근하는 URL은 File Path에 따라 자동으로 할당됩니다.  
이는 Nuxt의 Routing Rule을 따릅니다. ([Nuxt Routing Rule](https://ko.nuxtjs.org/guide/routing))
    
    
* Vue-Router를 이용한 Layout을 적용했습니다. 프로젝트는 /static/components/main-layout.vue를 최상위 Layout으로 사용합니다.  
/users/{id} URL로 접근하면 그 상태에서 다시 Sub Layout을 사용하는 예제를 확인할 수 있습니다.


* Spring Pageable 과 호환되는 간단한 Pagination Component.

### 피드백
azsky18@gmail.com

