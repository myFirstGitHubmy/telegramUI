package com.container

import com.base.Helper
import com.config.Driver
import lombok.Data
import lombok.Getter
import lombok.Setter
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait

@Getter
@Setter
class DriverContainer {
    val driver: WebDriver = Driver.createWebDriverUsedProfile()
    val wait: WebDriverWait = WebDriverWait(driver, 10)
    val helper: Helper = Helper(driver, wait)

    constructor()
}