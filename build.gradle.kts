import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	dependencies {
		classpath("com.google.cloud.tools:jib-spring-boot-extension-gradle:0.1.0")
	}
}

plugins {
	id("org.siouan.frontend-jdk17") version "10.0.0" apply false
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("jvm") version "2.2.0"
	kotlin("plugin.spring") version "2.2.0"

	id("org.owasp.dependencycheck") version "12.1.0"
	id("com.gorylenko.gradle-git-properties") version "2.5.2"
	id("com.google.cloud.tools.jib") version "3.4.5"
}

group = "cz.maio"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("com.h2database:h2")


	implementation("net.sf.j8583:j8583:2.0.0")
	implementation("org.jobrunr:jobrunr-spring-boot-3-starter:8.0.1")
	implementation("org.apache.poi:poi:5.3.0")
	implementation("org.apache.poi:poi-ooxml:5.4.1")
	implementation("com.jcraft:jsch:0.1.55")
	implementation("org.bouncycastle:bcpg-jdk15to18:1.81")
	implementation("org.apache.commons:commons-compress:1.27.1")
	implementation("com.github.ua-parser:uap-java:1.6.1")
	implementation("net.gcardone.junidecode:junidecode:0.5.2")
	implementation("org.tomitribe:tomitribe-http-signatures:1.8")
	implementation("io.github.resilience4j:resilience4j-spring-boot3:2.3.0")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
	implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable-jvm:0.3.8")
	implementation("org.postgresql:postgresql:42.7.4")
	implementation("org.apache.commons:commons-csv:1.14.1")
	implementation("info.faljse:SDNotify:1.5")
	implementation("net.javacrumbs.shedlock:shedlock-spring:6.9.2")
	implementation("net.javacrumbs.shedlock:shedlock-provider-jdbc-template:6.9.2")
	implementation("org.ehcache:ehcache:3.10.8")

	implementation("org.webjars.npm:jquery:3.7.1")
	implementation("org.webjars.npm:d3:7.9.0")
	implementation("org.webjars.npm:bootstrap:5.3.3")
	implementation("org.webjars.npm:htmx.org:2.0.3")
	implementation("org.webjars.npm:shoelace-style__shoelace:2.20.1")
	implementation("org.webjars.npm:hyperscript.org:0.9.14")

	implementation("com.eventstore:db-client-java:5.4.3")

	testImplementation("com.github.writethemfirst:approvals-java:0.12.0")
	testImplementation("com.approvaltests:approvaltests:25.0.23")
	testImplementation("io.cucumber:cucumber-java:7.20.1")
	testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
	testImplementation("net.jadler:jadler-core:1.3.1")
	testImplementation("net.jadler:jadler-jdk:1.3.1")
	testImplementation("net.javacrumbs.json-unit:json-unit:4.1.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("com.microsoft.playwright:playwright:1.54.0")
	testImplementation("org.jsoup:jsoup:1.19.1")
	testImplementation("com.github.stefanbirkner:fake-sftp-server-rule:2.0.1")
	testImplementation("org.testcontainers:junit-jupiter:1.20.6")
	testImplementation("net.jqwik:jqwik:1.9.3")
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}


tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}
