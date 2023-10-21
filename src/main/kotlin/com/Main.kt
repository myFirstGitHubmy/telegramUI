package com

import com.base.Helper
import com.config.Driver
import com.service.ProcessPageService
import com.service.impl.ProcessPageServiceImpl
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait

fun main(args : Array<String>) {
    val processPageService: ProcessPageService = ProcessPageServiceImpl()
//    processPageService.getChromePathLocalVersion()
    processPageService.addMembersToGroup()
}

