package com.config

import org.openqa.selenium.WebDriver

interface DriverService {
    fun createWebDriver(): WebDriver
}