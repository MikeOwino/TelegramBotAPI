package dev.inmo.tgbotapi.types.message.abstracts

import dev.inmo.tgbotapi.types.message.content.MessageContent

sealed interface CommonMessage<out T: MessageContent> : AccessibleMessage,
    PossiblyForwardedMessage,
    PossiblyEditedMessage,
    PossiblyReplyMessage,
    PossiblyMarkedUp,
    PossiblyBusinessMessage,
    PossiblyMediaGroupMessage<T>,
    ContentMessage<T>
