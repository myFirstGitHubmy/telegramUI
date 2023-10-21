package com.service.impl

import com.base.FileUpload
import com.base.Helper
import com.config.Driver
import com.container.DriverContainer
import com.service.ProcessPageService
import com.utils.ButtonUtils
import com.utils.DefaultUtils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProcessPageServiceImpl : ProcessPageService {
    private var driver: WebDriver? = null
    private var waitDriver: WebDriverWait? = null
    private var helper: Helper? = null
    private var profile: String = ""

    constructor() {
        init()
    }

    override fun init() {
        val driverContainer = DriverContainer()
        this.driver = driverContainer.driver
        this.waitDriver = driverContainer.wait
        this.helper = driverContainer.helper
    }

    override fun addMembersToGroup() {
        println("Start: " + Date())
        val members = FileUpload.getMembersFromFile("C:\\Users\\evbor\\OneDrive\\Рабочий стол\\members.txt")
        helper!!.toUrl(DefaultUtils.urlGroup)
        helper!!.waitSec(2)
        helper!!.waitElementAndClick(By.cssSelector(ButtonUtils.CssSelector.titleChat), 3)
        helper!!.waitElementAndClick(By.cssSelector(ButtonUtils.CssSelector.addMemberBtn), 3)
        for (item in members) {
            if (item == "") {
                continue
            }
            addMemberToGroup(item)
        }

        helper!!.waitElementAndClick(By.cssSelector(ButtonUtils.CssSelector.addedMembersBtn), 2)
        helper!!.waitSec(1)
        helper!!.waitElementAndClick(By.xpath(ButtonUtils.Xpath.addButton), 2)
        println("End: " + Date())
//        helper.quit()
    }

    private fun addMemberToGroup(userName: String) {
        val searchMemberInput = helper!!.find(By.cssSelector(ButtonUtils.CssSelector.containerSearchInput))
        helper!!.waitElementAndClick(searchMemberInput, 3)
        searchMemberInput.clear()
        helper!!.sendKeys(searchMemberInput, userName)
        helper!!.waitMill(500)
        if (helper!!.visibleElement(By.cssSelector(ButtonUtils.CssSelector.listMemberEmpty), 1)) {
            return
        } else {
            helper!!.waitFiftyFiftyElementAndClick(By.cssSelector(ButtonUtils.CssSelector.firstMemberContainer),
                By.cssSelector(ButtonUtils.CssSelector.listMemberEmpty), 5)
        }
    }

    override fun getChromePathLocalVersion() {
        if (driver == null || waitDriver == null || helper == null) {
            return
        }
        helper!!.waitSec(1)
        helper!!.toUrl(DefaultUtils.chromeVersion)
        val profileWE = helper!!.find(By.cssSelector(ButtonUtils.CssSelector.profilePath))
        val profileCache = helper!!.getTextInput(profileWE)
        this.profile = profileCache.replace("Default", "")
    }

//    fun addMemberGroup(driver: WebDriver, userName: String) {
//        Helper.findAndClick(driver, By.cssSelector(ButtonUtils.CssSelector.titleChat))
//        Helper.waitMill(100)
//        Helper.findAndClick(driver, By.cssSelector(ButtonUtils.CssSelector.addMemberBtn))
//        Helper.waitMill(100)
//        Helper.findAndClick(driver, By.cssSelector(ButtonUtils.CssSelector.popupSearchInput))
//        val searchMemberInput = driver.findElement(By.cssSelector(ButtonUtils.CssSelector.popupSearchInput))
//        searchMemberInput.click()
//        Helper.waitMill(100)
//        searchMemberInput.sendKeys(userName)
//        Helper.waitMill(1500)
////    wait.until(ExpectedConditions.invisibilityOfElementLocated(firstMember))
//        Helper.findAndClick(driver, By.cssSelector(ButtonUtils.CssSelector.firstMemberA))
//        Helper.waitMill(100)
//        Helper.findAndClick(driver, By.xpath(ButtonUtils.Xpath.addButton))
//    }
}