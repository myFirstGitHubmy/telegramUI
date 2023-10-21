package com.config

import com.utils.DefaultUtils
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class Driver {
    companion object {
        fun createWebDriverUsedProfile(): WebDriver {
            System.setProperty("webdriver.chrome.driver", DefaultUtils.pathChromeDriver)
            return ChromeDriver(createOptions())
        }

        fun createWebDriver(): WebDriver {
            System.setProperty("webdriver.chrome.driver", DefaultUtils.pathChromeDriver)
            return ChromeDriver()
        }

        fun createOptions(): ChromeOptions {
            val chromeOptions = ChromeOptions()
            chromeOptions.addArguments("--user-data-dir=${DefaultUtils.profileCacheBrowser}")
            chromeOptions.addArguments("--enable-offline-page-caching")
            return chromeOptions
        }
    }
}