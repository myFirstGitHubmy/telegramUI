package com.base

import com.utils.ButtonUtils
import com.utils.DefaultUtils
import lombok.Getter
import lombok.Setter
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.lang.Exception

@Getter
@Setter
class Helper {
    private val wait: WebDriverWait
    private val driver : WebDriver

    constructor(driver: WebDriver, waitDriverWait: WebDriverWait) {
        this.driver = driver
        this.wait = waitDriverWait
    }
    fun findAndClick(selector: By): WebElement {
        val element = find(selector)
        element.click()
        return element
    }

    fun waitElementAndClick(by: By, sec: Long) {
        var webElement: WebElement? = null
        var time: Long = 0
        while (time <= sec) {
            try {
                if (webElement == null) {
                    webElement = find(by)
                }
                if (webElement.isDisplayed) {
                    webElement.click()
                    break
                }

            } catch (e: Exception) {
                println("Element: $by not found")
            }
            waitSec(time)
            time++
        }
    }

    fun waitFiftyFiftyElementAndClick(by1: By, by2: By, sec: Long) {
        var webElement: WebElement? = null
        var time: Long = 0
        while (time <= sec) {
            try {
                if (webElement == null) {
                    webElement = find(by1)
                }
                if (webElement.isDisplayed) {
                    webElement.click()
                    break
                }

            } catch (e: Exception) {
                println("Element: $by1 not found")
                if (visibleElementMill(by2, 500)) {
                    return
                }
            }
            waitSec(time)
            time++
        }
    }

    fun visibleElement(by: By, sec: Long): Boolean {
        var time: Long = 0
        while (time <= sec) {
            try {
                find(by)
                return true
            } catch (e: Exception) {
                waitSec(time)
                time++
            }
        }
        return false
    }

    fun visibleElementMill(by: By, mill: Long): Boolean {
        var time: Long = 0
        while (time <= mill) {
            try {
                find(by)
                return true
            } catch (e: Exception) {
                waitMill(time)
                time+=100
            }
        }
        return false
    }

    fun sendKeys(webElement: WebElement, text: String) {
        webElement.sendKeys(text)
    }

    fun getTextInput(webElement: WebElement): String {
        return webElement.text
    }

    fun waitElementAndClick(webElement: WebElement, sec: Long) {
        var time: Long = 0
        while (time <= sec) {
            if (webElement.isDisplayed) {
                webElement.click()
                break
            }
            waitSec(time)
            time++
        }
    }

    fun find(selector: By): WebElement {
        return driver.findElement(selector)
    }

    fun waitMill(i: Long) {
        Thread.sleep(i)
    }

    fun waitSec(i: Long) {
        Thread.sleep(i * 1000)
    }

    fun toUrl(url: String) {
        driver.get(url)
    }

    fun quit() {
        driver.quit()
    }

}