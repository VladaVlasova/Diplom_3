package ru.praktikum.burger.api;

import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;

public class TestFields {
    public static Response response;
    public String email = RandomStringUtils.randomAlphabetic(10) + "@vlada.ru";
    public String password = RandomStringUtils.randomAlphabetic(10);
    public String invalidPassword = RandomStringUtils.randomAlphabetic(5);
    public String name = RandomStringUtils.randomAlphabetic(10);
    public static String accessTokenAfterRegister;
}
