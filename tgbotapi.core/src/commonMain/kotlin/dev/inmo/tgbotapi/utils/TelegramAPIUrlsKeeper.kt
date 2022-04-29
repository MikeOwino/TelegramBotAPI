package dev.inmo.tgbotapi.utils

const val telegramBotAPIDefaultUrl = "https://api.telegram.org"

private inline val String.withoutLastSlash: String
    get() {
        var correctedUrl = this
        while (true) {
            val withoutSuffix = correctedUrl.removeSuffix("/")
            if (withoutSuffix == correctedUrl) {
                return correctedUrl
            }
            correctedUrl = withoutSuffix
        }
    }

class TelegramAPIUrlsKeeper(
    token: String,
    hostUrl: String = telegramBotAPIDefaultUrl
) {
    val webAppDataSecretKey by lazy {
        token.hmacSha256("WebAppData")
    }

    val commonAPIUrl: String
    val fileBaseUrl: String

    init {
        val correctedHost = hostUrl.withoutLastSlash
        commonAPIUrl = "$correctedHost/bot$token"
        fileBaseUrl = "$correctedHost/file/bot$token"
    }

    fun createFileLinkUrl(filePath: String) = "${fileBaseUrl}/$filePath"

    /**
     * @param rawData Data from [dev.inmo.tgbotapi.webapps.WebApp.initData]
     * @param hash Data from [dev.inmo.tgbotapi.webapps.WebApp.initDataUnsafe] from the field [dev.inmo.tgbotapi.webapps.WebAppInitData.hash]
     */
    fun checkWebAppLink(rawData: String, hash: String) = rawData.hmacSha256(webAppDataSecretKey).hex() == hash
}
