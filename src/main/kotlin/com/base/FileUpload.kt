package com.base

import java.io.File
import java.io.FileReader

open class FileUpload {
    companion object {
        fun getMembersFromFile(pathFile:String): List<String> {
            val file = File(pathFile)
            return file.readLines()
        }
    }
}