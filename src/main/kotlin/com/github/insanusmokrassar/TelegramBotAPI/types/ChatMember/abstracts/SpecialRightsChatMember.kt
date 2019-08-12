package com.github.insanusmokrassar.TelegramBotAPI.types.ChatMember.abstracts

interface SpecialRightsChatMember : ChatMember {
    val canChangeInfo: Boolean
    val canInviteUsers: Boolean
    val canPinMessages: Boolean
}
