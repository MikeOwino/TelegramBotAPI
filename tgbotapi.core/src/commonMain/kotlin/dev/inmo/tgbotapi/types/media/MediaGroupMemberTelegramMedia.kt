package dev.inmo.tgbotapi.types.media

import dev.inmo.tgbotapi.abstracts.TextedOutput
import kotlinx.serialization.Serializable
import kotlinx.serialization.StringFormat

@Serializable(MediaGroupMemberTelegramFreeMediaSerializer::class)
sealed interface MediaGroupMemberTelegramMedia : TelegramMedia {
    fun serialize(format: StringFormat): String
}

@Serializable(MediaGroupMemberTelegramFreeMediaSerializer::class)
sealed interface MediaGroupMemberTelegramFreeMedia : MediaGroupMemberTelegramMedia, TextedOutput
@Serializable(MediaGroupMemberTelegramFreeMediaSerializer::class)
sealed interface MediaGroupMemberTelegramPaidMedia : MediaGroupMemberTelegramMedia

sealed interface AudioMediaGroupMemberTelegramMedia: MediaGroupMemberTelegramFreeMedia
sealed interface DocumentMediaGroupMemberTelegramMedia: MediaGroupMemberTelegramFreeMedia

@Serializable(MediaGroupMemberTelegramFreeMediaSerializer::class)
sealed interface VisualMediaGroupMemberTelegramMedia : MediaGroupMemberTelegramMedia

@Serializable(MediaGroupMemberTelegramFreeMediaSerializer::class)
sealed interface VisualMediaGroupMemberTelegramFreeMedia : MediaGroupMemberTelegramFreeMedia, VisualMediaGroupMemberTelegramMedia, SpoilerableTelegramMedia, WithCustomizableCaptionTelegramMedia

@Serializable(MediaGroupMemberTelegramPaidMediaSerializer::class)
sealed interface VisualMediaGroupMemberTelegramPaidMedia : MediaGroupMemberTelegramPaidMedia, VisualMediaGroupMemberTelegramMedia
