package com.utils

class ButtonUtils {
    companion object {
        const val newChannelTitle = "New Channel"
        const val newGroupTitle = "New Group"
        const val newPrivateChatTitle = "New Private Chat"
    }

    class Xpath {
        companion object {
            const val newMenuBtn = "[id=\"new-menu\"]"
            const val addButton = "//span[text()=\"Add\"]/parent::button[contains(@class, 'btn')]"
            const val cancelBtn = "//*[contains(@class, 'popup-buttons')]//span[text()=\"Cancel\"]"
            const val newChannelBtn = "\"//*[contains(@class, 'btn-menu-item')]//span[text()=\"New Channel\"]\""
            const val newGroupBtn = "\"//*[contains(@class, 'btn-menu-item')]//span[text()=\"New Group\"]\""
            const val newPrivateChatBtn = "\"//*[contains(@class, 'btn-menu-item')]//span[text()=\"New Private Chat\"]\""
        }

        fun getMenuItem(item: String): String {
            return "//*[contains(@class, 'btn-menu-item')]//span[text()=\"${item}\"]"
        }
    }

    open class CssSelector {
        companion object {
            const val titleChat: String = ".person"
            const val addMemberBtn = ".can-add-members .btn-circle .c-ripple"
            const val popupSearchInput = ".popup .selector-search-input"
            const val containerSearchInput = ".selector-search-container .selector-search-input"
            const val firstMemberA = ".popup .chatlist a"
            const val firstMemberContainer = ".chatlist-container div.no-shadow .chatlist a.row:first-child div.c-ripple"
            const val checkBoxFirstMemberContainer = ".chatlist-container div.no-shadow .chatlist a.row .checkbox-field"
            const val addedMembersBtn = ".tabs-container .add-members-container.active .btn-circle"
            const val listMemberEmpty = ".chatlist-container div[class='selector-empty-placeholder']"
            const val profilePath = "td[id=profile_path]"
        }

    }
}
